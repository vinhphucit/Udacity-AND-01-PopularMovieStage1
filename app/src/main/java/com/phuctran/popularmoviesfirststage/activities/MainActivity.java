package com.phuctran.popularmoviesfirststage.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.phuctran.popularmoviesfirststage.R;
import com.phuctran.popularmoviesfirststage.adapters.MovieAdapter;
import com.phuctran.popularmoviesfirststage.enums.MovieSortType;
import com.phuctran.popularmoviesfirststage.models.MovieModel;
import com.phuctran.popularmoviesfirststage.models.MovieResponseWrapper;
import com.phuctran.popularmoviesfirststage.utils.NetworkUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MovieAdapter.ListItemClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.rv_movies)
    RecyclerView mRvMovies;

    private MovieAdapter mMovieAdapter;
    private int mSpanCount = 2;
    private List<MovieModel> mMovies = new ArrayList<>();

    @Override
    protected void updateFollowingViewBinding(Bundle savedInstanceState) {
        setupRecyclerView();
        getMovieData(MovieSortType.MOST_POPULART);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int menuItemThatWasSelected = item.getItemId();
        switch (menuItemThatWasSelected) {
            case R.id.action_most_popular:
                getMovieData(MovieSortType.MOST_POPULART);
                item.setChecked(true);
                return true;
            case R.id.action_highest_rated:
                getMovieData(MovieSortType.HIGHEST_RATED);
                item.setChecked(true);
                return true;
            default:
                return false;
        }

    }

    private void setupRecyclerView() {
        GridLayoutManager layoutManager = new GridLayoutManager(this, mSpanCount);
        mRvMovies.setLayoutManager(layoutManager);
        mRvMovies.setHasFixedSize(true);


    }

    private void getMovieData(MovieSortType movieSortType) {
        String urlQuery = "";
        switch (movieSortType) {
            case MOST_POPULART:
                urlQuery = NetworkUtils.MOVIE_API_POPULAR;
                break;
            case HIGHEST_RATED:
                urlQuery = NetworkUtils.MOVIE_API_RATED;
                break;
            default:
                urlQuery = NetworkUtils.MOVIE_API_POPULAR;
                break;
        }

        new NetworkTask(urlQuery).execute();
    }

    @Override
    public void onListItemClick(MovieModel movieModel) {
        Intent startChildActivityIntent = new Intent(this, DetailActivity.class);
        startChildActivityIntent.putExtra(DetailActivity.EXTRA_MOVIE_MODEL, movieModel);
        startActivity(startChildActivityIntent);
    }

    class NetworkTask extends AsyncTask<Void, Void, List<MovieModel>> {
        private String url;

        public NetworkTask(String url) {
            this.url = url;
        }

        @Override
        protected List<MovieModel> doInBackground(Void... urls) {
            try {
                String strMovies = NetworkUtils.getResponseFromHttpUrl(NetworkUtils.buildUrl(url));

                List<MovieModel> yourList = (new Gson().fromJson(strMovies, MovieResponseWrapper.class)).getResults();
                return yourList;
            } catch (IOException e) {
                e.printStackTrace();
                return new ArrayList<>();
            }
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(List<MovieModel> s) {
            super.onPostExecute(s);
            mMovieAdapter = new MovieAdapter(MainActivity.this, s, MainActivity.this);
            mRvMovies.setAdapter(mMovieAdapter);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }

}
