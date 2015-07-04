package com.qianfeng.zhangwei.day41.utils;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Environment;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @说 明：
 * @项目名称：1506adc
 * @包 名： com.qianfeng.zhangwei.day39
 * @类 名：FileUtils
 * @创 建人：zhangwei
 * @创建时间：2015-06-30 09 : 53
 * @版 本：v1.0
 * @修 改人：
 * @修改时间：
 * @修改备注：
 */
public class FileUtils {
    /**
     * sdk/day41
     *
     * @return
     */
    public static String getRootPath() {
        String path = null;

        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            path = Environment.getExternalStorageDirectory() + File.separator + "day41";
        } else {
            path = Environment.getDataDirectory() + File.separator + "com.qianfeng.zhangwei.day41";
        }

        File rootFile = new File(path);
        if (!rootFile.exists()) {
            rootFile.mkdir();
        }
        return path;
    }

    /**
     * sdk/day41/photo
     * 获取拍照的文件夹
     *
     * @return
     */
    public static String getPhotoPath() {
        String imagePath = getRootPath() + File.separator + "photo";
        File imageFile = new File(imagePath);
        if (!imageFile.exists()) {
            imageFile.mkdirs();
        }
        return imagePath;
    }

    /**
     * 获取拍照图片的文件
     * sdk/day41/photo/20150630411111.png
     *
     * @return
     */
    public static File getImageFile() {

        String imageName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".png";
        String imagePath = getPhotoPath() + File.separator + imageName;
        File imageFile = new File(imagePath);
        if (!imageFile.exists()) {
            try {
                imageFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return imageFile;

    }


    public static long getBitmapSize(Bitmap bitmap) {
        int bitmapSize = 0;
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB_MR1) {
            bitmapSize = bitmap.getByteCount();
        } else {
            bitmapSize = bitmap.getHeight() * bitmap.getRowBytes();
        }
        return bitmapSize;
    }


}
