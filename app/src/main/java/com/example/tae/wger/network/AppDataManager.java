package com.example.tae.wger.network;


import com.example.tae.wger.model.EquipmentModel;
import com.example.tae.wger.model.ExerciseInfoModel;
import com.example.tae.wger.model.ExerciseModel;

import io.reactivex.Observable;

/**
 * Created by TAE on 19/10/2017.
 */

public class AppDataManager implements DataManager {
    ApiHelper apiHelper;
    public AppDataManager(){this.apiHelper=new AppApiHelper();}
    @Override
    public Observable<EquipmentModel> useCaseEquipment() {
        return apiHelper.useCaseEquipment();
    }

    @Override
    public Observable<ExerciseModel> useCaseExercise(int id) {
        return apiHelper.useCaseExercise(id);
    }

    @Override
    public Observable<ExerciseInfoModel.Result> useCaseExerciseInfo(int id) {
        return apiHelper.useCaseExerciseInfo(id);
    }


}
