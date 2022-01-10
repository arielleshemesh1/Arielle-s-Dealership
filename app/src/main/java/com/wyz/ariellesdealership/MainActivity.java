package com.wyz.ariellesdealership;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

// App Main Activity
public class MainActivity extends AppCompatActivity {

    // Create Car Adapter Variable
    CarAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get Cars Data
        CarDataHandler.Context = getApplicationContext();
        List<Car> cars = CarDataHandler.LoadData();

        // Instantiate Recycler
        RecyclerView recycler = findViewById(R.id.recycler);
        recycler.setHasFixedSize(false);

        // Set Recycler Grid Layout
        RecyclerView.LayoutManager manager = new GridLayoutManager(getApplicationContext(),1);
        recycler.setLayoutManager(manager);

        // Initialize & Set CarAdapter
        adapter = new CarAdapter(cars);
        recycler.setAdapter(adapter);

        // Activate Touch Helper For Deletion
        ItemTouchHelper helper = new ItemTouchHelper(new SwipeToDelete(adapter));
        helper.attachToRecyclerView(recycler);

        // Activate Floating Action Button
        FloatingActionButton btn = findViewById(R.id.floatingActionButton);
        // Set Button Click Listener To Add Car Activity
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),AddCarActivity.class);
                ActivityOptionsCompat options =
                        ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) v.getContext(),
                                btn,
                                "bg"
                        );
                // Start Car Activity
                startActivityForResult(i,1,options.toBundle());
            }
        });
    }

    // Control New Carr Addition
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==1) {
            Bundle b = data.getExtras();
            Car car = (Car) b.getSerializable("car");
            adapter.AddCar(car);
        }
    }
}