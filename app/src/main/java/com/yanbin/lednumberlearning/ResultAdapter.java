package com.yanbin.lednumberlearning;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hungyanbin on 2015/5/14.
 */
public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.LEDViewHolder> {

    private Context context;
    private LayoutInflater mLayoutInflater;

    public ResultAdapter(Context context) {
        this.context = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ResultAdapter.LEDViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new LEDViewHolder(mLayoutInflater.inflate(R.layout.recycle_led, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(ResultAdapter.LEDViewHolder viewHolder, int i) {
        SPManager spManager = new SPManager(context);
        List<String> candidates = spManager.getCandidates();
        switch (i) {
            case 0:
                viewHolder.ledView.setNumber(NumberFactory.getTestZero());
                viewHolder.txt_candidate.setText(candidates.get(0));
                break;
            case 1:
                viewHolder.ledView.setNumber(NumberFactory.getTestEight());
                viewHolder.txt_candidate.setText(candidates.get(1));
                break;
            case 2:
                viewHolder.ledView.setNumber(NumberFactory.getTestOne());
                viewHolder.txt_candidate.setText(candidates.get(2));
                break;
            default:
                viewHolder.ledView.setNumber(NumberFactory.getTestSix());
                viewHolder.txt_candidate.setText(candidates.get(3));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public static class LEDViewHolder extends RecyclerView.ViewHolder{

        private LEDView ledView;
        private TextView txt_candidate;

        public LEDViewHolder(View itemView) {
            super(itemView);
            ledView = (LEDView)itemView.findViewById(R.id.led_view);
            txt_candidate = (TextView)itemView.findViewById(R.id.txt_candidate);
        }
    }
}
