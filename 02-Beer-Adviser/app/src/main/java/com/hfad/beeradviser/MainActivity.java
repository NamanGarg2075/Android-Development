package com.hfad.beeradviser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickFindBeer(View view){
        BeerExpert expert = new BeerExpert();
        /* reference of textview */
        TextView brands = (TextView) findViewById(R.id.brands);

//        reference of spinner
        Spinner color = (Spinner) findViewById(R.id.color);

//        spinner object to string
        String beerType = String.valueOf(color.getSelectedItem());

////        Displaying the selected item
//        brands.setText(beerType);

//        recommendations
        List<String> brandList = expert.getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder();
        for(String brand : brandList){
            brandsFormatted.append(brand).append('\n');
        }

//        display beers
        brands.setText(brandsFormatted);
    }
}