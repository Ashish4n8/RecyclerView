package com.example.recyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private ArrayList<Person> people;
    ItemClicked activity;

    public interface ItemClicked{
        void onClicked(int index);
    }

    public PersonAdapter (Context context, ArrayList<Person> list){
        people = list;
        activity = (ItemClicked) context;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView pref;
        TextView tvN, tvS;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvN = itemView.findViewById(R.id.tvN);
            tvS = itemView.findViewById(R.id.tvS);
            pref = itemView.findViewById(R.id.pref);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.onClicked(people.indexOf((Person) view.getTag()));
                }
            });
        }
    }

    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(people.get(position));
        holder.tvN.setText(people.get(position).getName());
        holder.tvS.setText(people.get(position).getSurname());
        Log.d("DamnCheck", String.valueOf(people.get(position).getName()));
        if (people.get(position).getPref().equals("bus")){
            holder.pref.setImageResource(R.drawable.bus);
        }
        else{
            holder.pref.setImageResource(R.drawable.plane);
        }
    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}
