package com.yanbin.lednumberlearning;

import android.test.AndroidTestCase;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hungyanbin on 2015/5/16.
 */
public class MathUtilsTest extends AndroidTestCase{

    public void test_dotProduct(){
        final float expectResult = 11f;
        List<Float> a = Arrays.asList(1f, 2f, 3f);
        List<Float> b = Arrays.asList(1f, 2f, 2f);
        //act
        float actualResult = MathUtils.dotProduct(a, b);
        //assert
        assertEquals(expectResult, actualResult);
    }

    public void test_addVectors(){
        final List<Float> expectResult = Arrays.asList(2f, 4f, 5f);
        List<Float> a = Arrays.asList(1f, 2f, 3f);
        List<Float> b = Arrays.asList(1f, 2f, 2f);
        //act
        MathUtils.addVectors(a, b);
        //assert
        assertEquals(expectResult, a);
    }

    public void test_computeMSE(){
        final float expectResult = 1f;
        List<Float> a = Arrays.asList(1f, 0f, 3f);
        List<Float> b = Arrays.asList(1f, 2f, 2f);
        //act
        float actualResult = MathUtils.computeMSE(a, b);
        //assert
        assertEquals(expectResult, actualResult);
    }
}
