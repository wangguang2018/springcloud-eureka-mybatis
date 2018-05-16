package com.wgs.eurekaprovider.util;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.UUID;

public class StringHelper {


    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String objectToString(Object value, String defaultValue) {
        if (null == value) {
            return defaultValue;
        }
        return value.toString();
    }

    /**
     * 转Int
     *
     * @param str
     * @param defaultValue
     * @return 相应的值 或 零
     */
    public static int objectToInt(Object obj, int defaultValue) {
        String str = objectToString(obj, defaultValue + "");
        int i = 0;
        try {
            i = Integer.parseInt(str.trim());
        } catch (NumberFormatException e) {
            i = 0;
        }
        return i;
    }

    /**
     * 转short
     *
     * @param obj
     * @return 相应的值 或 零
     */
    public static short objectToShort(Object obj, short defaultValue) {
        String str = objectToString(obj, defaultValue + "");
        short i = 0;
        try {
            i = Short.parseShort(str.trim());
        } catch (NumberFormatException e) {
            i = 0;
        }
        return i;
    }

    /**
     * 转Double
     *
     * @param obj
     * @return 相应的值 或 零
     */
    public static double objectToDouble(Object obj, double defaultValue) {
        String str = objectToString(obj, defaultValue + "");
        double i = 0;
        try {
            i = Double.parseDouble(str.trim());
        } catch (NumberFormatException e) {
            i = 0;
        }
        return i;
    }

    /**
     * 转Long
     *
     * @param obj
     * @return 相应的值 或 零
     */
    public static long objectToLong(Object obj, long defaultValue) {
        String str = objectToString(obj, defaultValue + "");
        Long li = new Long(0);
        try {
            li = Long.valueOf(str);
        } catch (NumberFormatException e) {
        }
        return li.longValue();
    }

    // ***************** 其他类型相互转换 *****************

    /**
     * double转long
     *
     * @param d
     * @return 只截取前面的整数
     */
    public static long doubleToLong(double d) {
        long l = 0;
        try {
            // double转换成long前要过滤掉double类型小数点后数据
            l = Long.parseLong(String.valueOf(d).substring(0, String.valueOf(d).lastIndexOf(".")));
        } catch (Exception e) {
            l = 0;
        }
        return l;
    }

    /**
     * double转int
     *
     * @param d
     * @return 只截取前面的整数
     */
    public static int doubleToInt(double d) {
        int i = 0;
        try {
            // double转换成Int前要过滤掉double类型小数点后数据
            i = Integer.parseInt(String.valueOf(d).substring(0, String.valueOf(d).lastIndexOf(".")));
        } catch (Exception e) {
            i = 0;
        }
        return i;
    }

    /**
     * double转long(四舍五入)
     *
     * @param d
     * @return 只截取前面的整数 (四舍五入)
     */
    public static long doubleToLongWhithRound(double d) {
        long l = 0;
        try {
            l = Math.round(d);
        } catch (Exception e) {
            l = 0;
        }
        return l;
    }

    /**
     * double转int(四舍五入)
     *
     * @param d
     * @return 只截取前面的整数 (四舍五入)
     */
    public static int doubleToIntWhithRound(double d) {
        int i = 0;
        try {
            i = (int) Math.round(d);
        } catch (Exception e) {
            i = 0;
        }
        return i;
    }

    public static double longToDouble(long d) {
        double l = 0;
        try {
            l = Double.parseDouble(String.valueOf(d));
        } catch (Exception e) {
            l = 0;
        }
        return l;
    }

    public static int longToInt(long d) {
        int l = 0;
        try {
            l = Integer.parseInt(String.valueOf(d));
        } catch (Exception e) {
            l = 0;
        }
        return l;
    }

    /**
     * 获取随机验证码
     *
     * @param length
     * @return
     */
    public static String newRadomCode(int length) {
        final int maxNum = 36;
        int i; // 生成的随机数
        int count = 0; // 生成的密码的长度
        char[] str = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        StringBuffer pwd = new StringBuffer("");
        Random r = new Random();
        while (count < length) {
            i = Math.abs(r.nextInt(maxNum)); // 生成的数最大为36-1
            if (i >= 0 && i < str.length) {
                pwd.append(str[i]);
                count++;
            }
        }
        return pwd.toString();
    }

    /**
     * 获取非0的随机验证码
     *
     * @param length
     * @return
     */
    public static String newRadomCodeNotZero(int length) {
        final int maxNum = 36;
        int i; // 生成的随机数
        int count = 0; // 生成的密码的长度
        char[] str = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        StringBuffer pwd = new StringBuffer("");
        Random r = new Random();
        while (count < length) {
            i = Math.abs(r.nextInt(maxNum)); // 生成的数最大为36-1
            if (i >= 0 && i < str.length) {
                pwd.append(str[i]);
                count++;
            }
        }
        return pwd.toString();
    }

    /**
     * 操作平台
     *
     * @param length
     * @return
     */
    public static String newRadomCodePlat(int length) {
        final int maxNum = 36;
        int i; // 生成的随机数
        int count = 0; // 生成的长度
        char[] str = {'1', '2', '3'};
        StringBuffer pwd = new StringBuffer("");
        Random r = new Random();
        while (count < length) {
            i = Math.abs(r.nextInt(maxNum)); // 生成的数最大为36-1
            if (i >= 0 && i < str.length) {
                pwd.append(str[i]);
                count++;
            }
        }
        return pwd.toString();
    }



    /**
     * 生成条形码序列到数据库
     *
     * @param codeFlag 6表示接口  9表示收衣批量条码
     * @return
     */
    public static synchronized String createBarCode(String codeFlag) {
        String barCode = codeFlag + StringHelper.newRadomCode(11);
        Integer i1 = 0;
        Integer i2 = 0;
        for (int i = 0; i < barCode.length(); i++) {
            if (i % 2 == 0) {
                i1 += Integer.parseInt(barCode.substring(i, i + 1));
            } else {
                i2 += Integer.parseInt(barCode.substring(i, i + 1));
            }
        }
        Integer ret = i2 * 3 + i1;
        Integer w = 10 - (ret % 10);
        if (w == 10) {
            w = 0;
        }
        return barCode + w;
    }

    public static Integer seq = 0;



    /**
     * 获取当前网络ip
     *
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
                //根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress = inet.getHostAddress();
            }
        }
        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ipAddress != null && ipAddress.length() > 15) { //"***.***.***.***".length() = 15
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }

    /**
     * 将下划线大写方式命名的字符串转换为驼峰式。如果转换前的下划线大写方式命名的字符串为空，则返回空字符串。</br>
     * 例如：HELLO_WORLD->HelloWorld
     * @param name 转换前的下划线大写方式命名的字符串
     * @return 转换后的驼峰式命名的字符串
     */
    public static String camelName(String name) {
        StringBuilder result = new StringBuilder();
        // 快速检查
        if (name == null || name.isEmpty()) {
            // 没必要转换
            return "";
        } else if (!name.contains("_")) {
            // 不含下划线，仅将首字母小写
            return name.substring(0, 1).toLowerCase() + name.substring(1);
        }
        // 用下划线将原始字符串分割
        String camels[] = name.split("_");
        for (String camel :  camels) {
            // 跳过原始字符串中开头、结尾的下换线或双重下划线
            if (camel.isEmpty()) {
                continue;
            }
            // 处理真正的驼峰片段
            if (result.length() == 0) {
                // 第一个驼峰片段，全部字母都小写
                result.append(camel.toLowerCase());
            } else {
                // 其他的驼峰片段，首字母大写
                result.append(camel.substring(0, 1).toUpperCase());
                result.append(camel.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }


}
