package com.spiderinductions.danish.spideredittext;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class finalclass extends Activity {
    TextView text;
    Button edit;
    Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalclass);
        Intent b = getIntent();
        String color = b.getStringExtra("color");
        String size = b.getStringExtra("size");
        String bold = b.getStringExtra("bold");
        String italics = b.getStringExtra("italics");
        String font = b.getStringExtra("font");
        String input = b.getStringExtra("input");

        edit = (Button) findViewById(R.id.editButton);


        exit = (Button) findViewById(R.id.exitButton);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*  Intent intent = new Intent(getApplicationContext(),Activity3.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);*/
                finish();
                System.exit(0);
            }
        });

        text = (TextView) findViewById(R.id.finalText);
        text.setText(input);

        set_font(font);
        set_color(color);
        set_size(size);
        set_bold_or_italics(bold, italics);
    }

    public void onclick(View view) {
        Intent k = new Intent(this, MainActivity.class);
        startActivity(k);
    }


    private void set_color(String color) {
        if (color.equalsIgnoreCase("Red")) {
            text.setTextColor(Color.parseColor("#FF0000"));
        }
        if (color.equalsIgnoreCase("Blue")) {
            text.setTextColor(Color.parseColor("#4169E1"));
        }
        if (color.equalsIgnoreCase("Yellow")) {
            text.setTextColor(Color.parseColor("#fffff8"));
        }
        if (color.equalsIgnoreCase("Green")) {
            text.setTextColor(Color.parseColor("#FF33B7"));
        }
        if (color.equalsIgnoreCase("White")) {
            text.setTextColor(Color.parseColor("FFFFFF"));
        }
    }

    private void set_size(String size) {
        if (size.equals("10")) {
            text.setTextSize(10);
        }
        if (size.equals("25")) {
            text.setTextSize(25);
        }
        if (size.equals("35")) {
            text.setTextSize(35);
        }
        if (size.equals("45")) {
            text.setTextSize(45);
        }
        if (size.equals("75")) {
            text.setTextSize(75);
        }

    }

    private void set_bold_or_italics(String bold, String italics) {
        if (bold.equals("true") && italics.equals("true")) {
            text.setTypeface(text.getTypeface(), Typeface.BOLD_ITALIC);
        }
        if (bold.equals("true") && italics.equals("false")) {
            text.setTypeface(text.getTypeface(), Typeface.BOLD);
        }
        if (bold.equals("false") && italics.equals("true")) {
            text.setTypeface(text.getTypeface(), Typeface.ITALIC);
        }
    }

    private void set_font(String font) {
        if (font.equalsIgnoreCase("Arial")) {
            Typeface face = Typeface.createFromAsset(getAssets(), "arial.ttf");
            text.setTypeface(face);
        }
        if (font.equalsIgnoreCase("Monotype Corsiva")) {
            Typeface face = Typeface.createFromAsset(getAssets(), "MTCORSVA.ttf");
            text.setTypeface(face);
        }


    }
}
