package com.example.ongajong.tourismv2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ongajong on 26/11/2017.
 */

public class Album {
    String name;
    int photoId;

    Album(String name, int photoId) {
        this.name = name;
        this.photoId = photoId;
    }

}
/*

    private List<Album> Destinations;

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
*/
