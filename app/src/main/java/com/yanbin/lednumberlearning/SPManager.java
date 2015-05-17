package com.yanbin.lednumberlearning;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungyanbin on 2015/5/17.
 */
public class SPManager {

    private Context context;

    private final static String TABLE_CANDIDATE = "candidate";

    private final static String CANDIDATE_0 = "c0";
    private final static String CANDIDATE_1 = "c1";
    private final static String CANDIDATE_2 = "c2";
    private final static String CANDIDATE_3 = "c3";


    public SPManager(Context context){
        this.context = context;
    }

    public void saveCandidates(String c0, String c1, String c2, String c3){
        SharedPreferences candidate = context.getSharedPreferences(TABLE_CANDIDATE, 0);
        candidate.edit()
                .putString(CANDIDATE_0, c0)
                .putString(CANDIDATE_1, c1)
                .putString(CANDIDATE_2, c2)
                .putString(CANDIDATE_3, c3)
                .commit();
    }

    public List<String> getCandidates(){
        SharedPreferences candidate = context.getSharedPreferences(TABLE_CANDIDATE, 0);
        List<String> candidates = new ArrayList<>();
        candidates.add(candidate.getString(CANDIDATE_0, ""));
        candidates.add(candidate.getString(CANDIDATE_1, ""));
        candidates.add(candidate.getString(CANDIDATE_2, ""));
        candidates.add(candidate.getString(CANDIDATE_3, ""));

        return candidates;
    }
}
