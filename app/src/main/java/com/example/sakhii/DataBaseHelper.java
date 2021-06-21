package com.example.sakhii;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.sakhii.RestaurantModel;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String RESTAURANT_TABLE = "RESTAURANT_TABLE";
    public static final String ID = "ID";
    public static final String COLOUMN_NAME = "COLOUMN_NAME";
    public static final String COLOUMN_LOCALITY = "COLOUMN_LOCALITY";
    public static final String COLOUMN_STAFF = "COLOUMN_STAFF";
    public static final String ALCOHOL = "ALCOHOL";
    public static final String SAFE = "SAFE";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "feedback.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + RESTAURANT_TABLE + " (" + ID + " INTEGER PRIMARY KEY  AUTOINCREMENT, " + COLOUMN_NAME + " TEXT , " + COLOUMN_LOCALITY + " TEXT, " + COLOUMN_STAFF + " TEXT, " + ALCOHOL + " BOOL, " + SAFE + " BOOL )";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean addOne(RestaurantModel restaurantModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLOUMN_NAME, restaurantModel.getName());
        cv.put(COLOUMN_LOCALITY, restaurantModel.getLocality());

        cv.put(COLOUMN_STAFF, restaurantModel.getStaff());
        cv.put(ALCOHOL, restaurantModel.isAlcohol());
        cv.put(SAFE, restaurantModel.isSafe());
        long insert = db.insert(RESTAURANT_TABLE, null, cv);
        if(insert == -1){
            return false;
        }
        else{
            return true;
        }



    }
    public List<RestaurantModel> getEveryone(){
        List<RestaurantModel> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM "  + RESTAURANT_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()){
            do{
                int restaurantID = cursor.getInt(0);
                String restaurantName = cursor.getString(1);
                String resturantLocality = cursor.getString(2);
                String restaurantStaff = cursor.getString(3);
                boolean alcohol = cursor.getInt(4) == 1 ? true: false;
                boolean safe = cursor.getInt(5) == 1 ? true: false;

                RestaurantModel newRestaurant = new RestaurantModel(restaurantID, restaurantName, resturantLocality , restaurantStaff, alcohol, safe);
                returnList.add(newRestaurant);
            }while(cursor.moveToNext());
        }
        else{

        }
        cursor.close();
        db.close();
        return returnList;
    }

}

