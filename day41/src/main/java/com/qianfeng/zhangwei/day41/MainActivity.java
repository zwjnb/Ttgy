package com.qianfeng.zhangwei.day41;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.qianfeng.zhangwei.day41.utils.FileUtils;

import java.io.File;

/**
 * 1>多媒体  拍照
 * 2> 数据提交
 * 3> 文件上传
 *
 * 数据提交
 * 文件上传
 * 文件下载
 *
 * 第一 拍照
 * 调用系统相机获取图片
 * 调用系统相机指定文件保存图片
 *
 * 功能
 *
 * 拍照完成 -->显示图片-->选择图片-->上传到服务器器
 */
@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    @ViewInject(R.id.btn)
    private Button btn;
    @ViewInject(R.id.photo_btn)
    private Button photoBtn;
    @ViewInject(R.id.update_btn)
    private Button updateBtn;
    @ViewInject(R.id.img)
    private ImageView img;

    public static final int REQUEST_CODE = 1113;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewUtils.inject(this);
    }

    @OnClick({R.id.btn, R.id.photo_btn,R.id.update_btn})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                photo1();
                break;
            case R.id.photo_btn:
                photoToPath();
                break;
            case R.id.update_btn:
                startActivity(new Intent(this, ShowPhotoActivity.class));
                break;
        }
    }

    /**
     * 调用系统相机返回图片
     */
    private void photo1() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CODE);
    }

    /**
     * sdk/day41/photo/20150630411111.png
     */

    private void photoToPath() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File file = FileUtils.getImageFile();
        if (file != null) {
            Uri uri = Uri.fromFile(file);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            startActivity(intent);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_CODE) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            if (bitmap != null) {
                img.setImageBitmap(bitmap);
            }
        }
    }


}
