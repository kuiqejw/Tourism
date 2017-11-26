package com.example.ongajong.tourismv2.MapIntent;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by ongajong on 26/11/2017.
 */

public class MapActivity extends FragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if (savedInstanceState== null){
            getSupportFragmentManager().beginTransaction()
                    .add(android.R.id.content, new Map()).commit();
        }
    }
}
