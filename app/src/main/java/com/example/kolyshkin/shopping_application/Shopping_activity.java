package com.example.kolyshkin.shopping_application;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import android.os.Handler;
import android.widget.Toast;

public class Shopping_activity extends Activity {
    private static final String LOG_TAG= Shopping_activity.class.getSimpleName();
    public static final String SETTING_CHECK_BOX= "CHECK_BOX_SETTING";
    public static final String SELECTED_PRODUCT1= "PRODUCT_ONE_IS_SELECTED";
    public static final String SELECTED_PRODUCT2= "PRODUCT_TWO_IS_SELECTED";
    public static final String SELECTED_PRODUCT3= "PRODUCT_THREE_IS_SELECTED";
    public static final String SELECTED_PRODUCT4= "PRODUCT_FOUR_IS_SELECTED";
    public static final String SELECTED_PRODUCT5= "PRODUCT_FIVE_IS_SELECTED";
    public static final String SELECTED_PRODUCT6= "PRODUCT_SIX_IS_SELECTED";
    public static final String SELECTED_PRODUCT7= "PRODUCT_SEVEN_IS_SELECTED";
    public static final String SELECTED_PRODUCT8= "PRODUC_EIGHT_IS_SELECTED";
    public static final String SELECTED_PRODUCT9= "PRODUCT_NINE_IS_SELECTED";
    public static final String SELECTED_PRODUCT10= "PRODUCT_TEN_IS_SELECTED";
    public static final String DATA_BUNDLE= "My_Bundle";
    CheckBox checkBox_1, checkBox_2, checkBox_3, checkBox_4, checkBox_5, checkBox_6, checkBox_7, checkBox_8, checkBox_9, checkBox_10;
    Button adding_button;
    String string;
   // Intent intentData;
   // private List<String> productsList= new ArrayList<>();
    private Handler handler;
    private Runnable handlerTask;
    Bundle extras= new Bundle();
    boolean chbox_one, chbox_two, chbox_three, chbox_four, chbox_five, chbox_six, chbox_seven, chbox_eight, chbox_nine, chbox_ten= false;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
       // if (chbox_one) {
       //     outState.putBoolean(SELECTED_PRODUCT1, true);
      //      outState.putBoolean(SELECTED_PRODUCT1, chbox_one);
           // chbox_one= true;
           // outState.putString(SELECTED_PRODUCT1, checkBox_1.getText().toString());
       // }

