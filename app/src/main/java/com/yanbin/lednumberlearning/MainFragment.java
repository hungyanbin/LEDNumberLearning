package com.yanbin.lednumberlearning;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungyanbin on 2015/5/14.
 */
public class MainFragment extends Fragment {

    private Context context;
    private ArtificialNeuralNetwork network;

    private final int SIGNAL_COUNT = 36;
    private final int NEURON_COUNT = 10;
    private final float CONDITION = 0.00001f;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_main, container, false);
        Button btn_start = (Button)contentView.findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                network = new ArtificialNeuralNetwork(SIGNAL_COUNT, NEURON_COUNT);
                for(int i=0;i<10;i++) {
                    network.addTrainingData(NumberFactory.getByInt(i), NumberFactory.getTarget(i));
                    Log.i("test", "target : " + NumberFactory.getTarget(i));
                }
                network.iterations(10000)
                        .progressListener(listener)
                        .weight(randomWeight(SIGNAL_COUNT, NEURON_COUNT))
                        .bias(randomBias(NEURON_COUNT))
                        .stopCondition(CONDITION);
                network.startAsync();
            }
        });

        return contentView;
    }

    private ArtificialNeuralNetwork.ProgressListener listener = new ArtificialNeuralNetwork.ProgressListener() {
        @Override
        public void onComplete(float errorValue) {
            List<Float> result = network.testData(NumberFactory.getTestZero());
            String candidate0 = getCandidateByResult(result);
            result = network.testData(NumberFactory.getTestEight());
            String candidate1 = getCandidateByResult(result);
            result = network.testData(NumberFactory.getTestOne());
            String candidate2 = getCandidateByResult(result);
            result = network.testData(NumberFactory.getTestSix());
            String candidate3 = getCandidateByResult(result);
            SPManager spManager = new SPManager(context);
            spManager.saveCandidates(candidate0, candidate1, candidate2, candidate3);
            ((Activity)context).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, "Training complete!!", Toast.LENGTH_LONG).show();
                }
            });

        }
    };

    private String getCandidateByResult(List<Float> result){
        float maxValue = 0f;
        String candidates = "";
        for(int i=0;i<result.size();i++){
            float currentValue = result.get(i);
            if(0.7 < currentValue) {
                candidates += i + ", ";
                maxValue = currentValue;
            }
        }

        return candidates;
    }

    private List<List<Float>> randomWeight(int signal, int neuron){
        List<List<Float>> weight = new ArrayList<>();
        for(int i=0;i<neuron;i++){
            List<Float> row = new ArrayList<>();
            for(int j=0;j<signal;j++){
                row.add((float)Math.random()*0.1f);
            }
            weight.add(row);
        }

        return weight;
    }

    private List<Float> randomBias(int neuron){
        List<Float> bias = new ArrayList<>();
        for(int j=0;j<neuron;j++){
            bias.add((float)Math.random()*0.1f);
        }
        return bias;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = activity;
    }
}
