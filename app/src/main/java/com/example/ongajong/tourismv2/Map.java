package com.example.ongajong.tourismv2;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.arlib.floatingsearchview.FloatingSearchView;
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;

public class Map extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String[][] dictionary = {{"Sentosa", "1.2494041", "103.830321", "RWS", "Resort World Sentosa", "rws"},
            {"Marina Bay Sands", "1.2828484", "103.8609294", "Marina Bay", "Bay Sands", "Marina", "MBS", "mbs"},
            {"Singapore Flyer", "1.2895301", "103.8632483", "Flyer"},
            {"Singapore Zoo", "1.352083", "103.819836", "Zoo", "zoo"},
            {"Vivo City", "1.26463", "103.8207793", "Vivo"},
            {"Buddha Tooth Relic Temple", "1.2815901", "103.8443033", "Buddha Tooth", "Tooth Relic Temple", "Relic Temple"},
            {"Supreme Court & City Hall", "1.2899018", "103.8509197", "City Hall", "Court", "Supreme Court", "Singapore Court"},
            {"Ion Orchard", "1.3040258", "103.8319648", "Ion", "ion", "Orchard"}, {"Botanic Gardens", "1.3138397", "103.8159136", "Botanic", "Gardens"},
            {"Peranakan Museum", "1.2943669", "103.8490391", "Peranakan", "Museum"}};
    private double lat = 1.3521;
    private double lng = 103.8198;//I would like to say first that longitude is terrible
    private LatLng latlng = new LatLng(lat,lng);
    private String input;
    public String result;
    private FloatingSearchView searchView;
    private TextView result_bar;
    private RadioButton rmap,rsat,rhyb;
    private EditText searchQ;
    private Button btn_search;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.activity_maps,container, false);
        result_bar = (TextView) inflatedView.findViewById(R.id.results);
        rmap = (RadioButton) inflatedView.findViewById(R.id.map_view);
        rsat = (RadioButton) inflatedView.findViewById(R.id.sat_view);
        rhyb = (RadioButton) inflatedView.findViewById(R.id.hybrid_view);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        searchQ = (EditText) inflatedView.findViewById(R.id.ed_Search);
        btn_search = (Button) inflatedView.findViewById(R.id.btn_search);
        btn_search.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view){
                        String searchText = searchQ.getText().toString();
                        result = compare(dictionary,searchText);
                        result_bar.setText(result);
                    }
                }
        );
        //searchView = (FloatingSearchView) getActivity().findViewById(R.id.floating_search_view);
        /*searchView.setOnSearchListener(new FloatingSearchView.OnSearchListener(){
            @Override
            public void onSuggestionClicked(SearchSuggestion searchSuggestion) {
                //loathsome need to clear the variable
                Log.i("Do", "Nothing");
            }

            @Override
            public void onSearchAction(String query){
                input = searchView.getQuery();
                result = compare(dictionary,input);
                result_bar.setText(result);
            }}
        );*/
        rmap.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (v==rmap){
                    mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

                }
            }

        });
        rsat.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (v==rmap){
                    mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

                }
            }

        });
        rhyb.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (v==rhyb){
                    mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

                }
            }

        });
        return inflatedView;
    }

    public String compare(String[][] dictionary, String input) {//This is the regex expression
        //todo replace this with suitable regex comparison
        String val = "";
        int distance = 0;
        int min = 100;
        int list_no = 0;
        for(int i = 0; i<dictionary.length; i++) {
            for (String str : dictionary[i]) {
                distance = LD(str, input);
                if (min > distance) {
                    min = distance;
                    list_no = i;
                }
            }
        }
        lat = Double.parseDouble(dictionary[list_no][1]);
        lng = Double.parseDouble(dictionary[list_no][2]);
        if ((input.length()<5 && min>4) || min >= input.length() - 1 || min>7){
            Toast.makeText(getContext(),"No match found", Toast.LENGTH_LONG).show();
            return "";
        }
        else val = dictionary[list_no][0];
        latlng = new LatLng(lat,lng);
//        val = Integer.toString(min) + " " + val;
        mMap.addMarker(new MarkerOptions().position(latlng));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latlng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16.0f));
        return val;
    }

    public int LD(String s, String t) {
        int d[][]; // matrix
        int n; // length of s
        int m; // length of t
        int i; // iterates through s
        int j; // iterates through t
        char s_i; // ith character of s
        char t_j; // jth character of t
        int cost; // cost

        // Step 1

        n = s.length();
        m = t.length();
        if (n == 0) {
            return m;
        }
        if (m == 0) {
            return n;
        }
        d = new int[n + 1][m + 1];

        // Step 2

        for (i = 0; i <= n; i++) {
            d[i][0] = i;
        }

        for (j = 0; j <= m; j++) {
            d[0][j] = j;
        }

        // Step 3

        for (i = 1; i <= n; i++) {

            s_i = s.charAt(i - 1);

            // Step 4

            for (j = 1; j <= m; j++) {

                t_j = t.charAt(j - 1);

                // Step 5

                if (s_i == t_j) {
                    cost = 0;
                } else {
                    cost = 1;
                }

                // Step 6

                d[i][j] = Minimum(d[i - 1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1] + cost);

            }

        }

        // Step 7

        return d[n][m];

    }

    private int Minimum(int a, int b, int c) {
        int mi;

        mi = a;
        if (b < mi) mi = b;
        if (c < mi) mi = c;

        return mi;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        mMap.addMarker(new MarkerOptions().position(latlng));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latlng));
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.animateCamera(CameraUpdateFactory.zoomTo(10.0f));

    }
}
