package com.yanbin.lednumberlearning;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungyanbin on 2015/5/16.
 */
public class MathUtils {

    public static float dotProduct(List<Float> a, List<Float> b){
        float sum = 0;
        for(int i=0;i<a.size();i++)
            sum += a.get(i)*b.get(i);
        return sum;
    }

    public static void addVectors(List<Float> a, List<Float> b){
        for(int i=0;i<a.size();i++)
            a.set(i, a.get(i) + b.get(i));
    }

    public static float computeMSE(List<Float> a, List<Float> b){
        int size = a.size();
        float sum = 0;
        for(int i=0;i<size;i++) {
            float diff = Math.abs(a.get(i) - b.get(i));
            sum += diff ;
        }
        sum /= size;
        return sum;
    }
}
