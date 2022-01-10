package com.wyz.ariellesdealership;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddCarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        // Declare Button
        Button btn = findViewById(R.id.button);

        // Set Click Listener For Button
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get New Car Details By Id
                EditText brand = findViewById(R.id.brand);
                EditText model = findViewById(R.id.model);
                EditText year = findViewById(R.id.year);
                EditText price = findViewById(R.id.price);

                // Create New Car Object
                Car car = new Car(R.drawable.ade,
                        brand.getText().toString(),
                        model.getText().toString(),
                        year.getText().toString(),
                        price.getText().toString());

                // Save New Car
                Intent i = new Intent();
                i.putExtra("car", car);
                setResult(1, i);
                finish();

            }
        });
    }
}