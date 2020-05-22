package sg.edu.rp.webservices.song;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "simplenotes.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NOTE = "song";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_SINGERS = "singers";
    private static final String COLUMN_YEAR = "_years";
    private static final String COLUMN_STARS = "_stars";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createNoteTableSql = "CREATE TABLE " + TABLE_NOTE + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_TITLE + " TEXT, " + COLUMN_SINGERS + " TEXT, " + COLUMN_YEAR + " INTEGER, "+ COLUMN_STARS + " INTEGER )";
        db.execSQL(createNoteTableSql);

        }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("ALTER TABLE " + TABLE_NOTE + " ADD COLUMN  module_name TEXT");
        onCreate(db);
    }
//..............................................INSERT.........................................................................
    //INSERT TITLE..................................................
    public long insertTitle(String title) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, title);
        long result = db.insert(COLUMN_TITLE,null, values);
        db.close();
        Log.d("SQL Insert","ID:"+ result); //id returned, shouldn’t be -1
        return result;
    }

    //INSERT SINGERS.......................................................
    public long insertSingers(String singers) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SINGERS, singers);
        long result = db.insert(COLUMN_SINGERS,null, values);
        db.close();
        Log.d("SQL Insert","ID:"+ result); //id returned, shouldn’t be -1
        return result;
    }

    //INSERT YEARS...................................
    public long insertYears(String years) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_YEAR, years);
        long result = db.insert(COLUMN_YEAR,null, values);
        db.close();
        Log.d("SQL Insert","ID:"+ result); //id returned, shouldn’t be -1
        return result;
    }

    //INSERT STARS...................................
    public long insertStars(String stars) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_STARS, stars);
        long result = db.insert(COLUMN_STARS,null, values);
        db.close();
        Log.d("SQL Insert","ID:"+ result); //id returned, shouldn’t be -1
        return result;
    }
    //..............................................INSERT END.....................................................

//........................................RETRIEVE.....................................................................
    //RETRIEVE TITLE........................
public ArrayList<Song> getAllSong() {
    ArrayList<Song> songs = new ArrayList<Song>();

    String selectQuery = "SELECT " + COLUMN_ID + ","
            + COLUMN_TITLE + " FROM " + TABLE_NOTE;

    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.rawQuery(selectQuery, null);
    if (cursor.moveToFirst()) {
        do {
            int id = cursor.getInt(0);
            String COLUMN_TITLE = cursor.getString(1);
            Song song = new Song(id, COLUMN_TITLE);
            songs.add(song);
        } while (cursor.moveToNext());
    }
    cursor.close();
    db.close();
    return songs;
}

}
