package com.example.threedependentspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spDiv, spDis;

    DatabaseHelper db;
    ArrayList<String> arrayList_div;
    ArrayAdapter<String> arrayAdapter_div;

    ArrayList<String> arrayList_Dhaka, arrayList_Chita, arrayList_bari, arrayList_Khul, arrayList_Raj, arrayList_Rang, arrayList_Sy, arrayList_lat, arrayList_lon;

    ArrayAdapter<String> arrayAdapter_Dis;
    ArrayAdapter<String> arrayAdapter_Latlon;

    int lat, lon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spDiv = findViewById(R.id.idDivision);
        spDis = findViewById(R.id.idDistrict);
        arrayList_div = new ArrayList<>();
        db = new DatabaseHelper(this);

        fetchData();
        loadData();



    }
    public void fetchData()
    {

        db = new DatabaseHelper(this);
        try {
            db.createDataBase();
            db.openDataBase();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadData() {

        final Cursor cursor = db.showDiv();

        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No data available", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                arrayList_div.add(cursor.getString(3));
            }
        }

        arrayAdapter_div = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, arrayList_div);
                spDiv.setAdapter(arrayAdapter_div);




         /////////////////////////////////////////////////////////

        arrayList_Dhaka = new ArrayList<>();
        final Cursor cursorDhaka = db.showDhaka();
        if (cursorDhaka.getCount() == 0) {
            Toast.makeText(this, "No data available", Toast.LENGTH_SHORT).show();
        } else {
            while (cursorDhaka.moveToNext()) {
                arrayList_Dhaka.add(cursorDhaka.getString(3));
            }
        }

//        arrayAdapter_Dis = new ArrayAdapter(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, (List) arrayList_Dhaka);
//        spDis.setAdapter(arrayAdapter_Dis);



        arrayList_Chita = new ArrayList<>();
        final Cursor cursor_Chita = db.showChit();
        if (cursor_Chita.getCount() == 0) {
            Toast.makeText(this, "No data available", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor_Chita.moveToNext()) {
                arrayList_Chita.add(cursor_Chita.getString(3));
            }
        }



        arrayList_bari = new ArrayList<>();
        final Cursor cursor_bari = db.showBari();
        if (cursor_bari.getCount() == 0) {
            Toast.makeText(this, "No data available", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor_bari.moveToNext()) {
                arrayList_bari.add(cursor_bari.getString(3));
            }
        }


        arrayList_Khul = new ArrayList<>();
        final Cursor cursor_Khul = db.shoeKhul();
        if (cursor_Khul.getCount() == 0) {
            Toast.makeText(this, "No data available", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor_Khul.moveToNext()) {
                arrayList_Khul.add(cursor_Khul.getString(3));
            }
        }



        arrayList_Raj = new ArrayList<>();
        final Cursor cursor_Raj = db.showRaj();
        if (cursor_Raj.getCount() == 0) {
            Toast.makeText(this, "No data available", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor_Raj.moveToNext()) {
                arrayList_Raj.add(cursor_Raj.getString(3));
            }
        }



        arrayList_Rang = new ArrayList<>();
        final Cursor cursor_Rong = db.showRong();
        if (cursor_Rong.getCount() == 0) {
            Toast.makeText(this, "No data available", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor_Rong.moveToNext()) {
                arrayList_Rang.add(cursor_Rong.getString(3));
            }
        }





        arrayList_Sy = new ArrayList<>();
        int a = 7;
        final Cursor cursor_Sy = db.showSy(a);
        if (cursor_Sy.getCount() == 0) {
            Toast.makeText(this, "No data available", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor_Sy.moveToNext()) {
                arrayList_Sy.add(cursor_Sy.getString(3));
            }
        }


        spDiv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==0){
                    arrayAdapter_Dis = new ArrayAdapter(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, arrayList_Dhaka);
                    spDis.setAdapter(arrayAdapter_Dis);
                }
                if (i==1){
                    arrayAdapter_Dis = new ArrayAdapter(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, arrayList_Chita);
                    spDis.setAdapter(arrayAdapter_Dis);
                }
                if (i==2){
                    arrayAdapter_Dis = new ArrayAdapter(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, (List) arrayList_bari);
                    spDis.setAdapter(arrayAdapter_Dis);
                }
                if (i==3){
                    arrayAdapter_Dis = new ArrayAdapter(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, (List) arrayList_Khul);
                    spDis.setAdapter(arrayAdapter_Dis);
                }
                if (i==4){
                    arrayAdapter_Dis = new ArrayAdapter(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, (List) arrayList_Raj);
                    spDis.setAdapter(arrayAdapter_Dis);
                }
                if (i==5){
                    arrayAdapter_Dis = new ArrayAdapter(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, (List) arrayList_Rang);
                    spDis.setAdapter(arrayAdapter_Dis);
                }
                if (i==6){
                    arrayAdapter_Dis = new ArrayAdapter(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, (List) arrayList_Sy);
                    spDis.setAdapter(arrayAdapter_Dis);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });

        spDis.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(MainActivity.this, ""+adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();

                String placeName = ""+adapterView.getItemAtPosition(i).toString();

                String str;
                arrayList_lat = new ArrayList<>();

                //placeName = "Dhaka";
                final Cursor cursor_lat = db.latlon(placeName);

                if (cursor_lat.getCount() == 0) {
                    Toast.makeText(getApplicationContext(), "No data available", Toast.LENGTH_SHORT).show();
                } else {
                    while (cursor_lat.moveToNext()) {
                        arrayList_lat.add(cursor_lat.getString(5));
                        //str = cursor.getString(cursor.getColumnIndex("lat"));
                        //Toast.makeText(getApplicationContext(), ""+str, Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });


    }
}