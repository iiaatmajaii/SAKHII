package com.example.sakhii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

    public class MainActivity extends AppCompatActivity {
        private Button btn;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            getSupportActionBar().setTitle("HOME");
        }

        public void SOS(View view) {
            startActivity(new Intent(MainActivity.this, AlarmSystem.class));
            Toast.makeText(this, "SOS", Toast.LENGTH_SHORT).show();
        }
        public void EmergencyContacts(View view) {
            startActivity(new Intent(MainActivity.this,EmergencyCalling.class));

            Toast.makeText(this, "Emergency Contacts", Toast.LENGTH_SHORT).show();
        }

        public void RestaurantRatings(View view) {
            startActivity(new Intent(MainActivity.this, RestaurantRating.class));
            Toast.makeText(this, "Restaurant Ratings", Toast.LENGTH_SHORT).show();
        }

        public void scanning(View view){
            startActivity(new Intent(MainActivity.this, QRcode.class));

        }

        public void navigation(View view) {
            startActivity(new Intent(MainActivity.this, navigation.class));
            Toast.makeText(this, "Navigation", Toast.LENGTH_SHORT).show();
        }
    }


