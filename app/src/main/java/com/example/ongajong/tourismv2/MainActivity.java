package com.example.ongajong.tourismv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

    public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
        Button btn_preferences = (Button) findViewById(R.id.btn_preferences);
        Button btn_map = (Button) findViewById(R.id.btn_Map);
        Button btn_scroller = (Button) findViewById(R.id.btn_Scroller);
        Button btn_weather = (Button) findViewById(R.id.btn_Weather);
        btn_weather.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                launchWeather();
            }

        });
        btn_scroller.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                launchTour();
            }

        });
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

        private void launchTour() {

            Intent intent = new Intent(this, Weather.class);
            startActivity(intent);
        }

        private void launchWeather() {
        Intent intent = new Intent(this, Weather.class);
        startActivity(intent);
    }
}
