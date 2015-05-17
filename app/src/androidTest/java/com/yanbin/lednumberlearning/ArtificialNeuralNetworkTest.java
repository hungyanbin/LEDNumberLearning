package com.yanbin.lednumberlearning;

import android.test.AndroidTestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by hungyanbin on 2015/5/16.
 */
public class ArtificialNeuralNetworkTest extends AndroidTestCase{

    private ArtificialNeuralNetwork network;

    private final int SIGNAL_COUNT = 3;
    private final int NEURON_COUNT = 2;
    private float actualError = -1;
    private boolean responseReceived = false;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        network = new ArtificialNeuralNetwork(SIGNAL_COUNT, NEURON_COUNT);
        network.bias(getBias())
                .weight(getWeight())
                .addTrainingData(getSample(), getTarget());
    }

    public void test_iteration_one(){
        //arranage
        responseReceived = false;
        final long waitLimit = 10000;
        final float expectError = 0.15f;
        final int ITERATION = 1;
        final float ERROR_BIG = 10000f;
        ArtificialNeuralNetwork.ProgressListener listener = new ArtificialNeuralNetwork.ProgressListener() {
            @Override
            public void onComplete(float errorValue) {
                responseReceived = true;
                actualError = errorValue;
            }
        };

        network.progressListener(listener)
                .iterations(ITERATION)
                .stopCondition(ERROR_BIG);
        //act
        network.start();
        //waitResponse(waitLimit);
        //assert
        assertTrue(Math.abs(expectError - actualError) < 0.0001);
    }

    public void test_iteration_two(){
        //arranage
        responseReceived = false;
        final long waitLimit = 10000;
        final float expectError = 0.1f;
        final int ITERATION = 1000;
        final float ERROR_BIG = 0.1f;
        ArtificialNeuralNetwork.ProgressListener listener = new ArtificialNeuralNetwork.ProgressListener() {
            @Override
            public void onComplete(float errorValue) {
                responseReceived = true;
                actualError = errorValue;
            }
        };

        network.progressListener(listener)
                .addTrainingData(getSample2(), getTarget2())
                .weight(getWeight2())
                .iterations(ITERATION)
                .stopCondition(ERROR_BIG);
        //act
        network.start();
        //assert
        assertTrue(Math.abs(expectError - actualError) < 0.1);
    }

    private void waitResponse(long waitLimit){
        long startTime = new Date().getTime();
        while(! responseReceived) {
            if (new Date().getTime() - startTime > waitLimit)
                throw new TestTimeoutException();

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                //oops!!
            }
        }
    }

    private List<Float> getBias(){
        return Arrays.asList(0.1f, 0.2f);
    }

    private List<List<Float>> getWeight(){
        List<List<Float>> weight = new ArrayList<>();
        weight.add(Arrays.asList(0f, 1f, 0f));
        weight.add(Arrays.asList(1f, 0f, 1f));
        return weight;
    }

    private List<List<Float>> getWeight2(){
        List<List<Float>> weight = new ArrayList<>();
        weight.add(Arrays.asList(0f, 0.1f, 0f));
        weight.add(Arrays.asList(-0.1f, 0f, 0.2f));
        return weight;
    }

    private List<Float> getSample(){
        return Arrays.asList(1f, 0f, 0f);
    }

    private List<Float> getTarget(){
        return Arrays.asList(0f, 1f);
    }

    private List<Float> getSample2(){
        return Arrays.asList(0f, 1f, 0f);
    }

    private List<Float> getTarget2(){
        return Arrays.asList(1f, 0f);
    }
}
