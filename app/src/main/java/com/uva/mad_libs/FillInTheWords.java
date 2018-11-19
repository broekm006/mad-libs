package com.uva.mad_libs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class FillInTheWords extends MainActivity {
    Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fill_in_the_words);
        Intent intent = getIntent();
        story = (Story) intent.getSerializableExtra("story");

        // update text field
        TextView txt = findViewById(R.id.textView8);
        txt.setText(story.getPlaceholderCount() + " word(s) remaining");

        ProgressBar progress = findViewById(R.id.progressBar3);
        progress.setMax(story.getPlaceholderCount());
    }

    public void WhenClicked(View view){
        Button btn = findViewById(R.id.button5);

        // Update Remaining Words counter
        TextView txt = findViewById(R.id.textView8);
        txt.setText(story.getPlaceholderRemainingCount() + " word(s) remaining");

        // update progress bar
        ProgressBar progress = findViewById(R.id.progressBar3);
        progress.setProgress(story.Progress());

        // get hint view
        TextView hint = findViewById(R.id.editText2);

        // get text field to story
        story.fillInPlaceholder(hint.getText().toString());

        // update text & hint field
        hint.setText("");
        hint.setHint(story.getNextPlaceholder());

        if (story.isFilledIn()) {
            Intent intent = new Intent(FillInTheWords.this, FinalStory.class);
            intent.putExtra("story", story);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(FillInTheWords.this, Choose.class));
    }

}
