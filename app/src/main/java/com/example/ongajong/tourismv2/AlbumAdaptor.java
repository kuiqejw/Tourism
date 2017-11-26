package com.example.ongajong.tourismv2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ongajong on 26/11/2017.
 */

public class AlbumAdaptor extends RecyclerView.Adapter<AlbumAdaptor.AlbumViewHolder> {

    public static class AlbumViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView destinationname;
        ImageView destinationphoto;

        AlbumViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            destinationname = (TextView)itemView.findViewById(R.id.destinationname);
            destinationphoto = (ImageView)itemView.findViewById(R.id.destinationphoto);
        }
    }

    List<Album> destinations;

    public AlbumAdaptor(ArrayList<Album> destinations){
        this.destinations = destinations;
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_cardview, viewGroup, false);
        AlbumViewHolder pvh = new AlbumViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(AlbumViewHolder personViewHolder, int i) {
        personViewHolder.destinationname.setText(destinations.get(i).name);
        personViewHolder.destinationphoto.setImageResource(destinations.get(i).photoId);
    }

    @Override
    public int getItemCount() {
        return 0;
        //return destinations== null ? 0 : destinations.size();
    }
}
