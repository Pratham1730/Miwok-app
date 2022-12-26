package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class wordAdapter extends ArrayAdapter<word> {

    private int mColorResourceId;

    public  wordAdapter(Activity context , ArrayList<word> words, int ColorResourceId)
    {
        super(context, 0, words);
        mColorResourceId = ColorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        word translationWord = getItem(position);

        TextView numberSpanishTextView = (TextView) listItemView.findViewById(R.id.SpanishNumbers);
        numberSpanishTextView.setText(translationWord.getMiwokTranslation());

        TextView numberDefaultTextView = (TextView)  listItemView.findViewById(R.id.EnglishNumbers);
        numberDefaultTextView.setText(translationWord.getDefaultTranslation());

        ImageView numberImageView = (ImageView) listItemView.findViewById(R.id.icon);

        if (translationWord.hasImage())
        {
            numberImageView.setImageResource(translationWord.getImagesResourceId());
            numberImageView.setVisibility(View.VISIBLE);
        }
        else
        {
            numberImageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.TextContainer);
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
