package com.wyz.ariellesdealership;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// Car Adapter Class Subclassing Car View Holder
public class CarAdapter extends RecyclerView.Adapter<CarViewHolder> {

    // Create Cars List Instance From Car
    private List<Car> Cars;

    // Populate Cars List With Meta Data From Car Adapter
    public CarAdapter(List<Car> cars) {
        // Pass In Every Car Object Instance Through Car Adapter
        this.Cars = cars;
    }

    // Perform Operations On Car Instances
    // ------
    // Create
    public void AddCar(Car car) {
        // Add Car
        Cars.add(car);

        // Track Data Change
        notifyDataSetChanged();

        // Save Data With Car Data Handler
        CarDataHandler.SaveData(Cars);
    }

    // Delete
    public void DeleteCar(int car_index) {
        // Remove Car At Index
        Cars.remove(car_index);
        
        // Track Data Change
        notifyDataSetChanged();
        
        // Delete Car With Car Data Handler
        CarDataHandler.SaveData(Cars);
    }

    
    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.car,parent,false);
        CarViewHolder vh = new CarViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {

        // Get Car Index Position
        Car car = Cars.get(position);

        // Get Car Details
        holder.avatar.setImageResource(car.getImage());
        holder.brand.setText(car.getBrand());
        holder.model.setText(car.getModel());
        holder.year.setText(car.getYear());
        holder.price.setText(car.getPrice());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), CarListActivity.class);
                i.putExtra("car", car);
                ActivityOptionsCompat options =
                        ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) v.getContext(),
                                holder.avatar,
                                "avatarTransition"
                        );
                v.getContext().startActivity(i,options.toBundle());
            }
        });
    }

    // Check Cars Array Size
    @Override
    public int getItemCount() {

        // Return Size
        return Cars.size();

    }
}
