package com.brillicaservices.gurjas.firebasemoviessample.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.brillicaservices.gurjas.firebasemoviessample.movies.MoviesModelView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    //database name
    private static final String DATABASE_NAME = "movies_db";

    //table name
    private static final String TABLE_NAME = "movies_record";

    //column names

    private static final String TITLE_NAME = "Title";
    private static final String MOVIE_IMAGE = "Image";
    private static final String YEAR = "Year";
    private static final String RATING = "Rating";
    private static final String DESCRIPTION = "Description";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME+ "("+

            TITLE_NAME + " TEXT," +
            MOVIE_IMAGE + "BLOB," +
            YEAR + " INTEGER," +
            RATING + "INTEGER ," +
            DESCRIPTION + "TEXT ); ";

    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(db);

    }
    public long addNewMovie(MoviesModelView movieModel){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(TITLE_NAME, movieModel.title);

        contentValues.put(MOVIE_IMAGE, movieModel.image);
        contentValues.put(YEAR, movieModel.releaseYear);
        contentValues.put(RATING, movieModel.rating);
        contentValues.put(DESCRIPTION, movieModel.description);

        long id = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        sqLiteDatabase.close();

        return id;

    }

    public MoviesModelView getSingleMovieDetails(long id) {
        SQLiteDatabase sqLiteDatabases = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabases.query(TABLE_NAME, new String[]{Arrays.toString(new String[]{ TITLE_NAME, MOVIE_IMAGE, YEAR, RATING,
                        DESCRIPTION}) + "=?"}, null, new String[]{String.valueOf(id)},
         null, null, null,null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        MoviesModelView movieModel;
        movieModel = new MoviesModelView(cursor.getString(cursor.getColumnIndex(TITLE_NAME)), cursor.getString(cursor.getColumnIndex(DESCRIPTION)),
                cursor.getInt(cursor.getColumnIndex(YEAR)), cursor.getInt(cursor.getColumnIndex(RATING)), cursor.getInt(cursor.getColumnIndex(MOVIE_IMAGE)));

        cursor.close();

        return movieModel;
    }

        public List<MoviesModelView> allStudentsDetails()  {
            List<MoviesModelView> movieList = new ArrayList<>();
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

            String selectQuery = " SELECT * FROM " + TABLE_NAME ;

             sqLiteDatabase = this.getWritableDatabase();

            Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);

            if (cursor.moveToFirst()) {
                do {
                    MoviesModelView movieModel = new MoviesModelView();

                    movieModel.setTitle(cursor.getString(cursor.getColumnIndex(TITLE_NAME)));
                    movieModel.setReleaseYear(cursor.getInt(cursor.getColumnIndex(YEAR)));
                    movieModel.setDescription(cursor.getString(cursor.getColumnIndex(DESCRIPTION)));
                    movieModel.setImage(cursor.getInt(cursor.getColumnIndex(MOVIE_IMAGE)));
                    movieModel.setRating(cursor.getInt(cursor.getColumnIndex(RATING)));

                    movieList.add(movieModel);
                } while (cursor.moveToNext());
            }

            sqLiteDatabase.close();

            return  movieList;
        }

    public int getMovieCount() {

        String query = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        int totalMovieCount = cursor.getCount();
        cursor.close();

        return totalMovieCount;
    }

    public int updateIndividualMovieDetails(MoviesModelView movieModel) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(MOVIE_IMAGE, movieModel.getImage());
        values.put(TITLE_NAME, movieModel.getTitle());
        values.put(RATING, movieModel.getRating());
        values.put(YEAR, movieModel.getReleaseYear());
        values.put(DESCRIPTION, movieModel.getDescription());

        // updating row
        return sqLiteDatabase.update(TABLE_NAME, values, null,null);
    }

}


