package com.example.liveharshit;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liveharshit.justjava.R;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    private boolean isUserClickBackButton = false;
    int quantity = 0;
    int price = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */

    public void increment(View view) {
        quantity++;
        display(quantity);
    }

    public void decrement(View view) {
        if (quantity>0) {
            quantity--;
        }
        else quantity=0;
        display(quantity);
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    public void submitOrder(View view) {
        EditText personName = (EditText)findViewById(R.id.personName);
        String name = personName.getText().toString();
        CheckBox whippedCream = (CheckBox)findViewById(R.id.whippedCream);
        CheckBox chocolate = (CheckBox)findViewById(R.id.chocolate);
        String items = null;
        if (whippedCream.isChecked()) {
            price = (quantity*1);
            items = "Whipped cream";
        }
        if(chocolate.isChecked()) {
            price=(quantity*2);
            items = "Chocolate";

        }
        if (whippedCream.isChecked()&&chocolate.isChecked()) {
            price = (quantity*3);
            items = "Whipped cream and chocolate";
        }
        String priceMethod = "Name: "+name+"\n"+"Items: "+items+"\n"+"Quantity: "+quantity+"\n"+"Price: $"+price+"\n"+"Thank you!";
        displayMessage(priceMethod);
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    @Override
    public void onBackPressed() {
        if(!isUserClickBackButton) {
            Toast.makeText(MainActivity.this, "Press back again to exit", Toast.LENGTH_SHORT).show();
            isUserClickBackButton = true;
        }
        else {
            super.onBackPressed();
        }
        new CountDownTimer(3000,1000){

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                isUserClickBackButton = false;
            }
        }.start();
    }
}