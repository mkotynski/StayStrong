package com.mkt.plan4workout.Plan;


import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.mkt.plan4workout.AppDatabase;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class PlanRepository {
    private PlanDao planDao;
    private LiveData<List<Plan>> allPlans;
    private long resultId = 0;

    public PlanRepository(Application application){
        AppDatabase database = AppDatabase.getInstance(application);
        planDao = database.planDao();
        allPlans = planDao.getAllPlans();
    }

    public Long insert(Plan plan) throws ExecutionException, InterruptedException {
        InsertPlanAsyncTask asyncTask = new InsertPlanAsyncTask(planDao);
        return asyncTask.execute(plan).get();
    }

    public void update(Plan plan){
        new UpdatePlanAsyncTask(planDao).execute(plan);
    }

    public void delete(Plan plan){
        new DeletePlanAsyncTask(planDao).execute(plan);
    }

    public void deleteAllPlans(){
        new DeleteAllPlansAsyncTask(planDao).execute();
    }

    public LiveData<List<Plan>> getAllPlans() {
        return allPlans;
    }

    private static class InsertPlanAsyncTask extends AsyncTask<Plan, Void, Long> {
        private PlanDao planDao;

        private InsertPlanAsyncTask(PlanDao planDao){
            this.planDao = planDao;
        }

        @Override
        protected Long doInBackground(Plan... plans) {
            long id = planDao.insert(plans[0]);
            System.out.println("ID OF INSERTED ROW = " + id);
            return id;
        }

        @Override
        protected void onPostExecute(Long search_id) {
            //resultId = search_id;
        }
    }

    private static class UpdatePlanAsyncTask extends AsyncTask<Plan, Void, Void> {
        private PlanDao planDao;

        private UpdatePlanAsyncTask(PlanDao planDao){
            this.planDao = planDao;
        }

        @Override
        protected Void doInBackground(Plan... plans) {
            planDao.update(plans[0]);
            return null;
        }
    }

    private static class DeletePlanAsyncTask extends AsyncTask<Plan, Void, Void> {
        private PlanDao planDao;

        private DeletePlanAsyncTask(PlanDao planDao){
            this.planDao = planDao;
        }

        @Override
        protected Void doInBackground(Plan... plans) {
            planDao.delete(plans[0]);
            return null;
        }
    }

    private static class DeleteAllPlansAsyncTask extends AsyncTask<Void, Void, Void> {
        private PlanDao planDao;

        private DeleteAllPlansAsyncTask(PlanDao planDao){
            this.planDao = planDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            planDao.deleteAllPlans();
            return null;
        }
    }
}

