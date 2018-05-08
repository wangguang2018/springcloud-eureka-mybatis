package com.wgs.eurekaprovider.util;

import com.aliyun.oss.OSSClient;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.RandomStringUtils;

import java.io.InputStream;
import java.util.Arrays;

/**
 * @Desc com.cyk.oss
 * @Author peakren
 * @Date 26/12/2016 2:33 PM
 */
public class OSSHelper {

    private static String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
    private static String accessKeyId = "LTAIALhDnclBYATv";
    private static String accessKeySecret = "4i9zJ5aDljBkFVRbp8pazK1l21XS79";
    private static String bucketName = "yingdd";
    private static String bucketURI = "https://yingdd.oss-cn-hangzhou.aliyuncs.com";


    /**
     * 文件上传
     *
     * @param filename 文件名
     * @param file     文件流
     * @return 文件地址
     */
    public static String upload(String filename, InputStream file) {
        // 创建OSSClient实例
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

        // 上传文件流
        String key = generateUniqueID(filename);
        ossClient.putObject(bucketName, key, file);

        // 关闭Client
        ossClient.shutdown();

        return bucketURI + "/" + key;
    }

    /**
     * 生成唯一id
     *
     * @param filename 文件名
     * @return 唯一id
     */
    public static String generateUniqueID(String filename) {
        return DigestUtils.md5Hex(RandomStringUtils.random(6) +
                System.currentTimeMillis()) +
                "." + FilenameUtils.getExtension(filename);
    }

    /**
     * 缩放图片
     *
     * @param imageURI 图片地址
     * @param mode     模式（默认lfit）
     * @param width    宽度
     * @param height   高度
     * @return 缩放后的地址
     */
    public static String resize(String imageURI, String mode, Integer width, Integer height) {
        imageURI += "?x-oss-process=image/resize";

        if (Arrays.asList("lfit", "mfit", "fill", "pad", "fixed").contains(mode)) {
            imageURI += (",m_" + mode);
        }

        if (width != null && width > 0) {
            imageURI += (",w_" + width);
        }

        if (height != null && height > 0) {
            imageURI += (",h_" + height);
        }

        return imageURI;
    }
}
