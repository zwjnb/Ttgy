package com.qianfeng.zhangwei.day41;

import android.app.Application;
import android.widget.Toast;

/**
 * @说 明：
 * @项目名称：1506adc
 * @包 名： com.qianfeng.zhangwei.day39
 * @类 名：BaseApp
 * @创 建人：zhangwei
 * @创建时间：2015-06-30 11 : 38
 * @版 本：v1.0
 * @修 改人：
 * @修改时间：
 * @修改备注：
 */
public class BaseApp extends Application {
    private static BaseApp app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public static BaseApp getInstance() {
        return app;
    }


    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


}
