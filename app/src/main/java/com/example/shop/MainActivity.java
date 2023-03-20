package com.example.shop;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Spinner;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int kol=0;
    Spinner spinner;
    ArrayList spinnerar;
    ArrayAdapter spinnerad;
    HashMap animals;
    String aniname;
    double price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createSpinner();
        createAnimals();
    }

    void createSpinner(){
        spinner = findViewById(R.id.Spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerar = new ArrayList();
        spinnerar.add("CopyBara");
        spinnerar.add("LugDog");
        spinnerar.add("Mama-Lama");
        spinnerad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerar);
        spinnerad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerad);
    }
    void createAnimals(){
        animals = new HashMap();
        animals.put("LugDog", 701.00);
        animals.put("CopyBara", 606.00);
        animals.put("Mama-Lama", 669.00);
    }

    public void minus(View view) {
       // TextView cen = findViewById(R.id.textView3);
        TextView TextView3 = findViewById(R.id.textView3);
        TextView s = findViewById(R.id.textView);
        if (kol==0)
        {
            s.setText("0");
        }
        else
        {
            kol = kol - 1;
            s.setText("" + kol);
            TextView3.setText(""+price*kol+" рублей");
        }
    }

    public void plus(View view) {
        //TextView cen = findViewById(R.id.textView3);
        TextView TextView3 = findViewById(R.id.textView3);
        kol = kol+1;
        TextView d = findViewById(R.id.textView);
        d.setText("" + kol);
        TextView3.setText("" + kol * price + " рублей");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        aniname = spinner.getSelectedItem().toString();
        price = (double)animals.get(aniname);
        TextView TextView3 = findViewById(R.id.textView3);
        TextView3.setText("" + kol * price);
        ImageView ImageView2 = findViewById(R.id.imageView2);
        switch (aniname){
            case "CopyBara":
                ImageView2.setImageResource(R.drawable.capibara);
                break;
            case "LugDog":
                ImageView2.setImageResource(R.drawable.k1600_prairie_dog_eating___);
                break;
            case "Mama-Lama":
                ImageView2.setImageResource(R.drawable.lama);
                break;
            default:
                ImageView2.setImageResource(R.drawable.capibara);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}