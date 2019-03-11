package com.giabusyra.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //ListView
    ListView listView;

    public void generateTimesTable(int timeTable){

        //Array for time table
        ArrayList<String> timeTableContent = new ArrayList<String>();

        for (int  i=1; i<= 10; i++){
            timeTableContent.add(Integer.toString(i * timeTable));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,timeTableContent);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Seekbar and ListVIew
        SeekBar seekBar = findViewById(R.id.timeSeekBar);
        listView = findViewById(R.id.timeTableView);
        seekBar.setMax(20);
        seekBar.setProgress(5);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int min = 1;
                int time;

                if(progress < 1){
                    time = min;
                    seekBar.setProgress(min);
                } else{
                    time = progress;
                }
                Log.i("Value", Integer.toString(time));
                generateTimesTable(time);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        generateTimesTable(10);

    }
}
