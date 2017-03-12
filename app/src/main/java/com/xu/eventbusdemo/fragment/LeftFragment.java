package com.xu.eventbusdemo.fragment;


import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.xu.eventbusdemo.event.EventMsg;
import com.xu.eventbusdemo.event.EventMsg2;

import org.greenrobot.eventbus.EventBus;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeftFragment extends ListFragment {

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String[] items={"主线程开始发送消息","子线程开始发送消息","主线程开始发送消息2"};
        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_expandable_list_item_1,items));

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        /**如果不使用EventBus,想调用Fragment里的方法要通过这种方式,这是在主线程中改变UI,如果我想在子线程中呢?*/
        //DetailFragment fragmentById = (DetailFragment) getFragmentManager().findFragmentById(R.id.fragment_detail);
       // fragmentById.setText("收到文字");

        switch (position) {
            case 0://主线程发消息
                Log.e("主线程发送消息",Thread.currentThread().getName()+" ID:"+Thread.currentThread().getId());
                EventBus.getDefault().post(new EventMsg("主线程发送来的消息"));
                break;
            case 1://子线程发消息

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("子线程发送消息",Thread.currentThread().getName()+" ID:"+Thread.currentThread().getId());
                        EventBus.getDefault().post(new EventMsg("子线程发送来的消息"));
                    }
                }).start();
                break;
            case 2://主线程发消息2
                EventBus.getDefault().post(new EventMsg2("主线程发送来的消息2"));
                break;
        }

    }
}
