package com.jt.sewage.utils;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.util.HashSet;
import java.util.Set;

public class MyUtils {
    private static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    /**
     * 从一个对象拷贝到另一个对象，Null值不拷贝
     * @param from
     * @param to
     */
    public static void copyBeanNotNullAttribute(Object from,Object to){
        BeanUtils.copyProperties(from, to, getNullPropertyNames(from));
    }


    /**
     * 将本地图片进行Base64位编码
     *
     * @param src
     *            图片的url路径，如http://.....xx.jpg
     * @return
     */
    public static String encodeImgageToBase64(String src) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        File imageFile = new File(src);
        ByteArrayOutputStream outputStream = null;
        try {
            BufferedImage bufferedImage = ImageIO.read(imageFile);
            outputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "jpg", outputStream);
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(outputStream.toByteArray());// 返回Base64编码过的字节数组字符串
    }

    /**
     * 将Base64位编码的图片进行解码，并保存到指定目录
     *
     * @param base64
     *            base64编码的图片信息
     * @return
     */
    public static void decodeBase64ToImage(String base64, String path,
                                           String imgName) {
//        BASE64Decoder decoder = new BASE64Decoder();
//        try {
//            FileOutputStream write = new FileOutputStream(new File(path
//                    + imgName));
//            byte[] decoderBytes = decoder.decodeBuffer(base64);
//            write.write(decoderBytes);
//            write.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        byte[] base64Byte = Base64.decodeBase64(base64);

        try {
            OutputStream out = new FileOutputStream(path +imgName);
            out.write(base64Byte);
            out.flush();
            out.close();
            //return true;
        } catch (Exception e) {
            e.printStackTrace();
            //return false;
        }
    }
    /**
     *  创建文件上传路径
     * @param path
     */
    public static void mkdir(String path) {
        File fd = null;
        try {
            fd = new File(path);
            if (!fd.exists()) {
                fd.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fd = null;
        }
    }
    /**
     * 下载本地文件
     * @param response
     * @param filePath
     * @param encode
     */
    public static void downloadFile(HttpServletResponse response, String filePath, String encode) {
        response.setContentType("text/html;charset=" + encode);
        try {
            // 读到流中
            InputStream inStream = new FileInputStream(filePath); // 文件的存放路径
            // path是指欲下载的文件的路径
            File file = new File(filePath);
            // 取得文件名
            String fileName = file.getName();
            // 设置输出的格式
            response.reset();
            response.setContentType("bin");
            response.addHeader("Content-Disposition", "attachment; filename=\"" + new String(fileName.getBytes(encode), "ISO8859-1") + "\"");
            // 循环取出流中的数据
            byte[] b = new byte[100];
            int len;
            while ((len = inStream.read(b)) > 0) {
                response.getOutputStream().write(b, 0, len);
            }
            inStream.close();
        } catch (IOException  e) {
            System.out.println(e);
        }
    }

}
