package com.phuctran.popularmoviesfirststage.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.phuctran.popularmoviesfirststage.R;
import com.phuctran.popularmoviesfirststage.models.MovieModel;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by phuctran on 9/9/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private static final String TAG = MovieAdapter.class.getSimpleName();
    private List<MovieModel> mMovieItems;
    private Context mContext;
    final private ListItemClickListener mOnClickListener;

    public interface ListItemClickListener {
        void onListItemClick(MovieModel movieModel);
    }

    public MovieAdapter(Context context, List<MovieModel> mMovieItems, ListItemClickListener listener) {
        this.mContext = context;
        this.mMovieItems = mMovieItems;
        this.mOnClickListener = listener;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.movie_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediatelly = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediatelly);
        MovieViewHolder viewHolder = new MovieViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mMovieItems.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.ivThumbnail)
        ImageView ivThumbnail;

        public MovieViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        void bind(int position) {
            final MovieModel movieModel = mMovieItems.get(position);

            Picasso.with(mContext).load("http://image.tmdb.org/t/p/w185/"+movieModel.getPoster_path()).into(ivThumbnail);
        }

        @Override
        public void onClick(View view) {
            int clickPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(mMovieItems.get(clickPosition));
        }
    }
}
