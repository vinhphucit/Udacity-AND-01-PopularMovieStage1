package com.phuctran.popularmoviesfirststage.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by phuctran on 9/9/17.
 */

public class MovieModel implements Parcelable {
    private String vote_count;
    private String id;
    private String vote_average;
    private String title;
    private String popularity;
    private String poster_path;
    private String original_title;
    private String overview;
    private String release_date;
    private String backdrop_path;

    public MovieModel(String vote_count, String id, String vote_average, String title, String popularity, String poster_path, String original_title, String overview, String release_date, String backdrop_path) {
        this.vote_count = vote_count;
        this.id = id;
        this.vote_average = vote_average;
        this.title = title;
        this.popularity = popularity;
        this.poster_path = poster_path;
        this.original_title = original_title;
        this.overview = overview;
        this.release_date = release_date;
        this.backdrop_path = backdrop_path;
    }

    public String getVote_count() {
        return vote_count;
    }

    public void setVote_count(String vote_count) {
        this.vote_count = vote_count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.vote_count);
        dest.writeString(this.id);
        dest.writeString(this.vote_average);
        dest.writeString(this.title);
        dest.writeString(this.popularity);
        dest.writeString(this.poster_path);
        dest.writeString(this.original_title);
        dest.writeString(this.overview);
        dest.writeString(this.release_date);
        dest.writeString(this.backdrop_path);
    }

    protected MovieModel(Parcel in) {
        this.vote_count = in.readString();
        this.id = in.readString();
        this.vote_average = in.readString();
        this.title = in.readString();
        this.popularity = in.readString();
        this.poster_path = in.readString();
        this.original_title = in.readString();
        this.overview = in.readString();
        this.release_date = in.readString();
        this.backdrop_path = in.readString();
    }

    public static final Parcelable.Creator<MovieModel> CREATOR = new Parcelable.Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel source) {
            return new MovieModel(source);
        }

        @Override
        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };
}
