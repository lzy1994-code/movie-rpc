package com.bw.movie.utils;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

/**
 * Created by xyj on 2018/1/11.
 */
public class ConfigInfo {

    private static ConfigInfo configInfo;

    private static long last_reload_time = 0;

    private static boolean isReload() {
        long nowTime = new Date().getTime();
        if ((nowTime - last_reload_time) > 5000) {
            last_reload_time = nowTime;
            return true;
        }
        return false;
    }

    private String headUrl;

    private String QRCodeUploadPath;

    private String QRCodeAccessPath;

    private String getTicket;

    public String getHeadUrl() {
        return headUrl;
    }

    public String getQRCodeUploadPath() {
        return QRCodeUploadPath;
    }

    public String getQRCodeAccessPath() {
        return QRCodeAccessPath;
    }

    public String getGetTicket() {
        return getTicket;
    }


    public static ConfigInfo getConfigInfo() {
        if (configInfo == null) {
            configInfo = new ConfigInfo();
            initInfo();
        }
        if (isReload()) {
            initInfo();
        }
        return configInfo;
    }

    private static void initInfo() {
        try {
            Properties p = PropertiesUtil.getProperties("properties/config_info.properties", "utf-8");
            configInfo.headUrl = p.getProperty("head_url");
            configInfo.QRCodeUploadPath = p.getProperty("QR_code_upload_path");
            configInfo.QRCodeAccessPath = p.getProperty("QR_code_access_path");
            configInfo.getTicket = p.getProperty("get_ticket");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        String qrCodeUploadPath = ConfigInfo.getConfigInfo().getGetTicket();
        System.out.println(qrCodeUploadPath);
    }
}
