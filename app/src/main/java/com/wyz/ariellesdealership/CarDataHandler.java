package com.wyz.ariellesdealership;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CarDataHandler {

    // Declare Context
    public static Context Context;

    // Save Data In Shared Preferences
    public static void SaveData(List<Car> cars){
        // Declare Shared Preferences Instance
        SharedPreferences dealershipData = PreferenceManager.getDefaultSharedPreferences(Context);

        // Enable Shared Preferences Editor
        SharedPreferences.Editor editor = dealershipData.edit();

        // Convert To Json
        String json = new Gson().toJson(cars);

        // Serialize to Json Data
        editor.putString("cars", json);

        // Save
        editor.commit();
    }

    // Load Data From Shared Preferences
    public static List<Car> LoadData()
    {
        // Declare Shared Preferences Instance
        SharedPreferences dealershipData = PreferenceManager.getDefaultSharedPreferences(Context);

        // Get Data As Json String
        String json = dealershipData.getString("cars", null);
        if (json != null)
        {
            Type type = new TypeToken<List<Car>>(){}.getType();
            return new Gson().fromJson(json, type);
        }
        else
        {
            // Populate Array List For Cars With Car Instances
            List<Car> cars = new ArrayList<Car>();
            cars.add(new Car(R.drawable.ford_figo,"Ford","Figo", "2010", "$500"));
            cars.add(new Car(R.drawable.honda_amaze,"Honda","Amaze", "2011", "$750"));
            cars.add(new Car(R.drawable.honda_city,"Honda","City", "2012", "1000"));
            cars.add(new Car(R.drawable.mahindra_xuv300,"Mahindra","XUV300 ", "2013", "$1250"));
            cars.add(new Car(R.drawable.maruti_ertiga,"Maruti","Ertiga", "2014", "$1500"));
            cars.add(new Car(R.drawable.maruti_suzuki,"Maruti","Suzuki", "2015", "$1750"));
            cars.add(new Car(R.drawable.renault_kwid,"Renault","kwid", "2016", "$2000"));
            cars.add(new Car(R.drawable.tata_nexon,"Tata","Nexon", "2017", "$2250"));
            return cars;
        }
    }
}
