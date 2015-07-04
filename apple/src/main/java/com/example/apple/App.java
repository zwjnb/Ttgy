package com.example.apple;

import android.app.Application;
import android.util.Log;

import com.android.volley.toolbox.Volley;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

/**
 * Created by Administrator on 2015/6/21 0021.
 */
public class App extends Application {
    private boolean netState = false;
    private static App app;


    @Override
    public void onCreate() {

        super.onCreate();
        app = this;
        initImageLoaderConfiguration();
    }


    private void initImageLoaderConfiguration() {

        ImageLoaderConfiguration.Builder builder = new ImageLoaderConfiguration.Builder(this);
        // 设置图片缓存地址
        File imageCache = StorageUtils.getOwnCacheDirectory(this, "dota2/imageCache");
        builder.diskCache(new UnlimitedDiskCache(imageCache));
        // max width, max height，即保存的每个缓存文件的最大长宽
        builder.memoryCacheExtraOptions(480, 800);

        //线程池内加载的数量
        builder.threadPoolSize(5);
        //将保存的时候的URI名称用MD5 加密
        builder.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        //缓存的文件数量 ���������
        builder.diskCacheFileCount(100);
        // connectTimeout (5 s), readTimeout (20 s)超时时间
        builder.imageDownloader(new BaseImageDownloader(this, 5 * 1000, 20 * 1000));
        /**
         * ע����ȫ������
         */
        //开始构建
        ImageLoader.getInstance().init(builder.build());

    }


    public static App getInstance() {
        return app;
    }


    public boolean isNetState() {
        return netState;
    }

    public void setNetState(boolean netState) {
        this.netState = netState;
    }
}
