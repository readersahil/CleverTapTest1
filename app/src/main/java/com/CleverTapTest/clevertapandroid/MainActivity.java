package com.CleverTapTest.clevertapandroid;

import androidx.appcompat.app.AppCompatActivity;

import com.clevertap.android.sdk.CleverTapAPI;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;


import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = this;
        CleverTapAPI clevertapDefaultInstance = CleverTapAPI.getDefaultInstance(getApplicationContext());


        Button viewed_button = (Button) findViewById(R.id.button1);
        LinearLayout layout2 = (LinearLayout)findViewById(R.id.layout2);
        Button send_btn = (Button) findViewById(R.id.send_btn);
        EditText edit1 = (EditText)findViewById(R.id.edit1);
        EditText edit2 = (EditText)findViewById(R.id.edit2);
        viewed_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Product Viewed", Toast.LENGTH_SHORT).show();
                HashMap<String, Object> prodViewedAction = new HashMap<String, Object>();
                prodViewedAction.put("Product ID", "1");
                prodViewedAction.put("Product Image", "https://d35fo82fjcw0y8.cloudfront.net/2018/07/26020307/customer-success-clevertap.jpg");
                prodViewedAction.put("Product Name", "CleverTap");
                prodViewedAction.put("Date", new java.util.Date());
                layout2.setVisibility(View.VISIBLE);
                clevertapDefaultInstance.pushEvent("Product viewed", prodViewedAction);
            }


        });

        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String, Object> profileUpdate = new HashMap<String, Object>();
                profileUpdate.put("Name",  edit1.getText());                  // String
                profileUpdate.put("Email", edit2.getText());
                clevertapDefaultInstance.pushProfile(profileUpdate);
            }
        });
    }
}