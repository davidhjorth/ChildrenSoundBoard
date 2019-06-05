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

public class JungleActivity extends AppCompatActivity implements View.OnClickListener {

    SoundPool sp;
    int idFXBear = -1;
    int idFXSnake = -1;
    int idFXCheetah = -1;
    int idFXElephant = -1;
    int idFXTiger = -1;
    int idFXJef = -1;

    int nowPlaying = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jungle);


        ImageView buttonBear = (ImageView) findViewById(R.id.btnBear);
        buttonBear.setClickable(true);
        buttonBear.setOnClickListener(this);


        ImageView buttonCheetah = (ImageView) findViewById(R.id.btnCheetah);
        buttonCheetah.setClickable(true);
        buttonCheetah.setOnClickListener(this);

        ImageView buttonJef = (ImageView) findViewById(R.id.btnJef);
        buttonJef.setClickable(true);
        buttonJef.setOnClickListener(this);

        ImageView buttonSnake = (ImageView) findViewById(R.id.btnSnake);
        buttonSnake.setClickable(true);
        buttonSnake.setOnClickListener(this);

        ImageView buttonElephant = (ImageView) findViewById(R.id.btnElephant);
        buttonElephant.setClickable(true);
        buttonElephant.setOnClickListener(this);

        ImageView buttonTiger = (ImageView) findViewById(R.id.btnTiger);
        buttonTiger.setClickable(true);
        buttonTiger.setOnClickListener(this);

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

            descriptor = assetManager.openFd("bear.mp3");
            idFXBear = sp.load(descriptor, 0);

            descriptor = assetManager.openFd("jef.mp3");
            idFXJef = sp.load(descriptor, 0);

            descriptor = assetManager.openFd("cheetah.mp3");
            idFXCheetah = sp.load(descriptor, 0);

            descriptor = assetManager.openFd("tiger.mp3");
            idFXTiger = sp.load(descriptor, 0);

            descriptor = assetManager.openFd("snake.mp3");
            idFXSnake = sp.load(descriptor, 0);

            descriptor = assetManager.openFd("elephant.mp3");
            idFXElephant = sp.load(descriptor, 0);

        } catch (IOException e) {
            Log.e("error", "failed to load sound files " + e.getLocalizedMessage());

        }

    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.btnBear:
                Log.i("info", "CLICKED BEAR");
                sp.stop(nowPlaying);
                nowPlaying = sp.play(idFXBear, 1, 1, 0, 0, 1);
                break;
            case R.id.btnJef:
                sp.stop(nowPlaying);
                nowPlaying = sp.play(idFXJef, 1, 1, 0, 0, 1);
                break;
            case R.id.btnCheetah:
                sp.stop(nowPlaying);
                nowPlaying = sp.play(idFXCheetah, 1, 1, 0, 0, 1);
                break;
            case R.id.btnElephant:
                sp.stop(nowPlaying);
                nowPlaying = sp.play(idFXElephant, 1, 1, 0, 0, 1);
                break;
            case R.id.btnTiger:
                sp.stop(nowPlaying);
                nowPlaying = sp.play(idFXTiger, 1, 1, 0, 0, 1);
                break;
            case R.id.btnSnake:
                sp.stop(nowPlaying);
                nowPlaying = sp.play(idFXSnake, 1, 1, 0, 0, 1);
                break;

        }


    }
}
