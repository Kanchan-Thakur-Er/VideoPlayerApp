package com.thakur.youtubeclone;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.thakur.youtubeclone.model.YoutubeVideo;

import java.util.ArrayList;

public class VideoListViewModel extends ViewModel {

    private MutableLiveData<ArrayList<YoutubeVideo>> videoLists;

    public VideoListViewModel() {

    }


    public LiveData<ArrayList<YoutubeVideo>> images() {

        if (videoLists == null) {
            videoLists = new MutableLiveData<ArrayList<YoutubeVideo>>();

            getVideos();
        }


        return videoLists;
    }

    private void getVideos() {
        ArrayList<YoutubeVideo> videoArrayList = new ArrayList<>();
        YoutubeVideo video1 = new YoutubeVideo();
        video1.setTitle(
                "Video Sample 1");
        video1.setVideoId("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4");
        YoutubeVideo video2 = new YoutubeVideo();
        video2.setTitle("Video Sample 2");
        video2.setVideoId("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4");
        YoutubeVideo video3 = new YoutubeVideo();
        video3.setTitle("Video Sample 3");
        video3.setVideoId("http://techslides.com/demos/sample-videos/small.mp4");
        YoutubeVideo video4 = new YoutubeVideo();
        video4.setTitle("Video Sample 4");
        video4.setVideoId("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4");
        YoutubeVideo video5 = new YoutubeVideo();
        video5.setTitle("Video Sample 5");
        video5.setVideoId("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4");
        videoArrayList.add(video1);
        videoArrayList.add(video2);
        videoArrayList.add(video3);
        videoArrayList.add(video4);
        videoArrayList.add(video5);

        videoLists.setValue(videoArrayList);

    }
}