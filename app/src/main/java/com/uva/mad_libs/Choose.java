package com.uva.mad_libs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import java.io.InputStream;

public class Choose extends MainActivity{
    InputStream is;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_story);
    }

    // when buttn is clicked choose the matching story
    public void choose_story(View view) {
        switch (view.getId()) {
            case R.id.button_simple:
                is = getResources().openRawResource(R.raw.madlib0_simple);
                break;
            case R.id.button_tarzan:
                is = getResources().openRawResource(R.raw.madlib1_tarzan);
                break;
            case R.id.button_university:
                is = getResources().openRawResource(R.raw.madlib2_university);
                break;
            case R.id.button_clothes:
                is = getResources().openRawResource(R.raw.madlib3_clothes);
                break;
            case R.id.button_dance:
                is = getResources().openRawResource(R.raw.madlib4_dance);
                break;
        }

        Intent intent = new Intent(Choose.this, FillInTheWords.class);
        intent.putExtra("story", new Story(is));
        startActivity(intent);
    }
}
