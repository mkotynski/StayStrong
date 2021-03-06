package com.mkt.plan4workout.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.mkt.plan4workout.Model.DoWorkout.DoWorkout;
import com.mkt.plan4workout.Model.DoWorkout.DoWorkoutRepository;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class DoWorkoutViewModel extends AndroidViewModel {
    private DoWorkoutRepository repository;
    private LiveData<List<DoWorkout>> allDoWorkouts;

    public DoWorkoutViewModel(@NonNull Application application) {
        super(application);
        repository = new DoWorkoutRepository(application);
        allDoWorkouts = repository.getAllDoWorkouts();
    }

    public Long insert(DoWorkout doWorkout) throws ExecutionException, InterruptedException {
        return repository.insert(doWorkout);
    }

    public void update(DoWorkout doWorkout) {
        repository.update(doWorkout);
    }

    public void delete(DoWorkout doWorkout) {
        repository.delete(doWorkout);
    }

    public void deleteAllWorkouts() {
        repository.deleteAllWorkouts();
    }

    public LiveData<List<DoWorkout>> getAllWorkouts() {
        return allDoWorkouts;
    }

    public List<DoWorkout> getDoWorkoutsByExercise(int id) throws ExecutionException, InterruptedException {
        return repository.getDoWorkoutByExercise(id);
    }
}
