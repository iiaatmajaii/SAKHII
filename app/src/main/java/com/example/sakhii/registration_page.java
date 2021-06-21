package com.example.sakhii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class registration_page extends AppCompatActivity {
    private EditText et_name, et_locality, et_crowd, et_staff;
    private Switch alcohol, safe;
    private Button reg_Button, back_Button;
    private TextView tv_title, tv_name, tv_locality, tv_crowd, tv_staff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);
        reg_Button = (Button) findViewById(R.id.btn_rating);
        back_Button = (Button) findViewById(R.id.back_button);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_name = (TextView) findViewById(R.id.tv_name);
        et_name = (EditText) findViewById(R.id.et_name);
        tv_locality = (TextView) findViewById(R.id.tv_locality);
        et_locality = (EditText) findViewById(R.id.et_locality);
        tv_staff = (TextView) findViewById(R.id.tv_staff);
        et_staff= (EditText) findViewById(R.id.et_staff);
        alcohol = (Switch) findViewById(R.id.alcohol_switch);
        safe = (Switch) findViewById(R.id.safe_switch);



    }
    public void register(View v){
        RestaurantModel restaurantModel;
        try{
            restaurantModel = new RestaurantModel(-1, et_name.getText().toString(), et_locality.getText().toString(), et_staff.getText().toString(), alcohol.isChecked(), safe.isChecked());
            Toast.makeText(this, restaurantModel.toString(), Toast.LENGTH_SHORT).show();
        }
        catch(Exception e){

            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
            restaurantModel = new RestaurantModel(-1, "error", null, null , false, false);
        };

        DataBaseHelper dataBaseHelper = new DataBaseHelper(registration_page.this);
        boolean success = dataBaseHelper.addOne(restaurantModel);
        Toast.makeText(this, "Success = " + success, Toast.LENGTH_SHORT).show();
    }



    public void back(View v){
        startActivity(new Intent(registration_page.this, RestaurantRating.class));
    }
}