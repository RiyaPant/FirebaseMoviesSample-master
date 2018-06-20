package com.brillicaservices.gurjas.firebasemoviessample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;

import com.brillicaservices.gurjas.firebasemoviessample.database.DatabaseHelper;
import com.brillicaservices.gurjas.firebasemoviessample.movies.MovieListAdapter;
import com.brillicaservices.gurjas.firebasemoviessample.movies.MoviesModelView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView recyclerView;
    MovieListAdapter movieListAdapter;
    ArrayList<MoviesModelView> moviesModelViewArrayList = new ArrayList<>();
    Spinner category;
    String categoryNames[]={"Action","Thriller","Suspense","Comedy","Fanatsy"};
    DatabaseHelper databaseHelper;
    /*TODO(0): Click on File>Settings>Plugins>Browser Respositories> Android Drawable Importer. Install the plugin to add images.
    * TODO(1): Now, right click on drawable> New> Batch Drawable. to import all the images and into different sizes like mdpi, hdpi, xhdpi etc.
    * TODO(2): Create a database handler class
    * TODO(3): Save all the details for Movies, series into the database.
    * TODO(4): Create two different tables into the database.
    * TODO(5): Implement the SeriesModelView class
    * TODO(6): Clicking on AddNew floating button, on MainActivity, user should be able to add a new item into movie or series category.
    * TODO(7): Implement onClickListener on Movies, Series. On Click it should display a toast message, containing the movie name.
    * TODO(8): Implement all the required classes into Manifest file.
    * TODO(9): Test and debug the application and share it on github.*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddNewItem.class);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        getListOfMovies();
        movieListAdapter = new MovieListAdapter(moviesModelViewArrayList);
        recyclerView.setAdapter(movieListAdapter);


    }

    private void getListOfMovies() {
        moviesModelViewArrayList.add(new MoviesModelView("Dark Knight Rises", "Starring: Christain Bale " +
                "\nThis movie is second in series of Batman", 2018, 4, R.drawable.dark_knight));
        moviesModelViewArrayList.add(new MoviesModelView("Dark Knight Rises", "Starring: Christain Bale " +
                "\nThis movie is second in series of Batman", 2018, 4, R.drawable.avengers_infinity_war));
        moviesModelViewArrayList.add(new MoviesModelView("Dark Knight Rises", "Starring: Christain Bale " +
                "\nThis movie is second in series of Batman", 2018, 4, R.drawable.deadpool));
        moviesModelViewArrayList.add(new MoviesModelView("Dark Knight Rises", "Starring: Christain Bale " +
                "\nThis movie is second in series of Batman", 2018, 4, R.drawable.fast_furious_7));
        moviesModelViewArrayList.add(new MoviesModelView("Dark Knight Rises", "Starring: Christain Bale " +
                "\nThis movie is second in series of Batman", 2018, 4, R.drawable.fight_club));
        moviesModelViewArrayList.add(new MoviesModelView("Dark Knight Rises", "Starring: Christain Bale " +
                "\nThis movie is second in series of Batman", 2018, 4, R.drawable.dark_knight));
        moviesModelViewArrayList.add(new MoviesModelView("Dark Knight Rises", "Starring: Christain Bale " +
                "\nThis movie is second in series of Batman", 2018, 4, R.drawable.wanted));
        moviesModelViewArrayList.add(new MoviesModelView("Dark Knight Rises", "Starring: Christain Bale " +
                "\nThis movie is second in series of Batman", 2018, 4, R.drawable.lion_king));
        moviesModelViewArrayList.add(new MoviesModelView("Dark Knight Rises", "Starring: Christain Bale " +
                "\nThis movie is second in series of Batman", 2018, 4, R.drawable.john_wick));
        moviesModelViewArrayList.add(new MoviesModelView("Dark Knight Rises", "Starring: Christain Bale " +
                "\nThis movie is second in series of Batman", 2018, 4, R.drawable.pursuit_of_happiness));
        moviesModelViewArrayList.add(new MoviesModelView("Dark Knight Rises", "Starring: Christain Bale " +
                "\nThis movie is second in series of Batman", 2018, 4, R.drawable.iron_man_3));
        moviesModelViewArrayList.add(new MoviesModelView("Dark Knight Rises", "Starring: Christain Bale " +
                "\nThis movie is second in series of Batman", 2018, 4, R.drawable.dark_knight));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_movies) {

        } else if (id == R.id.nav_series) {
            // start activity for series
        } else if (id == R.id.nav_about_us) {
            Intent intent = new Intent(MainActivity.this, AboutMe.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
