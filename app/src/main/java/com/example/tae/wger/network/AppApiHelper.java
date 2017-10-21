package com.example.tae.wger.network;


import android.util.Log;

import com.example.tae.wger.model.EquipmentModel;
import com.example.tae.wger.model.ExerciseInfoModel;
import com.example.tae.wger.model.ExerciseModel;
import com.example.tae.wger.services.ConnectionService;
import com.example.tae.wger.services.reqInterface;

import io.reactivex.Observable;

/**
 *Created by TAE on 19/10/2017.
 */

public class AppApiHelper implements ApiHelper {
    reqInterface reqInterface;

    public AppApiHelper() {
        this.reqInterface = ConnectionService.getConnectionService();
    }


    @Override
    public Observable<EquipmentModel> useCaseEquipment() {
        Log.i("~~~~~~~~~~~~~~~~~~~~~", "API CALLED");
        return reqInterface.getEquipment();
    }

    @Override
    public Observable<ExerciseModel> useCaseExercise(int id) {
        return reqInterface.getExercise(id);
    }

    @Override
    public Observable<ExerciseInfoModel.Result> useCaseExerciseInfo(int id) {
        return reqInterface.getExerciseInfo(id);
    }
}

