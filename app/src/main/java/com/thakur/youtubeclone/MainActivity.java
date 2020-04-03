package com.thakur.youtubeclone;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.thakur.youtubeclone.adapter.YoutubeRecyclerAdapter;
import com.thakur.youtubeclone.model.YoutubeVideo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recyclerViewFeed)
    RecyclerView recyclerViewFeed;
    @BindView(R.id.andExoPlayerView)
 public  AndExoPlayerView andExoPlayerView;

    YoutubeRecyclerAdapter mRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        VideoListViewModel imageViewModel = ViewModelProviders.of(this).get(VideoListViewModel.class);
        imageViewModel.images().observe(this, new Observer<ArrayList<YoutubeVideo>>() {
            @Override
            public void onChanged(@Nullable ArrayList<YoutubeVideo> videoArrayList) {
                mRecyclerAdapter = new YoutubeRecyclerAdapter(videoArrayList,MainActivity.this);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerViewFeed.setLayoutManager(mLayoutManager);
                recyclerViewFeed.setItemAnimator(new DefaultItemAnimator());
                recyclerViewFeed.setAdapter(mRecyclerAdapter);
            }
        });

    }


    public AndExoPlayerView getPlayer(){

        return andExoPlayerView;
    }
}