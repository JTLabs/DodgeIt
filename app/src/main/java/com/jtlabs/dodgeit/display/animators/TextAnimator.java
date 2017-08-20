package com.jtlabs.dodgeit.display.animators;

import android.widget.TextView;

/**
 * This interface provides contracts for doing animations on a textView.
 * Created by jssingla on 8/20/17.
 */
public interface TextAnimator {
    /**
     * does the complete fade in (1 -> 0) and fade out (0 -> 1), 1 being completely opaque and 0
     * being completely transparent animation on the provided text view.
     *
     * @param textView      textView on which animation is to be performed.
     * @param fadeInMillis  milliseconds for which the fading in is to be done.
     * @param fadeOutMillis milliseconds for which the fading out is to be done.
     */
    void fadeInFadeOut(TextView textView, long fadeInMillis, long fadeOutMillis);

    /**
     * does the complete fade in (1 -> 0) and fade out (0 -> 1), 1 being completely opaque and 0
     * being completely transparent animation on the provided text view, the transitions times
     * between the fades are default values as chosen in the implementation.
     *
     * @param textView      textView on which animation is to be performed.
     */
    void fadeInFadeOut(TextView textView);
}
