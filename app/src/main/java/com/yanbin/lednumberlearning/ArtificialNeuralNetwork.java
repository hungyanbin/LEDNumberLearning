package com.yanbin.lednumberlearning;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hungyanbin on 2015/5/16.
 */
public class ArtificialNeuralNetwork {

    private ProgressListener progressListener;
    private int iteration;
    private int signalCount;
    private int neuronCount;
    private float condition;
    private List<List<Float>> datas;
    private List<List<Float>> targets;
    private List<List<Float>> weight;
    private List<Float> bias;

    private List<Float> neurons;
    private float minError;
    private int currentTrainingIndex;
    private final float LEARNING_FACTOR = 0.035f;

    private final String LOGTAG = ArtificialNeuralNetwork.class.getSimpleName();

    public ArtificialNeuralNetwork(int signalCount, int neuronCount){
        minError = Float.MAX_VALUE;
        this.signalCount = signalCount;
        this.neuronCount = neuronCount;
        neurons = Arrays.asList(new Float[neuronCount]);

        datas = new ArrayList<>();
        targets = new ArrayList<>();
    }

    public ArtificialNeuralNetwork iterations(int iteration){
        this.iteration = iteration;
        return this;
    }

    public ArtificialNeuralNetwork addTrainingData(List<Float> data, List<Float> target){
        if(data.size() != signalCount || target.size() != neuronCount)
            throw new ArrayIndexOutOfBoundsException("wrong size for data or target : " + data.size() + " , " + target.size());
        datas.add(data);
        targets.add(target);
        return this;
    }

    public ArtificialNeuralNetwork stopCondition(float condition){
        this.condition = condition;
        return this;
    }

    public ArtificialNeuralNetwork weight(List<List<Float>> weight){
        this.weight = weight;
        return this;
    }

    public ArtificialNeuralNetwork bias(List<Float> bias){
        this.bias = bias;
        return this;
    }

    public ArtificialNeuralNetwork progressListener(ProgressListener listener){
        this.progressListener = listener;
        return this;
    }

    public List<Float> testData(List<Float> data){
        datas.set(0, data);
        currentTrainingIndex = 0;
        dotNeurons();
        biasNeurons();

        return neurons;
    }

    /**
     * Algorithm:
     * Do Loop for every data and "iteration" times
     *  until match end condition
     *      1. dotProduct for every neuron
     *      2. add bias for every neruon
     *      3. check end condition
     *      4. update new weight & bias for next iteration
     */
    public void start(){
        for(int i=0;i<iteration; i++){
            for(currentTrainingIndex = 0;currentTrainingIndex<datas.size();currentTrainingIndex++) {
                dotNeurons();
                biasNeurons();
                if (isMatchCondition()) {
                    progressListener.onComplete(minError);
                    return;
                }
                updateWeights();
                updateBias();
            }
        }
        progressListener.onComplete(minError);
    }

    public void startAsync(){
        Thread networkThread = new Thread(new Runnable() {
            @Override
            public void run() {
                start();
            }
        });
        networkThread.start();
    }

    private void dotNeurons(){
        List<Float> currentData = datas.get(currentTrainingIndex);
        for(int neuronIndex = 0;neuronIndex<neuronCount;neuronIndex++){
            List<Float> currentWeight = weight.get(neuronIndex);
            neurons.set(neuronIndex, MathUtils.dotProduct(currentData, currentWeight));
        }
    }

    private void biasNeurons(){
        MathUtils.addVectors(neurons, bias);
    }

    private boolean isMatchCondition(){
        float errorValue = MathUtils.computeMSE(targets.get(currentTrainingIndex), neurons);
        Log.i(LOGTAG, "new error: " + errorValue);
        if(errorValue < minError)
            minError = errorValue;

        return minError < condition;
    }

    /**
     * for every i, j
     *   dW     =   W    +   T * e * x
     *       i,j           i,j              j     i
     */
    private void updateWeights(){
        for(int j=0;j<neuronCount;j++){
            float error = targets.get(currentTrainingIndex).get(j) - neurons.get(j);
            for(int i=0;i<signalCount;i++){
                float delta = weight.get(j).get(i) + LEARNING_FACTOR * error * datas.get(currentTrainingIndex).get(i);
                weight.get(j).set(i, delta);
            }
        }
    }

    /**
     * for every j
     *   dB     =       B   +     (-  T * e)
     *       j                j                     j
     */
    private void updateBias(){
        for(int j=0;j<neuronCount;j++){
            float error = targets.get(currentTrainingIndex).get(j) - neurons.get(j);
            float delta = error * LEARNING_FACTOR;
            bias.set(j, bias.get(j) + delta);
        }
    }

    public List<Float> getBias(){
        return null;
    }

    public List<List<Float>> getWeights(){
        return null;
    }

    public interface ProgressListener{
        public void onComplete(float errorValue);
    }

}
