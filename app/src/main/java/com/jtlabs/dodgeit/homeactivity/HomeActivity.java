package com.jtlabs.dodgeit.homeactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jtlabs.dodgeit.R;
import com.jtlabs.dodgeit.actions.events.EventAction;
import com.jtlabs.dodgeit.actions.events.GameStartEventAction;
import com.jtlabs.dodgeit.actions.workers.GestureWorker;
import com.jtlabs.dodgeit.actions.workers.SingleTapWorker;
import com.jtlabs.dodgeit.display.animators.TextAnimator;
import com.jtlabs.dodgeit.display.animators.TextAnimatorImpl;
import com.jtlabs.dodgeit.gameactivity.containers.GameActivityStartRequest;

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
        LinearLayout homeScreenView = (LinearLayout) findViewById(R.id.home_screen_content_controls);
        startAnimation(tapToStartTextView);
        setOnClickListener(homeScreenView);
    }

    private void setOnClickListener(View tapToStartTextView) {
        GestureWorker gestureWorker = new SingleTapWorker();
        gestureWorker.workOn(tapToStartTextView, GameStartEventAction.builder().context(this)
                .gameActivityStartRequest(GameActivityStartRequest.builder().id("game").build())
                .build());
    }

    private void startAnimation(TextView tapToStartTextView) {
        TextAnimator textAnimator = new TextAnimatorImpl();
        textAnimator.fadeInFadeOut(tapToStartTextView);
    }
}
