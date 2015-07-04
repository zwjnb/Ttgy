package com.example.apple.fragment;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.apple.Adapter.Main_ViewPager_Adapter;
import com.example.apple.BaseApp;
import com.example.apple.R;
import com.example.apple.Utils.Final_utils;
import com.example.apple.Utils.HttpJson;
import com.example.apple.Utils.HttpMix;
import com.example.apple.Utils.URL_connt;
import com.example.apple.bean.Mix_Banner;
import com.example.apple.bean.Rotation;
import com.example.apple.sync.View_sync;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 15-6-22.
 */
public class Head_fragment extends Fragment {
    private Map<String, String> map;
    private List<ImageView> list_image = new ArrayList<>();
    private Main_ViewPager_Adapter MPA;
    private DisplayImageOptions options;
    private ViewPager vp;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ImageView mix_image1;
    private ImageView mix_image2;
    private ImageView mix_image3;
    private ImageView mix_image1_below;
    private ImageView mix_image2_below;
    private ImageView mix_image3_below;
    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Guoshi.
     */
    // TODO: Rename and change types and number of parameters
    public static Guoshi newInstance(String param1, String param2) {
        Guoshi fragment = new Guoshi();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Head_fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.head_fragment, container, false);

        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {


        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.ss) // ����ͼƬ�����ڼ���ʾ��ͼƬ
                .showImageForEmptyUri(R.drawable.ss) // ����ͼƬUriΪ�ջ��Ǵ����ʱ����ʾ��ͼƬ
                .showImageOnFail(R.drawable.ss) // ����ͼƬ���ػ�������з��������ʾ��ͼƬ
                .cacheInMemory(true) // �������ص�ͼƬ�Ƿ񻺴����ڴ���
                .cacheOnDisk(true) // �������ص�ͼƬ�Ƿ񻺴���SD����
                .build(); // �������
        vp = (ViewPager) inflate.findViewById(R.id.head_viewpager);
        Map<String, String> stringStringMap = Final_utils.initView(map);

        new View_sync(stringStringMap, new View_sync.ViewHolder() {
            @Override
            public void send(String tList) {

                List<Rotation> json = HttpJson.getJSON(tList);

                for (int i = 0; i < json.size(); i++) {
                    ImageView imageView = new ImageView(getActivity());
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                    imageView.setLayoutParams(layoutParams);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    String photo = json.get(i).getPhoto();
                    ImageLoader.getInstance().displayImage(photo, imageView, options);
                    list_image.add(imageView);
                }
                MPA = new Main_ViewPager_Adapter(list_image);
                vp.setAdapter(MPA);
            }
        }).execute(URL_connt.URL_api);

        FrameLayout list_fl = (FrameLayout) inflate.findViewById(R.id.list_FrameLayout);
        List_Fragment list_fragment = new List_Fragment();
        int commit = getFragmentManager().beginTransaction().replace(R.id.list_FrameLayout, list_fragment).commit();
        //  FrameLayout top = (FrameLayout) inflate.findViewById(R.id.top_fragment);
        Top_fragment top_fragment = new Top_fragment();
        getFragmentManager().beginTransaction().replace(R.id.top_fragment, top_fragment).commit();
        Mix_fragment mix_fragment = new Mix_fragment();
        getFragmentManager().beginTransaction().replace(R.id.mix_fragment, mix_fragment).commit();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
