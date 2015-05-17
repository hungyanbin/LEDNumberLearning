package com.yanbin.lednumberlearning;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hungyanbin on 2015/5/14.
 */
public class NumberFactory {

    public static List<Float> getByInt(int number){
        switch (number){
            case 0:
                return getZero();
            case 1:
                return getOne();
            case 2:
                return getTwo();
            case 3:
                return getThree();
            case 4:
                return getFour();
            case 5:
                return getFive();
            case 6:
                return getSix();
            case 7:
                return getSeven();
            case 8:
                return getEight();
            case 9:
                return getNine();
        }

        throw new IllegalArgumentException("number range is 0~10!!");
    }
    
    public static List<Float> getTarget(int number){
        Float[] floatArr = new Float[]{0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f};
        List<Float> targets = Arrays.asList(floatArr);
        targets.set(number, 1f);
        return targets;
    }

    public static List<Float> getZero(){
        Float[] floatArray = new Float[]{
                1f, 1f, 1f, 1f,
                1f, 0f, 0f, 1f,
                1f, 0f, 0f, 1f,
                1f, 0f, 0f, 1f,
                1f, 0f, 0f, 1f,
                1f, 0f, 0f, 1f,
                1f, 0f, 0f, 1f,
                1f, 0f, 0f, 1f,
                1f, 1f, 1f, 1f};

        return floatArrayToList(floatArray);
    }

    public static List<Float> getTestZero(){
        Float[] floatArray = new Float[]{
                1f, 0f, 1f, 1f,
                1f, 0f, 0f, 1f,
                1f, 0f, 0f, 1f,
                1f, 0f, 0f, 1f,
                1f, 0f, 0f, 1f,
                1f, 0f, 0f, 1f,
                1f, 0f, 0f, 1f,
                1f, 0f, 1f, 1f,
                1f, 1f, 1f, 1f};

        return floatArrayToList(floatArray);
    }

    public static List<Float> getOne(){
        Float[] floatArray = new Float[]{
                0f, 0f, 0f, 1f,
                0f, 0f, 0f, 1f,
                0f, 0f, 0f, 1f,
                0f, 0f, 0f, 1f,
                0f, 0f, 0f, 1f,
                0f, 0f, 0f, 1f,
                0f, 0f, 0f, 1f,
                0f, 0f, 0f, 1f,
                0f, 0f, 0f, 1f};

        return floatArrayToList(floatArray);
    }

    public static List<Float> getTestOne(){
        Float[] floatArray = new Float[]{
                0f, 0f, 0f, 1f,
                0f, 0f, 1f, 1f,
                0f, 0f, 0f, 1f,
                0f, 0f, 0f, 1f,
                0f, 0f, 0f, 1f,
                0f, 0f, 0f, 1f,
                0f, 0f, 0f, 1f,
                0f, 0f, 0f, 1f,
                0f, 1f, 1f, 1f};

        return floatArrayToList(floatArray);
    }

    public static List<Float> getTwo(){
        Float[] floatArray = new Float[]{
                1f, 1f, 1f, 1f,
                0f, 0f, 0f, 1f,
                0f, 0f, 0f, 1f,
                0f, 0f, 0f, 1f,
                1f, 1f, 1f, 1f,
                1f, 0f, 0f, 0f,
                1f, 0f, 0f, 0f,
                1f, 0f, 0f, 0f,
                1f, 1f, 1f, 1f};

        return floatArrayToList(floatArray);
    }

    public static List<Float> getThree(){
        Float[] floatArray = new Float[]{
                1f, 1f, 1f, 1f,
                0f, 0f, 0f, 1f,
                0f, 0f, 0f, 1f,
                0f, 0f, 0f, 1f,
                1f, 1f, 1f, 1f,
                0f, 0f, 0f, 1f,
                0f, 0f, 0f, 1f,
                0f, 0f, 0f, 1f,
                1f, 1f, 1f, 1f};

        return floatArrayToList(floatArray);
    }

