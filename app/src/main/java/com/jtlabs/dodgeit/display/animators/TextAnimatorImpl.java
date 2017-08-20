package com.jtlabs.dodgeit.display.animators;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

/**
 * Created by jssingla on 8/20/17.
 */
public class TextAnimatorImpl implements TextAnimator {
    private long defaultFadeInMillis = 2000;
    private long defaultFadeOutMillis = 2000;

    /**
     * does the complete fade in (1 -> 0) and fade out (0 -> 1), 1 being completely opaque and 0
     * being completely transparent animation on the provided text view.
     *
     * @param textView      textView on which animation is to be performed.
     * @param fadeInMillis  milliseconds for which the fading in is to be done.
     * @param fadeOutMillis milliseconds for which the fading out is to be done.
     */
    @Override
    public void fadeInFadeOut(TextView textView, long fadeInMillis, long fadeOutMillis) {
        /* create animation for 1->0 fade and 0->1 fade */
        Animation fadeInAnimation = new AlphaAnimation(1f, 0f);
        Animation fadeOutAnimation = new AlphaAnimation(0f, 1f);

        /* set the required durations for fading */
        fadeInAnimation.setDuration(fadeInMillis);
        fadeOutAnimation.setDuration(fadeOutMillis);

        /* set the listeners to start next animation after one completes */
        fadeInAnimation.setAnimationListener(createAnimationListener(textView, fadeOutAnimation));
        fadeOutAnimation.setAnimationListener(createAnimationListener(textView, fadeInAnimation));

        /* start the fade in animation */
        textView.startAnimation(fadeInAnimation);
    }

    private Animation.AnimationListener createAnimationListener(final TextView textView, final
                                                                Animation
                                                                        nextAnimationToStart) {
        return new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                /* Nothing special to be done */
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                /* start the nextAnimationToStart as this animation completes */
                textView.startAnimation(nextAnimationToStart);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                /* Nothing special to be done */
            }
        };
    }

    /**
     * does the complete fade in (1 -> 0) and fade out (0 -> 1), 1 being completely opaque and 0
     * being completely transparent animation on the provided text view, the transitions times
     * between the fades are default values as {@link TextAnimatorImpl#defaultFadeInMillis},
     * {@link TextAnimatorImpl#defaultFadeOutMillis}.
     *
     * @param textView      textView on which animation is to be performed.
     */
    public void fadeInFadeOut(TextView textView) {
        /* Perform animation with the default values */
        fadeInFadeOut(textView, defaultFadeInMillis, defaultFadeOutMillis);
    }
}
