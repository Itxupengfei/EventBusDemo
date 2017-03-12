package com.xu.eventbusdemo.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xu.eventbusdemo.R;
import com.xu.eventbusdemo.event.EventMsg;
import com.xu.eventbusdemo.event.EventMsg2;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {


    private TextView mViewById;

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //注册观察者
        EventBus.getDefault().register(this);
    }
    //注销观察者
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewById = (TextView) view.findViewById(R.id.tv_center);
    }

    /**
     * 此代码与发送者运行在同一线程
     * 同时该注解也是订阅者,表示订阅
     * @param text
     */
    @Subscribe(threadMode = ThreadMode.POSTING)
    public void setText1(EventMsg  text){
        Log.e("收到消息",Thread.currentThread().getName()+" ID:"+Thread.currentThread().getId());
        mViewById.setText(text.getMsg());
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void setText2(EventMsg  text){
        Log.e("收到消息",Thread.currentThread().getName()+" ID:"+Thread.currentThread().getId());
        mViewById.setText(text.getMsg());
    }
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void setText3(EventMsg  text){
        Log.e("收到消息",Thread.currentThread().getName()+" ID:"+Thread.currentThread().getId());
        mViewById.setText(text.getMsg());
    }
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void setText4(EventMsg  text){
        Log.e("收到消息",Thread.currentThread().getName()+" ID:"+Thread.currentThread().getId());
        mViewById.setText(text.getMsg());
    }
    @Subscribe(threadMode = ThreadMode.POSTING)
    public void setText5(EventMsg2 text){
        Log.e("收到消息1",Thread.currentThread().getName()+" ID:"+Thread.currentThread().getId());
        mViewById.setText(text.getMsg());
    }
}
