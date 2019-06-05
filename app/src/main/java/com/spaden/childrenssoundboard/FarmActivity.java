package com.spaden.childrenssoundboard;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;

public class FarmActivity extends AppCompatActivity implements View.OnClickListener {

    SoundPool sp;
    int idFXCat = -1;
    int idFXPig = -1;
    int idFXDogge = -1;
    int idFXSheep = -1;
    int idFXChicken = -1;
    int idFXCow = -1;

    int nowPlaying = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.farm);

        ImageView buttonCat = (ImageView) findViewById(R.id.btnCat);
        buttonCat.setClickable(true);
        buttonCat.setOnClickListener(this);

        ImageView buttonCow = (ImageView) findViewById(R.id.btnCow);
        buttonCow.setClickable(true);
        buttonCow.setOnClickListener(this);

        ImageView buttonDogge = (ImageView) findViewById(R.id.btnDogge);
        buttonDogge.setClickable(true);
        buttonDogge.setOnClickListener(this);

        ImageView buttonPig = (ImageView) findViewById(R.id.btnPig);
        buttonPig.setClickable(true);
        buttonPig.setOnClickListener(this);

        ImageView buttonSheep = (ImageView) findViewById(R.id.btnSheep);
        buttonSheep.setClickable(true);
        buttonSheep.setOnClickListener(this);

        ImageView buttonChicken = (ImageView) findViewById(R.id.btnChicken);
        buttonChicken.setClickable(true);
        buttonChicken.setOnClickListener(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes =
                    new AudioAttributes.Builder()
                            .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)

                            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                            .build();

            sp = new SoundPool.Builder()
                    .setMaxStreams(5)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        }

        try {
            AssetManager assetManager = this.getAssets();
            AssetFileDescriptor descriptor;


            descriptor = assetManager.openFd("cat.mp3");
            idFXCat = sp.load(descriptor, 0);

            descriptor = assetManager.openFd("cow.mp3");
            idFXCow = sp.load(descriptor, 0);

            descriptor = assetManager.openFd("dogge.mp3");
            idFXDogge = sp.load(descriptor, 0);

            descriptor = assetManager.openFd("chicken.mp3");
            idFXChicken = sp.load(descriptor, 0);

            descriptor = assetManager.openFd("pig.mp3");
            idFXPig = sp.load(descriptor, 0);

            descriptor = assetManager.openFd("sheep.mp3");
            idFXSheep = sp.load(descriptor, 0);


        } catch (IOException e) {
            Log.e("error", "failed to load sound files " + e.getLocalizedMessage());

        }


    }

    @Override
    public void onClick(View v) {

        //  Intent i = new Intent("");
        //  startActivity(i);

        switch (v.getId()) {
            case R.id.btnCat:
                Log.i("info", "CLICKED CAT");
                sp.stop(nowPlaying);
                nowPlaying = sp.play(idFXCat, 1, 1, 0, 0, 1);
                break;
            case R.id.btnChicken:
                sp.stop(nowPlaying);
                nowPlaying = sp.play(idFXChicken, 1, 1, 0, 0, 1);
                break;
            case R.id.btnCow:
                sp.stop(nowPlaying);
                nowPlaying = sp.play(idFXCow, 1, 1, 0, 0, 1);
                break;
            case R.id.btnDogge:
                sp.stop(nowPlaying);
                nowPlaying = sp.play(idFXDogge, 1, 1, 0, 0, 1);
                break;
            case R.id.btnPig:
                sp.stop(nowPlaying);
                nowPlaying = sp.play(idFXPig, 1, 1, 0, 0, 1);
                break;
            case R.id.btnSheep:
                sp.stop(nowPlaying);
                nowPlaying = sp.play(idFXSheep, 1, 1, 0, 0, 1);
                break;
        }
    }
}
