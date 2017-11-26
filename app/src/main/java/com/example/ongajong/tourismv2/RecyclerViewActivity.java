package com.example.ongajong.tourismv2;

/**
 * Created by ongajong on 26/11/2017.
 */

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends Activity {

    private ArrayList<Album> destinations;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recyclerview);

        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeData() {
        ArrayList<Object> destinations = new ArrayList<>();
        destinations.add(new Album("Botanic Gardens", R.drawable.botanicgardens));
        destinations.add(new Album("Gardens By the bay", R.drawable.gardensbybay));
        destinations.add(new Album("Marina Bay Sands", R.drawable.mbs));
        destinations.add(new Album("National Orchid Garden", R.drawable.nationalorchid));
        destinations.add(new Album("Universal Studios Singapore", R.drawable.sentosa));
        destinations.add(new Album("Singapoe Flyer", R.drawable.singaporeflyer));
        destinations.add(new Album("Singapoe Zoo", R.drawable.zoo4));
    }

    private void initializeAdapter(){
        AlbumAdaptor adapter = new AlbumAdaptor(destinations);
        rv.setAdapter(adapter);
    }
}