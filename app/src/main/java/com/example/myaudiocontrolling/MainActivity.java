package com.example.myaudiocontrolling;

import static android.R.*;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public void generateTimeTable(int progress){
        ListView myListView = findViewById(R.id.myListView);
        ArrayList<String > myFamily = new ArrayList<String>();
        myFamily.add(Integer.toString(progress*1));
        myFamily.add(Integer.toString(progress*2));
        myFamily.add(Integer.toString(progress*3));
        myFamily.add(Integer.toString(progress*4));
        myFamily.add(Integer.toString(progress*5));
        myFamily.add(Integer.toString(progress*6));
        myFamily.add(Integer.toString(progress*7));
        myFamily.add(Integer.toString(progress*8));
        myFamily.add(Integer.toString(progress*9));
        myFamily.add(Integer.toString(progress*10));
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this, layout.simple_list_item_1,myFamily);
        myListView.setAdapter(ad);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = findViewById(R.id.myseekbar);
        seekBar.setMin(1);
        seekBar.setMax(21);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                generateTimeTable(progress);
                TextView textView = findViewById(R.id.textView);
                int val = (progress * (seekBar.getWidth() - 2 * seekBar.getThumbOffset())) / seekBar.getMax();
                textView.setText("" + progress);
                textView.setX(seekBar.getX() + val + seekBar.getThumbOffset() / 2);

            }



            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




    }


}