        outState.putBundle(DATA_BUNDLE, extras);
        outState.putBoolean(SELECTED_PRODUCT1, chbox_one);
        outState.putBoolean(SELECTED_PRODUCT2, chbox_two);
        outState.putBoolean(SELECTED_PRODUCT3, chbox_three);
        outState.putBoolean(SELECTED_PRODUCT4, chbox_four);
        outState.putBoolean(SELECTED_PRODUCT5, chbox_five);
        outState.putBoolean(SELECTED_PRODUCT6, chbox_six);
        outState.putBoolean(SELECTED_PRODUCT7, chbox_seven);
        outState.putBoolean(SELECTED_PRODUCT8, chbox_eight);
        outState.putBoolean(SELECTED_PRODUCT9, chbox_nine);
        outState.putBoolean(SELECTED_PRODUCT10, chbox_ten);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
       // chbox_one= true;
        savedInstanceState.getBundle(DATA_BUNDLE);
        savedInstanceState.get(SELECTED_PRODUCT1);
        savedInstanceState.get(SELECTED_PRODUCT2);
        savedInstanceState.get(SELECTED_PRODUCT3);
        savedInstanceState.get(SELECTED_PRODUCT4);
        savedInstanceState.get(SELECTED_PRODUCT5);
        savedInstanceState.get(SELECTED_PRODUCT6);
        savedInstanceState.get(SELECTED_PRODUCT7);
        savedInstanceState.get(SELECTED_PRODUCT8);
        savedInstanceState.get(SELECTED_PRODUCT9);
        savedInstanceState.get(SELECTED_PRODUCT10);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_shopping_activity);

                checkBox_1= findViewById(R.id.box_one);
                checkBox_2= findViewById(R.id.box_two);
                checkBox_3= findViewById(R.id.box_three);
                checkBox_4= findViewById(R.id.box_four);
                checkBox_5= findViewById(R.id.box_five);
                checkBox_6= findViewById(R.id.box_six);
                checkBox_7= findViewById(R.id.box_seven);
                checkBox_8= findViewById(R.id.box_eight);
                checkBox_9= findViewById(R.id.box_nine);
                checkBox_10= findViewById(R.id.box_ten);
                adding_button= findViewById(R.id.submit_button);
                adding_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (view.getId() == R.id.submit_button) {

                            if (!extras.isEmpty()) {
                                adding_button.setBackgroundResource(R.drawable.green_button_shape);
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        adding_button.setBackgroundResource(R.drawable.button_ahape);
                                    }
                                }, 2000);
                                Intent intentData = new Intent();
                                intentData.putExtras(extras);
                                setResult(RESULT_OK, intentData);
                                finish();
                            } else {
                                adding_button.setBackgroundResource(R.drawable.red_button_shape);
                                new CountDownTimer(1500, 20) {
                                    @Override
                                    public void onTick(long l) { }
                                    @Override
                                    public void onFinish() {
                                        adding_button.setBackgroundResource(R.drawable.button_ahape);
                                    }
                                }.start();
                                Context context= getApplicationContext();
                                Toast alarmMessage= Toast.makeText(context, getResources().getString(R.string.no_one_selected), Toast.LENGTH_SHORT);
                                LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                                View toastRoot= layoutInflater.inflate(R.layout.toast_layout, null);
                                alarmMessage.setView(toastRoot);
                                alarmMessage.setDuration(Toast.LENGTH_LONG);
                                alarmMessage.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
                                alarmMessage.show();
                            }
                        }

                    }
                });

        if (savedInstanceState != null) {
            chbox_one= savedInstanceState.getBoolean(SELECTED_PRODUCT1);
           // chbox_one= true;
            extras= savedInstanceState.getBundle("My_Bundle");
          //  string= savedInstanceState.getString(SELECTED_PRODUCT1);
            chbox_two= savedInstanceState.getBoolean(SELECTED_PRODUCT2);
            chbox_three= savedInstanceState.getBoolean(SELECTED_PRODUCT3);
            chbox_four= savedInstanceState.getBoolean(SELECTED_PRODUCT4);
            chbox_five= savedInstanceState.getBoolean(SELECTED_PRODUCT5);
            chbox_six= savedInstanceState.getBoolean(SELECTED_PRODUCT6);
            chbox_seven= savedInstanceState.getBoolean(SELECTED_PRODUCT7);
            chbox_eight= savedInstanceState.getBoolean(SELECTED_PRODUCT8);
            chbox_nine= savedInstanceState.getBoolean(SELECTED_PRODUCT9);
            chbox_ten= savedInstanceState.getBoolean(SELECTED_PRODUCT10);
        }
    }

    public void onCheckBoxClick(View view){
        boolean isChecked= ((CheckBox) view).isChecked();

        switch (view.getId()){
            case R.id.box_one:
                if (isChecked) {
                    String product = checkBox_1.getText().toString();
                    extras.putString(SELECTED_PRODUCT1, checkBox_1.getText().toString());
                    Log.d(LOG_TAG, "Check_box_1: " + product);
                    chbox_one= true;
                } else {
                    chbox_one= false;
                }break;
            case  R.id.box_two:
                if (isChecked) {
                    String product = checkBox_2.getText().toString();
                    extras.putString(SELECTED_PRODUCT2, checkBox_2.getText().toString());
                    Log.d(LOG_TAG, "check_box_2: " + product);
                    chbox_two = true;
                } else {
                    chbox_two= false;
                }break;
            case R.id.box_three:
                if (isChecked) {
                    String product = checkBox_3.getText().toString();
                    extras.putString(SELECTED_PRODUCT3, product);
                    Log.d(LOG_TAG, "check_box_3: " + product);
                    chbox_three= true;
                } else {
                    chbox_three= false;
                }break;
            case R.id.box_four:
                if (isChecked) {
                    String product = checkBox_4.getText().toString();
                    extras.putString(SELECTED_PRODUCT4, product);
                    Log.d(LOG_TAG, "check_box_4: " + product);
                    chbox_four = true;
                } else {
                    chbox_four= false;
                }break;
            case R.id.box_five:
                if (isChecked) {
                    String product = checkBox_5.getText().toString();
                    extras.putString(SELECTED_PRODUCT5, product);
                    Log.d(LOG_TAG, "check_box_5: " + product);
                    chbox_five = true;
                } else {
                    chbox_five= false;
                }break;
            case R.id.box_six:
                if (isChecked) {
                    String product = checkBox_6.getText().toString();
                    extras.putString(SELECTED_PRODUCT6, product);
                    Log.d(LOG_TAG, "check_box_6: " + product);
                    chbox_six = true;
                } else {
                    chbox_six= false;
                }break;
            case R.id.box_seven:
                if (isChecked) {
                    String product = checkBox_7.getText().toString();
                    extras.putString(SELECTED_PRODUCT7, product);
                    Log.d(LOG_TAG, "check_box_7: " + product);
                    chbox_seven = true;
                } else {
                    chbox_seven= false;
                }break;
            case R.id.box_eight:
                if (isChecked) {
                    String product = checkBox_8.getText().toString();
                    extras.putString(SELECTED_PRODUCT8, product);
                    Log.d(LOG_TAG, "check_box_8: " + product);
                    chbox_eight = true;
                } else {
                    chbox_eight= false;
                }break;
            case R.id.box_nine:
                if (isChecked) {
                    String product = checkBox_9.getText().toString();
                    extras.putString(SELECTED_PRODUCT9, product);
                    Log.d(LOG_TAG, "check_box_9: " + product);
                    chbox_nine = true;
                } else {
                    chbox_nine= false;
                }break;
            case R.id.box_ten:
                if (isChecked) {
                    String product = checkBox_10.getText().toString();
                    extras.putString(SELECTED_PRODUCT10, product);
                    Log.d(LOG_TAG, "check_box_10: " + product);
                    chbox_ten = true;
                } else {
                    chbox_ten= false;
                }break;
        }
    }
}