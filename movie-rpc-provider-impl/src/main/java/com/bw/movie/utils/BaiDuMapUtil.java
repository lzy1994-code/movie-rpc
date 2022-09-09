package com.bw.movie.utils;


import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: movie-rpc
 * @description: 百度地图工具类
 * @author: Lzy
 * @create: 2018-08-13 13:36
 **/
public class BaiDuMapUtil {
    //百度ak
    private static String ak = "AQweUzqsOWyWGD7CALWfVt0lZeBYjRe3";
    //地球平均半径,单位千米
    private static final double EARTH_RADIUS = 6378.137;

    /**
     * 百度地图通过经纬度确定当前定位，传入参数经纬度
     *
     * @param lat
     * @param lng
     * @return
     */
    public static Object getStatus(String lat, String lng) {
        Object status = getLocationInfo(lat, lng).get("status");
        return String.valueOf(status);
    }

    public static JSONObject getLocationInfo(String lat, String lng) {
        String url = "http://api.map.baidu.com/geocoder/v2/?location=" + lat + "," + lng + "&output=json&ak=" + ak + "";
        String json = loadJSON(url);
        JSONObject obj = JSONObject.fromObject(json);
        System.out.println(obj);
        return obj;
    }

    /**
     * 百度地图通过地址来获取经纬度，传入参数address
     *
     * @param address
     * @return
     */
    public static Map<String, Double> getLngAndLat(String address) {
        Map<String, Double> map = new HashMap<>();
        String url = "http://api.map.baidu.com/geocoder/v2/?address=" + address + "&output=json&ak=" + ak + "";
        String json = loadJSON(url);
        JSONObject obj = JSONObject.fromObject(json);
        if (obj.get("status").toString().equals("0")) {
            double lng = obj.getJSONObject("result").getJSONObject("location").getDouble("lng");
            double lat = obj.getJSONObject("result").getJSONObject("location").getDouble("lat");
            map.put("lng", lng);
            map.put("lat", lat);
            System.out.println("经度：" + lng + "--- 纬度：" + lat);
        } else {
            System.out.println("未找到相匹配的经纬度！");
        }
        return map;

    }

    public static String loadJSON(String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL oracle = new URL(url);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine = null;
            while ((inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (Exception e) {
        }
        return json.toString();
    }

    /**
     * 把经纬度转为度（°）
     *
     * @param degree
     * @return
     */
    private static double getRadian(double degree) {
        return degree * Math.PI / 180.0;
    }

    /**
     * 依据经纬度计算两点之间的距离(单位：米)
     *
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return
     */
    public static int getDistance(String lat1, String lng1, String lat2, String lng2) {
        double a = getRadian(Double.parseDouble(lat1)) - getRadian(Double.parseDouble(lat2));// 两点纬度差
        double b = getRadian(Double.parseDouble(lng1)) - getRadian(Double.parseDouble(lng2));// 两点的经度差
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(getRadian(Double.parseDouble(lat1)))
                * Math.cos(getRadian(Double.parseDouble(lat2))) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS * 1000;
        //保留两位小数
        //  s =(double)Math.round(s*100)/100;
        //取整
        s = Math.floor(s);

        return (int) s;
    }

}

