package com.thakur.youtubeclone.adapter;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import com.thakur.youtubeclone.MainActivity;
import com.thakur.youtubeclone.R;
import com.thakur.youtubeclone.model.YoutubeVideo;
import com.thakur.youtubeclone.viewholder.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;
public class YoutubeRecyclerAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    public static final int VIEW_TYPE_NORMAL = 1;
    private ArrayList<YoutubeVideo> mYoutubeVideos;
    DisplayMetrics displayMetrics = new DisplayMetrics();
    MainActivity activity;
    public YoutubeRecyclerAdapter(ArrayList<YoutubeVideo> youtubeVideos, MainActivity mainActivity) {
        mYoutubeVideos = youtubeVideos;
        activity=mainActivity;
    }
    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_youtube_list, parent, false));
    }
    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);

    }
    @Override
    public int getItemViewType(int position) {
        return VIEW_TYPE_NORMAL;
    }
    @Override
    public int getItemCount() {
        if (mYoutubeVideos != null && mYoutubeVideos.size() > 0) {
            return mYoutubeVideos.size();
        } else {
            return 1;
        }
    }
    public void setItems(ArrayList<YoutubeVideo> youtubeVideos) {
        mYoutubeVideos = youtubeVideos;
        notifyDataSetChanged();
    }
    public class ViewHolder extends BaseViewHolder {
        @BindView(R.id.textViewTitle)
        TextView textWaveTitle;
        @BindView(R.id.btnPlay)
        ImageView playButton;
        @BindView(R.id.imageViewItem)
        ImageView imageViewItems;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
        @OnClick(R.id.imageViewItem)
        public void playVideo() {

           // Log.d("url",mYoutubeVideos.get(super.getCurrentPosition()).getVideoId());

            ((MainActivity) activity).getPlayer().setSource(mYoutubeVideos.get(super.getCurrentPosition()).getVideoId());
        }
        protected void clear() {
        }
        public void onBind(int position) {
            super.onBind(position);
            final YoutubeVideo mYoutubeVideo = mYoutubeVideos.get(position);
            ((Activity) itemView.getContext()).getWindowManager()
                    .getDefaultDisplay()
                    .getMetrics(displayMetrics);
            int width = displayMetrics.widthPixels;
            if (mYoutubeVideo.getTitle() != null) {
                textWaveTitle.setText(mYoutubeVideo.getTitle());
            }
Log.d("url",mYoutubeVideo.getVideoId());
                Glide.with(itemView.getContext())
                        .load(mYoutubeVideo.getVideoId()).
                        apply(new RequestOptions().override(width - 36, 200))
                        .into(imageViewItems);

            imageViewItems.setVisibility(View.VISIBLE);

        }
    }
}
