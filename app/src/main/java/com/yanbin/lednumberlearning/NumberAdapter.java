package com.yanbin.lednumberlearning;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hungyanbin on 2015/5/14.
 */
public class NumberAdapter extends RecyclerView.Adapter<NumberAdapter.LEDViewHolder> {

    private Context context;
    private LayoutInflater mLayoutInflater;

    public NumberAdapter(Context context) {
        this.context = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public NumberAdapter.LEDViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new LEDViewHolder(mLayoutInflater.inflate(R.layout.recycle_led, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(NumberAdapter.LEDViewHolder viewHolder, int i) {
        viewHolder.ledView.setNumber(NumberFactory.getByInt(i));
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class LEDViewHolder extends RecyclerView.ViewHolder{

        private LEDView ledView;

        public LEDViewHolder(View itemView) {
            super(itemView);
            ledView = (LEDView)itemView.findViewById(R.id.led_view);
        }
    }
}
