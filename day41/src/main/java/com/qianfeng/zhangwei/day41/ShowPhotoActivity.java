package com.qianfeng.zhangwei.day41;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnItemClick;
import com.qianfeng.zhangwei.day41.adapter.ImageShowAdapter;
import com.qianfeng.zhangwei.day41.utils.FileUtils;

import java.io.File;
import java.util.ArrayList;


/**
 * 拍照完成 -->显示图片-->选择图片-->上传到服务器器
 */
@ContentView(R.layout.activity_showphoto)
public class ShowPhotoActivity extends AppCompatActivity {

    @ViewInject(R.id.gridview)
    private GridView gridView;
    private ArrayList<Bitmap> bitmaps = new ArrayList<>();
    private ImageShowAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewUtils.inject(this);
        initView();
        initData();

    }

    private void initView() {
        adapter = new ImageShowAdapter(bitmaps, this);
        gridView.setAdapter(adapter);
    }

    private void initData() {
        File imageFile = new File(FileUtils.getPhotoPath());
        if (imageFile != null && imageFile.exists()) {
            File[] files = imageFile.listFiles();
            if (files != null && files.length > 0) {
                for (File file : files) {
                    Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                    if (bitmap != null && FileUtils.getBitmapSize(bitmap) > 0) {
                        bitmaps.add(bitmap);
                    }
                }
                adapter.notifyDataSetChanged();
            }
        }
    }

    @OnItemClick(R.id.gridview)
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ImageShowAdapter.ViewHolder holder = (ImageShowAdapter.ViewHolder) view.getTag();
        if (holder.cb.isChecked()) {
            holder.cb.setChecked(false);
        } else {
            holder.cb.setChecked(true);
        }
    }
}
