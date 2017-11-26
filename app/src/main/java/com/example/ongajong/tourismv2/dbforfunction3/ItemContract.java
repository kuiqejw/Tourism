package com.example.ongajong.tourismv2.dbforfunction3;

import android.provider.BaseColumns;

/**
 * Created by ongajong on 26/11/2017.
 */

class ItemContract implements BaseColumns {
    public static final String TABLE_NAME = "com.example.ongajong.tourismv2.dbforfunction3";
    public static final int DB_VERSION = 1;
    public static final String TABLE = "destinations_list";

    public class Columns{
        public static final String ITEM = "items";
        public static final String CHECKED = "checked";
        public static final String _ID = BaseColumns._ID;
    }

}
