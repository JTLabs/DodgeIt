package com.jtlabs.dodgeit.actions.workers;

import android.view.View;

import com.jtlabs.dodgeit.actions.events.EventAction;

/**
 * Created by jssingla on 9/3/17.
 * Contract to implement required gesture and trigger the event on the gesture.
 */
public interface GestureWorker {
    /**
     * Attaches the required gesture to the view and triggers the event on gesture detection.
     * @param v : View on which gesture has to be attached.
     * @param event : Event which has to be triggered on detection of gesture.
     */
    void workOn(View v, EventAction event);
}
