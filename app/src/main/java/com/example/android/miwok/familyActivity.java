package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class familyActivity extends AppCompatActivity {

    private final MediaPlayer.OnCompletionListener mCompletionListner = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<word> words = new ArrayList<>();
        words.add(new word("father", "әpә", R.drawable.family_father, R.raw.family_father));
        words.add(new word("mother", "әṭa", R.drawable.family_mother, R.raw.family_mother));
        words.add(new word("son", "angsi", R.drawable.family_son, R.raw.family_son));
        words.add(new word("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new word("older brother", "taachi", R.drawable.family_older_brother,
                R.raw.family_older_brother));
        words.add(new word("younger brother", "chalitti", R.drawable.family_younger_brother,
                R.raw.family_younger_brother));
        words.add(new word("older sister", "teṭe", R.drawable.family_older_sister,
                R.raw.family_older_sister));
        words.add(new word("younger sister", "kolliti", R.drawable.family_younger_sister,
                R.raw.family_younger_sister));
        words.add(new word("grandmother ", "ama", R.drawable.family_grandmother,
                R.raw.family_grandmother));
        words.add(new word("grandfather", "paapa", R.drawable.family_grandfather,
                R.raw.family_grandfather));

        wordAdapter colorAdapter =
                new wordAdapter(this,words,R.color.category_family);

        ListView familyList = (ListView) findViewById(R.id.list);
        familyList.setAdapter(colorAdapter);

        familyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                word audio = words.get(position);
                mediaPlayer = MediaPlayer.create(familyActivity.this,audio.GetAudioResource());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(mCompletionListner);

            }
        });
    }

    /*@Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.release();
    }*/

    private  void releaseMediaPlayer()
    {
        if(mediaPlayer != null)
        {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

}