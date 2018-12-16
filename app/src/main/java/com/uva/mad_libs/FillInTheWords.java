package com.uva.mad_libs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        // set initial textview based on number of placeholders
        TextView txt = findViewById(R.id.textView8);
        txt.setText(story.getPlaceholderCount() + " word(s) remaining");

        // initialize progress bar max based on number of placeholders
        ProgressBar progress = findViewById(R.id.progressBar3);
        progress.setMax(story.getPlaceholderCount());
    }

    public void WhenClicked(View view){
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


        // update what to enter notification
        TextView noti = findViewById(R.id.textView9);
        noti.setText("please type a/an " + story.getNextPlaceholder());

        // if all placeholders are filled in > go to the final story view
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
