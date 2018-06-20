package com.brillicaservices.gurjas.firebasemoviessample.movies;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.brillicaservices.gurjas.firebasemoviessample.R;

import java.util.ArrayList;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {

    ArrayList<MoviesModelView> moviesModelViewArrayList = new ArrayList<>();
    public MovieListAdapter(ArrayList<MoviesModelView> moviesModelViewArrayList){
        this.moviesModelViewArrayList = moviesModelViewArrayList;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View itemView = layoutInflater.inflate(R.layout.recycler_list_item, parent, false);

        MovieViewHolder movieViewHolder = new MovieViewHolder(itemView);

        return movieViewHolder;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        MoviesModelView moviesModelView = moviesModelViewArrayList.get(position);

        holder.movieThumbnail.setImageResource(moviesModelView.image);
        holder.movieName.setText(moviesModelView.title);
        holder.movieDescription.setText(moviesModelView.description);
        holder.rating.setText(""+moviesModelView.rating+"/5");
    }

    @Override
    public int getItemCount() {
        return moviesModelViewArrayList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView movieThumbnail;
        TextView movieName, movieDescription, rating;

        public MovieViewHolder(View itemView) {
            super(itemView);

            movieThumbnail = itemView.findViewById(R.id.movie_thumbnail);
            movieName = itemView.findViewById(R.id.movie_name_title);
            movieDescription = itemView.findViewById(R.id.movie_description);
            rating = itemView.findViewById(R.id.movie_rating);
        }
    }
}
