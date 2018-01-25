package org.pindad.aftersalepindad;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import org.pindad.aftersalepindad.Adapter.VideoAdapter;
import org.pindad.aftersalepindad.Model.Video;

import java.util.ArrayList;
import java.util.List;

public class VideoActivity extends AppCompatActivity{
//    public static final String KEY = "AIzaSyCwYX_kzB2svjnKYE5sPTZHKmDVkYCGgh8";
//    YouTubePlayerView youTubePlayerView;
//    //http://youtu.be/<VIDEO_ID>
//    //sample video id
//    YouTubePlayer.OnInitializedListener onInitializedListener;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        /** attaching layout xml **/
//        setContentView(R.layout.activity_video);
//        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.video);
//        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
//            @Override
//            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
//                youTubePlayer.loadVideo("c_OgbEbYLas");
//            }
//
//            @Override
//            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
//
//            }
//        };
//        youTubePlayerView.initialize(KEY, onInitializedListener);
//    }

    private ListView mVideosListView;
    private List<Video> mVideosList = new ArrayList<>();
    private VideoAdapter mVideoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        //assign video
        mVideosListView = (ListView) findViewById(R.id.videoListView);

        //create videos
        Video video1 = new Video("http://api.pindad.com/as/files/video/video2.MP4");
        Video video2 = new Video("http://api.pindad.com/as/files/video/video2.MP4");
        Video video3 = new Video("http://api.pindad.com/as/files/video/video2.MP4");
        Video video4 = new Video("http://api.pindad.com/as/files/video/video2.MP4");

        mVideosList.add(video1);
        mVideosList.add(video2);
        mVideosList.add(video3);
        mVideosList.add(video4);

        /***populate video list to adapter**/
        mVideoAdapter = new VideoAdapter(this, mVideosList);
        mVideosListView.setAdapter(mVideoAdapter);

//        Uri uri=Uri.parse(path1);
//
//        VideoView video=(VideoView) rootView.findViewById(R.id.faqVideo);
//        video.setVideoURI(uri);
//        video.setMediaController(mc);
//        video.start();

    }
}
