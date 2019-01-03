package com.example.kolyshkin.shopping_application;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.Handler;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    private static final String LOG_TAG= MainActivity.class.getSimpleName();
    public static final int PRODUCT_REQUEST= 1;
    private Button activity_button, finish_button;
    private TextView order_label;
    private TextView PRODUCT1;
    private TextView PRODUCT2;
    private TextView PRODUCT3, PRODUCT4, PRODUCT5, PRODUCT6, PRODUCT7, PRODUCT8, PRODUCT9, PRODUCT10;
    boolean exist1, exist2, exist3, exist4, exist5, exist6, exist7, exist8, exist9, exist10= false;
    private Bundle productsBundle= new Bundle();
    Intent intent;
    String str_1;

    String SELECTED_PRODUCT1;
    String SELECTED_PRODUCT2;
    String SELECTED_PRODUCT3;
    String SELECTED_PRODUCT4;
    String SELECTED_PRODUCT5;
    String SELECTED_PRODUCT6;
    String SELECTED_PRODUCT7;
    String SELECTED_PRODUCT8;
    String SELECTED_PRODUCT9;
    String SELECTED_PRODUCT10;

        @Override
        protected void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
        if ((order_label.getVisibility() == View.VISIBLE) && finish_button.getVisibility()== View.VISIBLE
                                                          && activity_button.getVisibility() == View.INVISIBLE) {
            outState.putBoolean("reply_visible", true);
            order_label.setVisibility(View.VISIBLE);
          //  PRODUCT1.setVisibility(View.VISIBLE);
          //  PRODUCT2.setVisibility(View.VISIBLE);
          //  PRODUCT4.setVisibility(View.VISIBLE);
           // PRODUCT5.setVisibility(View.VISIBLE);
            finish_button.setVisibility(View.VISIBLE);

            outState.putString("PRODUCT1_NAME", PRODUCT1.getText().toString());
            outState.putString("PRODUCT2_NAME", PRODUCT2.getText().toString());
            outState.putString("PRODUCT3_NAME", PRODUCT3.getText().toString());
            outState.putString("PRODUCT4_NAME", PRODUCT4.getText().toString());
            outState.putString("PRODUCT5_NAME", PRODUCT5.getText().toString());
            outState.putString("PRODUCT6_NAME", PRODUCT6.getText().toString());
            outState.putString("PRODUCT7_NAME", PRODUCT7.getText().toString());
            outState.putString("PRODUCT8_NAME", PRODUCT8.getText().toString());
            outState.putString("PRODUCT9_NAME", PRODUCT9.getText().toString());
            outState.putString("PRODUCT10_NAME", PRODUCT10.getText().toString());
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        order_label.setVisibility(View.VISIBLE);
        finish_button.setVisibility(View.VISIBLE);
        savedInstanceState.get("reply_visible");
        savedInstanceState.get("PRODUCT1_NAME");
        savedInstanceState.get("PRODUCT2_NAME");
        savedInstanceState.get("PRODUCT3_NAME");
        savedInstanceState.get("PRODUCT4_NAME");
        savedInstanceState.get("PRODUCT5_NAME");
        savedInstanceState.get("PRODUCT6_NAME");
        savedInstanceState.get("PRODUCT7_NAME");
        savedInstanceState.get("PRODUCT8_NAME");
        savedInstanceState.get("PRODUCT9_NAME");
        savedInstanceState.get("PRODUCT10_NAME");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PRODUCT1= findViewById(R.id.value_1);
        PRODUCT2= findViewById(R.id.value_2);
        PRODUCT3= findViewById(R.id.value_3);
        PRODUCT4= findViewById(R.id.value_4);
        PRODUCT5= findViewById(R.id.value_5);
        PRODUCT6= findViewById(R.id.value_6);
        PRODUCT7= findViewById(R.id.value_7);
        PRODUCT8= findViewById(R.id.value_8);
        PRODUCT9= findViewById(R.id.value_9);
        PRODUCT10= findViewById(R.id.value_10);
        order_label= findViewById(R.id.order_label);
        finish_button= findViewById(R.id.finish_activity_button);
        activity_button= findViewById(R.id.first_activity_button);
        activity_button.setVisibility(View.VISIBLE);
        activity_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity_button.setBackgroundResource(R.drawable.green_button_shape);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        activity_button.setBackgroundResource(R.drawable.button_ahape);
                    }
                }, 2000);
                Intent intent= new Intent(MainActivity.this, Shopping_activity.class);
                startActivityForResult(intent, PRODUCT_REQUEST);
            }
        });
       if (savedInstanceState != null) {
           //*      boolean visible= savedInstanceState.getBoolean("reply_visible");
           //* if (visible) {
        //*        activity_button.setVisibility(View.INVISIBLE);
        //*        order_label.setVisibility(View.VISIBLE);
        //*       productsBundle= savedInstanceState.getBundle("dataBundle");
               PRODUCT1.setVisibility(View.VISIBLE);
               PRODUCT1.setText(savedInstanceState.getString("PRODUCT1_NAME"));
               PRODUCT2.setVisibility(View.VISIBLE);
               PRODUCT2.setText(savedInstanceState.getString("PRODUCT2_NAME"));
               PRODUCT3.setVisibility(View.VISIBLE);
               PRODUCT3.setText(savedInstanceState.getString("PRODUCT3_NAME"));
               PRODUCT4.setVisibility(View.VISIBLE);
               PRODUCT4.setText(savedInstanceState.getString("PRODUCT4_NAME"));
               PRODUCT5.setVisibility(View.VISIBLE);
               PRODUCT5.setText(savedInstanceState.getString("PRODUCT5_NAME"));
               PRODUCT6.setVisibility(View.VISIBLE);
               PRODUCT6.setText(savedInstanceState.getString("PRODUCT6_NAME"));
               PRODUCT7.setVisibility(View.VISIBLE);
               PRODUCT7.setText(savedInstanceState.getString("PRODUCT7_NAME"));
               PRODUCT8.setVisibility(View.VISIBLE);
               PRODUCT8.setText(savedInstanceState.getString("PRODUCT8_NAME"));
               PRODUCT9.setVisibility(View.VISIBLE);
               PRODUCT9.setText(savedInstanceState.getString("PRODUCT9_NAME"));
               PRODUCT10.setVisibility(View.VISIBLE);
               PRODUCT10.setText(savedInstanceState.getString("PRODUCT10_NAME"));
         }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(LOG_TAG, "We are in Target class!!");
        activity_button.setVisibility(View.INVISIBLE);

        if (requestCode == PRODUCT_REQUEST) {
            if (resultCode == RESULT_OK) {
                activity_button.setVisibility(View.INVISIBLE);
                order_label.setVisibility(View.VISIBLE);
                finish_button.setVisibility(View.VISIBLE);

                PRODUCT1.setVisibility(View.VISIBLE);
                PRODUCT2.setVisibility(View.VISIBLE);
                PRODUCT3.setVisibility(View.VISIBLE);
                PRODUCT4.setVisibility(View.VISIBLE);
                PRODUCT5.setVisibility(View.VISIBLE);
                PRODUCT6.setVisibility(View.VISIBLE);
                PRODUCT7.setVisibility(View.VISIBLE);
                PRODUCT8.setVisibility(View.VISIBLE);
                PRODUCT9.setVisibility(View.VISIBLE);
                PRODUCT10.setVisibility(View.VISIBLE);
                //get the intent in the target activity
                //get the attached bundle from the intent
                Bundle extras= data.getExtras();
                //Extracting the stored data from the bundle
                SELECTED_PRODUCT1= extras.getString(Shopping_activity.SELECTED_PRODUCT1);
                productsBundle.putString("String1", SELECTED_PRODUCT1);
                SELECTED_PRODUCT2= extras.getString(Shopping_activity.SELECTED_PRODUCT2);
                productsBundle.putString("String2", SELECTED_PRODUCT2);
                SELECTED_PRODUCT3= extras.getString(Shopping_activity.SELECTED_PRODUCT3);
                SELECTED_PRODUCT4= extras.getString(Shopping_activity.SELECTED_PRODUCT4);
                SELECTED_PRODUCT5= extras.getString(Shopping_activity.SELECTED_PRODUCT5);
                SELECTED_PRODUCT6= extras.getString(Shopping_activity.SELECTED_PRODUCT6);
                SELECTED_PRODUCT7= extras.getString(Shopping_activity.SELECTED_PRODUCT7);
                SELECTED_PRODUCT8= extras.getString(Shopping_activity.SELECTED_PRODUCT8);
                SELECTED_PRODUCT9= extras.getString(Shopping_activity.SELECTED_PRODUCT9);
                SELECTED_PRODUCT10= extras.getString(Shopping_activity.SELECTED_PRODUCT10);
                Log.d(LOG_TAG, "Selected product1: "+SELECTED_PRODUCT1);
                    PRODUCT1.setText(SELECTED_PRODUCT1);
                    PRODUCT2.setText(SELECTED_PRODUCT2);
                    PRODUCT3.setText(SELECTED_PRODUCT3);
                    PRODUCT4.setText(SELECTED_PRODUCT4);
                    PRODUCT5.setText(SELECTED_PRODUCT5);
                    PRODUCT6.setText(SELECTED_PRODUCT6);
                    PRODUCT7.setText(SELECTED_PRODUCT7);
                    PRODUCT8.setText(SELECTED_PRODUCT8);
                    PRODUCT9.setText(SELECTED_PRODUCT9);
                    PRODUCT10.setText(SELECTED_PRODUCT10);
            }
        }
    }

    public void finishActivity(View view) {
        finish_button.setBackgroundResource(R.drawable.red_button_shape);
        new CountDownTimer(1500, 20) {
            @Override
            public void onTick(long l) { }
            @Override
            public void onFinish() {
                finish_button.setBackgroundResource(R.drawable.button_ahape);
            }
        }.start();
        finish();
    }
}