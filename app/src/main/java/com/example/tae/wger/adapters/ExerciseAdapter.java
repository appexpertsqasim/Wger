package com.example.tae.wger.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tae.wger.R;
import com.example.tae.wger.listener.ExerciseRecyclerViewClickListener;
import com.example.tae.wger.model.ExerciseModel;

/**
 * Created by TAE on 19/10/2017.
 */

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.exerciseViewHolder>{
     ExerciseModel exerciseModel;

    //List<EquipmentModel> equipment;
    int row;
    Context applicationContext;
    ExerciseRecyclerViewClickListener rListener;

    public ExerciseAdapter(ExerciseModel exercise, int row, Context applicationContext, ExerciseRecyclerViewClickListener listener) {
        this.exerciseModel = exercise;
        this.row = row;
        this.applicationContext = applicationContext;
        this.rListener=listener;
        Log.i("adapter", "callled");
    }


    @Override
    public exerciseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(row, null);
        Log.i("view Holder","passseddd");
        return new exerciseViewHolder(view);

    }

    @Override
    public void onBindViewHolder(exerciseViewHolder holder, int position) {
        holder.bind(exerciseModel.getResults().get(position), rListener);
        holder.name.setText(exerciseModel.getResults().get(position).getName());
        Log.i("nameeeeeeeeee",exerciseModel.getResults().get(position).getName());



    }
    @Override
    public int getItemCount() {
        return exerciseModel.getResults().size();
    }

    public class exerciseViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        public exerciseViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.exercise_name);
        }

        public void bind(final ExerciseModel.Result result, final ExerciseRecyclerViewClickListener rListener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    rListener.onItemClick(result);
                }
            });
        }
    }
}
