package com.yanbin.lednumberlearning;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hungyanbin on 2015/5/14.
 */
public class LEDNumberFragment extends Fragment {

    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_led, container, false);

        RecyclerView rec_number = (RecyclerView)contentView.findViewById(R.id.rec_number);
        rec_number.setHasFixedSize(true);
        rec_number.setLayoutManager(new GridLayoutManager(context, 2));
        rec_number.setAdapter(new NumberAdapter(context));

        return contentView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = activity;
    }
}
