package com.uva.mad_libs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class FinalStory extends MainActivity {
    Story story;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_story);
        Intent intent = getIntent();
        story = (Story) intent.getSerializableExtra("story");

        TextView txt = findViewById(R.id.textView6);
        txt.setText(story.toString());
    }

    public void ResetStory(View view){
        story.clear();
        startActivity(new Intent(FinalStory.this, Choose.class));
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(FinalStory.this, Choose.class));
    }

}
