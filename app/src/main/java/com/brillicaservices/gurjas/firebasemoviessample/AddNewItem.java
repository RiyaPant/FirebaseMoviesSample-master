package com.brillicaservices.gurjas.firebasemoviessample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.brillicaservices.gurjas.firebasemoviessample.database.DatabaseHelper;
import com.brillicaservices.gurjas.firebasemoviessample.movies.MoviesModelView;

import java.sql.Array;
import java.util.Collections;

public class AddNewItem extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Integer imagesArray[] = new Integer[]{R.drawable.avengers_infinity_war,
            R.drawable.avengers_infinity_war_imax_poster,
            R.drawable.dark_knight,
            R.drawable.deadpool,
            R.drawable.fast_furious_7,
            R.drawable.fight_club,
            R.drawable.godfather,
            R.drawable.hancock,
            R.drawable.harry_potter,
            R.drawable.inception,
            R.drawable.into_the_wild,
            R.drawable.iron_man_3,
            R.drawable.pursuit_of_happiness,
            R.drawable.john_wick,
            R.drawable.lion_king,
            R.drawable.rocky,
            R.drawable.shawshank_redemption,
            R.drawable.wanted};

    int movieThumbnails;
    Spinner category, movieThumbnail;


    DatabaseHelper databaseHelper;
    EditText movieTitle,releaseYear,description;
    Button savebutton;
    RatingBar rating;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_item);
        databaseHelper = new DatabaseHelper(this);

        movieThumbnail = findViewById(R.id.item_image);
        ArrayAdapter<Integer> movieThumbnailAdapter = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_spinner_dropdown_item, imagesArray);
        movieThumbnail.setAdapter(movieThumbnailAdapter);

        movieThumbnail.setPrompt("Select Image");

        movieThumbnail.setOnItemSelectedListener(this);

        movieTitle = findViewById((R.id.item_title));
        releaseYear = findViewById((R.id.release_year));
        description = findViewById(R.id.item_description);
        savebutton = findViewById(R.id.save_item);
        rating = findViewById((R.id.item_rating));




        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                 * On the click of the button, getting values from
                 * the user input.*/
                String title = movieTitle.getText().toString();
                int year = Integer.parseInt(releaseYear.getText().toString());
                String des = description.getText().toString();
                int rat = (int)rating.getRating();

                /*
                 * Storing the new values into the arrayList using the
                 * Student class object.*/
                databaseHelper.addNewMovie(new MoviesModelView(title, des, year, rat, movieThumbnails));

                /*
                 * Showing a success message once the data has been saved into arrayList*/
                Toast.makeText(getApplicationContext(), "Movie Saved Succesfully", Toast.LENGTH_LONG).show();
            }
        });
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        movieThumbnails=imagesArray[position];

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
