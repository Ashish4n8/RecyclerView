package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {
    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Person> people;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btnA);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                people.add(new Person("Ashish","Nagashree","plane"));
                myAdapter.notifyDataSetChanged();       //to update and re render
            }
        });

        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);

        //layoutManager = new LinearLayoutManager(this);
        //layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false); //set elements horizontally
        //layoutManager = new GridLayoutManager(this,2,GridLayoutManager.HORIZONTAL,false);   //horizontal with 2 elements
        layoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false); //2 elements in each row vertically
        recyclerView.setLayoutManager(layoutManager);

        people = new ArrayList<Person>();
        people.add(new Person("Ashish","Nagaraj","bus"));
        people.add(new Person("Nagashree", "Srinivas","bus"));
        people.add(new Person("Nagashree","Ashish","plane"));
        people.add(new Person("Ashish","Nagaraj","bus"));
        people.add(new Person("Nagashree", "Srinivas","bus"));
        people.add(new Person("Nagashree","Ashish","plane"));
        people.add(new Person("Ashish","Nagaraj","bus"));
        people.add(new Person("Nagashree", "Srinivas","bus"));
        people.add(new Person("Nagashree","Ashish","plane"));

        myAdapter = new PersonAdapter(this,people);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onClicked(int index) {
        Toast.makeText(this, "Surname: "+people.get(index).getSurname(), Toast.LENGTH_SHORT).show();
    }
}