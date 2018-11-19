package com.macfu.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

/**
 * @Author: liming
 * @Date: 2018/11/19 17:44
 * @Description: 文件工具类
 */
public class FileUtils {
    public static String writeFile(InputStream inputstream, String fileName, String basePath) {
        String dateStr = DateUtils.getYYYYMMDD(new Date());
        // TODO 本地环境暂定
        File realFiel = new File(basePath + File.separator + dateStr);
        boolean flag = false;
        if (!realFiel.exists()) {
            flag = realFiel.mkdirs();
        }
        OutputStream os = null;
        try {
            os = new FileOutputStream(basePath + File.separator + dateStr + File.separator + fileName);
            int len;
            byte[] bs = new byte[1024];
            while ((len = inputstream.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
            return File.separator + dateStr + File.separator + fileName;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
                if (inputstream != null) {
                    inputstream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static byte[] fileToByte(File file) {
        byte[] buffer = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

    public static byte[] fileToByte(String filePath) {
        byte[] buffer = null;
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

}
