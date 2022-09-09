package com.bw.movie.utils;

import com.bw.movie.cache.RedisPool;
import com.bw.movie.cache.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by xyj on 2018/7/17.
 */
public class Util {
    private static Logger logger = LoggerFactory.getLogger("Util");

    /**
     * 生成随机串
     *
     * @param length
     * @return
     */
    public static String createNonceStr(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String res = "";
        for (int i = 0; i < length; i++) {
            Random rd = new Random();
            res += chars.charAt(rd.nextInt(chars.length() - 1));
        }
        return res;
    }

    /**
     * 根据出生年月日计算当前具体年龄
     *
     * @param time
     * @return
     * @throws Exception
     */
    public static int getAge(String time) throws Exception {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date myDate = sdf.parse(time);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(myDate);

        int age = c.get(Calendar.YEAR) - c2.get(Calendar.YEAR);

        return age;
    }

    /**
     * 处理参数有效性
     *
     * @param str
     * @param defaultValue
     * @return
     */
    public static int convert(String str, int defaultValue) {
        if (str == null) return defaultValue;
        String s = str.trim();
        if (s.isEmpty() || s.equalsIgnoreCase("undefined") || s.equalsIgnoreCase("null")) return defaultValue;
        try {
            return Integer.parseInt(s);
        } catch (Throwable e) {
            return defaultValue;
        }
    }

    /**
     * base64加密
     *
     * @param str
     * @return
     */
    public static String base64(String str) {
        return new BASE64Encoder().encode(str.getBytes());
    }

    /**
     * MD5加密
     *
     * @param sourceStr
     * @return
     */
    public static String MD5(String sourceStr) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
//            System.out.println("MD5(" + sourceStr + ",32) = " + result);
//            System.out.println("MD5(" + sourceStr + ",16) = " + buf.toString().substring(8, 24));
        } catch (Exception e) {
            return null;
        }
        return result;
    }

    /**
     * 获取分页查询下标
     *
     * @param page
     * @param count
     * @return
     */
    public static int getPageIndex(int page, int count) {
        return (page - 1) * count;
    }

    /**
     * 密码转换
     *
     * @param pwd
     * @return
     */
    public static String conversionPwd(String pwd) {
        pwd = EncryptUtil.decrypt(pwd);
        pwd = MD5(pwd);
        return pwd;
    }

    public static String processMovieType(List<String> list) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(" / ");
            }
        }
        return sb.toString();
    }

    /**
     * 生成随机串(邮箱验证码)
     *
     * @param length
     * @return
     */
    public static String createCheckCode(int length) {
        String chars = "0123456789";
        String res = "";
        for (int i = 0; i < length; i++) {
            Random rd = new Random();
            res += chars.charAt(rd.nextInt(chars.length() - 1));
        }
        return res;
    }

    /**
     * 生成随机串
     *
     * @param length
     * @return
     */
    public static String create_nonce_str(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String res = "";
        for (int i = 0; i < length; i++) {
            Random rd = new Random();
            res += chars.charAt(rd.nextInt(chars.length() - 1));
        }
        return res;
    }

    /**
     * 生成随机不重复的数组
     *
     * @param length
     * @return
     */
    public static int[] generateRandomNumber(int length) {
        List<Integer> result = new ArrayList<>();
        int values[] = new int[length];
        int temp1, temp2, temp3;
        Random r = new Random();
        for (int i = 0; i < values.length; i++) {
            values[i] = i + 1;
        }

        //随机交换values.length次
        for (int i = 0; i < values.length; i++) {
            temp1 = Math.abs(r.nextInt()) % (values.length - 1); //随机产生一个位置
            temp2 = Math.abs(r.nextInt()) % (values.length - 1); //随机产生另一个位置

            if (temp1 != temp2) {
                temp3 = values[temp1];
                values[temp1] = values[temp2];
                values[temp2] = temp3;
            }
        }
        return values;
    }


    public static void main(String[] args) {
        String[] str = {"李三", "张四", "王五", "李六", "张七七", "王九"};
        HashMap<String, Integer> map = new HashMap<>();
        Arrays.asList(str).forEach(x -> {
            int i = 1;
            if (map.get(String.valueOf(x.charAt(0))) != null) {
                i = map.get(String.valueOf(x.charAt(0))) + 1;
            }
            map.put(String.valueOf(x.charAt(0)), i);
        });
        //遍历map
        map.forEach((k, v) -> {
            System.out.println(k + " = " + v);
        });

    }


    public static int checkCode(String email, String code) {
        RedisPool redisPool = RedisUtil.getRedisPool(RedisConstant.POOL_NAME);
        String key = String.format(RedisConstant.EMAIL_CODE_KEY, email);
        String s = redisPool.get(key);
        logger.info("checkCode: code={},s={}", code, s);
        if (s == null || "".equals(s)) {
            //验证码过期
            return 3;
        }
        if (!code.equals(s)) {
            //验证码错误
            return 4;
        }
        return 1;
    }

    public static List<String> getAfterDate7(int length) {
        Calendar calAfter = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
        String format = "";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            Date today = calAfter.getTime();
            format = sdf.format(today);
            list.add(format);
            calAfter.set(Calendar.DATE, calAfter.get(Calendar.DATE) + 1);
        }
        return list;
    }


}
