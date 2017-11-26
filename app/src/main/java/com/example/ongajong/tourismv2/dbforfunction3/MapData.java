package com.example.ongajong.tourismv2.dbforfunction3;

import java.util.HashMap;

/**
 * Created by ongajong on 26/11/2017.
 */

public class MapData {
    //stores data for travelling Salesman Problem using nearest neighbor algorithm
    //I blame my father for this

    public static HashMap<String, double[]> createData(){
        HashMap<String, double[]> data = new HashMap<String, double[]> ();

        /**
         * FOR REFERENCE:
         * A --> Marina Bay Sands
         * B --> Singapore Flyer
         * C --> Vivo City
         * D --> Resorts World Sentosa
         * E --> Buddha Tooth Relic Temple
         * F --> Singapore Zoo/ Zoo
         * G --> Singapore Botanic Gardens/ Botanic Gardens
         * H --> Peranakan Museum
         * I --> ION Orchard
         * e.g. from A to B = {publicCost, publicTime, taxiCost, taxiTime, walkCost, walkTime}
         *
         * These travel times and costs are referenced from gothere.sg and Google Maps Directions tool. **/

        double[] listAB = {0.83, 17, 3.22, 3, 0, 14};
        double[] listAC = {1.18, 26, 6.96, 14, 0, 69};
        double[] listAD = {4.03, 35, 8.50, 19, 0, 76};
        double[] listAE = {0.88, 19, 4.98, 8, 0, 28};
        double[] listAF = {1.96, 84, 18.4, 30, 0, 269};


        double[] listBA = {0.83, 17, 4.32, 6, 0, 14};
        double[] listBC = {1.26, 31, 7.84, 13, 0, 81};
        double[] listBD = {4.03, 38, 9.38, 18, 0, 88};
        double[] listBE = {0.98, 24, 4.76, 8, 0, 39};
        double[] listBF = {1.89, 85, 18.18, 29, 0, 264};

        double[] listCA = {1.18, 24, 8.30, 12, 0, 69};
        double[] listCB = {1.26, 29, 7.96, 14, 0, 81};
        double[] listCD = {2.00, 10, 4.54, 9, 0, 12};
        double[] listCE = {0.98, 18, 6.42, 11, 0, 47};
        double[] listCF = {1.99, 85, 22.58, 31, 0, 270};

        double[] listDA = {1.18, 33, 8.74, 13, 0, 76};
        double[] listDB = {1.26, 38, 8.40, 14, 0, 88};
        double[] listDC = {0.00, 10, 3.22, 4, 0, 12};
        double[] listDE = {0.98, 27, 6.64, 12, 0, 55};
        double[] listDF = {1.99, 92, 22.80, 32, 0, 285};

        double[] listEA = {0.88, 18, 5.32, 7, 0, 28};
        double[] listEB = {0.98, 23, 4.76, 8, 0, 39};
        double[] listEC = {0.98, 19, 4.98, 9, 0, 47};
        double[] listED = {3.98, 28, 6.52, 14, 0, 55};
        double[] listEF = {1.91, 83, 18.4, 30, 0, 264};

        double[] listFA = {1.88, 86, 22.48, 32, 0, 269};
        double[] listFB = {1.96, 87, 19.40, 29, 0, 264};
        double[] listFC = {2.11, 86, 21.48, 32, 0, 270};
        double[] listFD = {4.99, 96, 23.68, 36, 0, 285};
        double[] listFE = {1.91, 84, 21.60, 30, 0, 264};


        // Short-form keyword used here for neater coding.

        data.put("ab", listAB);
        data.put("ac", listAC);
        data.put("ad", listAD);
        data.put("ae", listAE);
        data.put("af", listAF);

        data.put("ba", listBA);
        data.put("bc", listBC);
        data.put("bd", listBD);
        data.put("be", listBE);
        data.put("bf", listBF);

        data.put("ca", listCA);
        data.put("cb", listCB);
        data.put("cd", listCD);
        data.put("ce", listCE);
        data.put("cf", listCF);

        data.put("da", listDA);
        data.put("db", listDB);
        data.put("dc", listDC);
        data.put("de", listDE);
        data.put("df", listDF);

        data.put("ea", listEA);
        data.put("eb", listEB);
        data.put("ec", listEC);
        data.put("ed", listED);
        data.put("ef", listEF);

        data.put("fa", listFA);
        data.put("fb", listFB);
        data.put("fc", listFC);
        data.put("fd", listFD);
        data.put("fe", listFE);

        return data;
    }
}