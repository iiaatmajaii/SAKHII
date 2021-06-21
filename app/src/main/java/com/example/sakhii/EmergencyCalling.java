package com.example.sakhii;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EmergencyCalling extends AppCompatActivity {

    private static final int RREQUEST_CALL = 1;
    private TextView callText,callText1,callText2,callText3,callText4,callText5;
    private Button callButton,callButton1,callButton2,callButton3,callButton4,callButton5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_calling);

        callText1 = findViewById(R.id.callTxt1);
        callText2 = findViewById(R.id.callTxt2);
        callText3 = findViewById(R.id.callTxt3);
        callText4 = findViewById(R.id.callTxt4);
        callText5 = findViewById(R.id.callTxt5);
        callButton1 = findViewById(R.id.callButton1);
        callButton2 = findViewById(R.id.callButton2);
        callButton3 = findViewById(R.id.callButton3);
        callButton4 = findViewById(R.id.callButton4);
        callButton5 = findViewById(R.id.callButton5);

        callButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallButton1();
            }
        });
        callButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallButton2();
            }
        });
        callButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallButton3();
            }
        });
        callButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallButton4();
            }
        });

        callButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallButton5();
            }
        });

    }

    private void CallButton1() {
        String number = callText1.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(EmergencyCalling.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(EmergencyCalling.this, new String[]{Manifest.permission.CALL_PHONE}, RREQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }
    private void CallButton2() {
        String number = callText2.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(EmergencyCalling.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(EmergencyCalling.this, new String[]{Manifest.permission.CALL_PHONE}, RREQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }
    private void CallButton3() {
        String number = callText3.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(EmergencyCalling.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(EmergencyCalling.this, new String[]{Manifest.permission.CALL_PHONE}, RREQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }
    private void CallButton4() {
        String number = callText4.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(EmergencyCalling.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(EmergencyCalling.this, new String[]{Manifest.permission.CALL_PHONE}, RREQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }
    private void CallButton5() {
        String number = callText5.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(EmergencyCalling.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(EmergencyCalling.this, new String[]{Manifest.permission.CALL_PHONE}, RREQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == RREQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                CallButton1();
                CallButton2();
                CallButton3();
                CallButton4();
                CallButton5();
            } else {
                Toast.makeText(this, "permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }
}