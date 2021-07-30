package com.example.bongolingo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            switch(focusChange){
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);
                    break;
                case AudioManager.AUDIOFOCUS_GAIN:
                    mediaPlayer.start();
                    break;
                case AudioManager.AUDIOFOCUS_LOSS:
                    releaseMediaPlayer();
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("Kemon achish?", "How are you?"));
        words.add(new Word("Bhalo achi.", "I am fine."));
        words.add(new Word("Tomar naam ki?", "What's your name?"));
        words.add(new Word("Amar naam ...", "My name is ..."));
        words.add(new Word("Kothaye jaccho?", "Where are you going?"));
        words.add(new Word("Hae, ami ashchhi?", "Yes, I am coming"));
        words.add(new Word("Na, ami jachhi na?", "No, I am not going"));
        words.add(new Word("Taratari koro!", "Hurry up!"));
        words.add(new Word("Amar khide peyeche.", "I'm hungry."));
        words.add(new Word("Ki kheyeccho?", "What did you eat?"));
        words.add(new Word("Ami tomake bhalobashi", "I love you"));


        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_phrases);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer(){
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
            audioManager.abandonAudioFocus(afChangeListener);
        }
    }
}