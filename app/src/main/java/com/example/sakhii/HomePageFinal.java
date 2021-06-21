package com.example.sakhii;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomePageFinal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_final);
    }

    public void SOS(View view) {

        Toast.makeText(this, "SOS", Toast.LENGTH_SHORT).show();
    }
    public void EmergencyContacts(View view) {

        Toast.makeText(this, "Emergency Contacts", Toast.LENGTH_SHORT).show();
    }
    public void ServiceRatings(View view) {

        Toast.makeText(this, "Service Ratings", Toast.LENGTH_SHORT).show();
    }
    public void RestaurantRatings(View view) {

        Toast.makeText(this, "Restaurant Ratings", Toast.LENGTH_SHORT).show();
    }
    public void Navigation(View view) {

        Toast.makeText(this, "Navigating", Toast.LENGTH_SHORT).show();
    }
    public void Payment(View view) {

        Toast.makeText(this, "Payments", Toast.LENGTH_SHORT).show();
    }
}
