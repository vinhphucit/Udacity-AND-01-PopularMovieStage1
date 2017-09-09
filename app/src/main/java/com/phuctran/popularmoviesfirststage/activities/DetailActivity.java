package com.phuctran.popularmoviesfirststage.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.phuctran.popularmoviesfirststage.R;
import com.phuctran.popularmoviesfirststage.models.MovieModel;
import com.squareup.picasso.Picasso;

import butterknife.BindView;

/**
 * Created by phuctran on 9/9/17.
 */

public class DetailActivity extends BaseActivity {
    private static final String TAG = DetailActivity.class.getSimpleName();

    public static final String EXTRA_MOVIE_MODEL = "EXTRA_MOVIE_MODEL";

    @BindView(R.id.ivDetailThumbnail)
    ImageView ivDetailThumbnail;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.tvOverview)
    TextView tvOverview;
    @BindView(R.id.tvReleaseDate)
    TextView tvReleaseDate;
    @BindView(R.id.tvVoteAverage)
    TextView tvVoteAverage;

    private MovieModel mMovieModel;

    @Override
    protected void updateFollowingViewBinding(Bundle savedInstanceState) {
        Intent intentThatStartedThisActivity = getIntent();
        if (intentThatStartedThisActivity.hasExtra(EXTRA_MOVIE_MODEL)) {
            mMovieModel = intentThatStartedThisActivity.getParcelableExtra(EXTRA_MOVIE_MODEL);
        }

        tvTitle.setText(mMovieModel.getTitle());
        tvOverview.setText(mMovieModel.getOverview());
        tvReleaseDate.setText(mMovieModel.getRelease_date());
        tvVoteAverage.setText(mMovieModel.getVote_average());

        Picasso.with(this).load("http://image.tmdb.org/t/p/w185/" + mMovieModel.getBackdrop_path()).into(ivDetailThumbnail);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(mMovieModel.getTitle());
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_detail;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