    public static List<Float> getFour(){
        Float[] floatArray = new Float[]{
                1f, 0f, 0f, 1f,
                1f, 0f, 0f, 1f,
                1f, 0f, 0f, 1f,
                1f, 0f, 0f, 1f,
                1f, 1f, 1f, 1f,
                0f, 0f, 0f, 1f,
                0f, 0f, 0f, 1f,
                0f, 0f, 0f, 1f,
                0f, 0f, 0f, 1f};

        return floatArrayToList(floatArray);
    }

    public static List<Float> getFive(){
        Float[] floatArray = new Float[]{
                1f, 1f, 1f, 1f,
                1f, 0f, 0f, 0f,
                1f, 0f, 0f, 0f,
                1f, 0f, 0f, 0f,
                1f, 1f, 1f, 1f,
                0f, 0f, 0f, 1f,
                0f, 0f, 0f, 1f,
                0f, 0f, 0f, 1f,
                1f, 1f, 1f, 1f};

        return floatArrayToList(floatArray);
    }

    public static List<Float> getSix(){
        Float[] floatArray = new Float[]{
                1f, 1f, 1f, 1f,
                1f, 0f, 0f, 0f,
                1f, 0f, 0f, 0f,
                1f, 0f, 0f, 0f,
                1f, 1f, 1f, 1f,
                1f, 0f, 0f, 1f,
                1f, 0f, 0f, 1f,
                1f, 0f, 0f, 1f,
                1f, 1f, 1f, 1f};

        return floatArrayToList(floatArray);
    }

    public static List<Float> getTestSix(){
        Float[] floatArray = new Float[]{
                1f, 1f, 0f, 0f,
                1f, 0f, 0f, 0f,
                1f, 0f, 0f, 0f,
                1f, 0f, 0f, 0f,
                1f, 1f, 1f, 1f,
                1f, 0f, 0f, 1f,
                1f, 0f, 0f, 1f,
                1f, 0f, 0f, 1f,
                1f, 1f, 1f, 1f};

        return floatArrayToList(floatArray);
    }

    public static List<Float> getSeven(){
        Float[] floatArray = new Float[]{
                1f, 1f, 1f, 1f,
                0f, 0f, 0f, 1f,
                0f, 0f, 0f, 1f,
                0f, 0f, 0f, 1f,
                0f, 0f, 0f, 1f,
                0f, 0f, 0f, 1f,
                0f, 0f, 0f, 1f,
                0f, 0f, 0f, 1f,
                0f, 0f, 0f, 1f};

        return floatArrayToList(floatArray);
    }

    public static List<Float> getEight(){
        Float[] floatArray = new Float[]{
                1f, 1f, 1f, 1f,
                1f, 0f, 0f, 1f,
                1f, 0f, 0f, 1f,
                1f, 0f, 0f, 1f,
                1f, 1f, 1f, 1f,
                1f, 0f, 0f, 1f,
                1f, 0f, 0f, 1f,
                1f, 0f, 0f, 1f,
                1f, 1f, 1f, 1f};

        return floatArrayToList(floatArray);
    }

    public static List<Float> getTestEight(){
        Float[] floatArray = new Float[]{
                0f, 1f, 1f, 1f,
                1f, 0f, 0f, 1f,
                1f, 0f, 0f, 1f,
                1f, 1f, 0f, 1f,
                1f, 1f, 1f, 1f,
                1f, 0f, 0f, 1f,
                1f, 0f, 0f, 1f,
                1f, 0f, 0f, 1f,
                1f, 1f, 1f, 1f};

        return floatArrayToList(floatArray);
    }

    public static List<Float> getNine(){
        Float[] intnArray = new Float[]{
                1f, 1f, 1f, 1f,
                1f, 0f, 0f, 1f,
                1f, 0f, 0f, 1f,
                1f, 0f, 0f, 1f,
                1f, 1f, 1f, 1f,
                0f, 0f, 0f, 1f,
                0f, 0f, 0f, 1f,
                0f, 0f, 0f, 1f,
                1f, 1f, 1f, 1f};

        return floatArrayToList(intnArray);
    }

    private static List<Float> floatArrayToList(Float[] array){
        List<Float> list = Arrays.asList(array);

        return list;
    }
}
