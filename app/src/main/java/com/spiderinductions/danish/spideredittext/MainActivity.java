package com.spiderinductions.danish.spideredittext;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.ListAdapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Spinner;


public class MainActivity extends Activity {
    Spinner colorList;
    Spinner sizeList;
    EditText inputText;
    ListView fontList;
    CheckBox boldBox;
    CheckBox italicBox;
    String font;
    String colour;
    String size;
    String bolddata,italicdata;

    String [] fonts_array ={"Arial","Monotype Corsiva"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        colorList=(Spinner)findViewById(R.id.colourSpinner);
        sizeList=(Spinner)findViewById(R.id.sizeSpinner);

        colorList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                colour = String.valueOf(parent.getItemAtPosition(position));
                Log.d("color", colour);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                colour = "White";
            }
        });
        sizeList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                size = String.valueOf(parent.getItemAtPosition(position));
                Log.d("size", size);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                size = "10";
            }
        });

        boldBox=(CheckBox)findViewById(R.id.boldBox);
        bolddata="false";
        boldBox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (((CheckBox) v).isChecked())
                { bolddata = "true";}
            }
        });

        italicBox=(CheckBox)findViewById(R.id.italicBox);
        italicdata="false";
        italicBox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    italicdata = "true";
                }
            }
        });        inputText=(EditText)findViewById(R.id.inputText);

        ListAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,fonts_array);
        fontList=(ListView)findViewById(R.id.fontList);
        fontList.setAdapter(adapter);
        fontList.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                font=(String)parent.getItemAtPosition(position);
                Intent i = new Intent(getApplicationContext(), finalclass.class);
                i.putExtra("color", colour);
                i.putExtra("size",size);
                i.putExtra("input", inputText.getText().toString());
                i.putExtra("bold",bolddata);
                i.putExtra("italic",italicdata);
                i.putExtra("font",font);
                startActivity(i);
                finish();

            }
        });


    }


}
