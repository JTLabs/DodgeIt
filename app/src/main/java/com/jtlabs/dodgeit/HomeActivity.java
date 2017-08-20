package com.jtlabs.dodgeit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.jtlabs.dodgeit.display.animators.TextAnimator;
import com.jtlabs.dodgeit.display.animators.TextAnimatorImpl;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Send away the status bar */
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /* set the content view */
        setContentView(R.layout.activity_home);

        /* start animation on text, this has to be after setting the content view. */
        TextView tapToStartTextView = (TextView) findViewById(R.id.tap_to_start_text);
        startAnimation(tapToStartTextView);
    }

    private void startAnimation(TextView tapToStartTextView) {
        TextAnimator textAnimator = new TextAnimatorImpl();
        textAnimator.fadeInFadeOut(tapToStartTextView);
    }
}
