package com.example.sakhii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.sakhii.DataBaseHelper;
import com.example.sakhii.RestaurantModel;
import com.example.sakhii.registration_page;

import java.util.List;

public class RestaurantRating extends AppCompatActivity {
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBaseHelper databaseHelper = new DataBaseHelper(RestaurantRating.this);

        Button btn_rating, btn_list;
        setContentView(R.layout.activity_main);
        btn_rating = (Button) findViewById(R.id.btn_rating);
        btn_list = (Button) findViewById(R.id.btn_list);
        lv = findViewById(R.id.lv);
        setContentView(R.layout.activity_restaurant_rating);


    }

    public void rate(View v){
        startActivity(new Intent(RestaurantRating.this, registration_page.class));
    }
    public void list(View v){

        lv = findViewById(R.id.lv);

        DataBaseHelper databaseHelper = new DataBaseHelper(RestaurantRating.this);
        List<RestaurantModel> everyone = databaseHelper.getEveryone();
        ArrayAdapter customerArrayAdapter = new ArrayAdapter<RestaurantModel>(RestaurantRating.this, android.R.layout.simple_list_item_1,everyone);
        lv.setAdapter(customerArrayAdapter);
        Toast.makeText(this, everyone.toString() , Toast.LENGTH_SHORT).show();
    }

}