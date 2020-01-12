package com.mkt.plan4workout;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.mkt.plan4workout.Exercise.Exercise;

import java.util.ArrayList;
import java.util.List;

public class PlanActivityViewModel extends AndroidViewModel {
    private String pickExercises = "";
    private List<Integer> listPickExercises = new ArrayList<>();

    public PlanActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public String getPickExercises() {
        return pickExercises;
    }

    public void setPickExercises(String pickExercises) {
        this.pickExercises = pickExercises;
    }

//    public void makePickExercises() {
//        String[] data = pickExercises.split(",");
//        List<Integer> ret = new ArrayList<>();
//        if (pickExercises.length() > 0) {
//            for (String id : data) {
//                ret.add(Integer.valueOf(id));
//            }
//        }
//
//        listPickExercises = ret;
//    }



}
