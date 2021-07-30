package com.example.bongolingo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mCategoryColor;

    public WordAdapter(@NonNull Context context, ArrayList<Word> words, int categoryColor) {
        super(context, 0, words);
        mCategoryColor = categoryColor;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_list_item, parent, false);
        }
        Word word = getItem(position);

        ImageView wordIconImageView = listItemView.findViewById(R.id.word_icon);
        if(word.hasImage()) {
            wordIconImageView.setVisibility(View.VISIBLE);
            wordIconImageView.setImageResource(word.getImageResourceId());
        }else{
            wordIconImageView.setVisibility(View.GONE);
        }

        RelativeLayout wordTextArea = listItemView.findViewById(R.id.wordTextArea);
        wordTextArea.setBackgroundColor(ContextCompat.getColor(getContext(), mCategoryColor));

        TextView bengaliTextView = listItemView.findViewById(R.id.bengali_text_view);
        bengaliTextView.setText(word.getBengaliTranslation());

        TextView englishTextView = listItemView.findViewById(R.id.english_text_view);
        englishTextView.setText(word.getDefaultTranslation());

        return listItemView;
    }
}
