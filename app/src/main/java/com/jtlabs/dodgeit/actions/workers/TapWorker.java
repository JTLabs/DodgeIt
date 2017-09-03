package com.jtlabs.dodgeit.actions.workers;

import android.view.View;

import com.jtlabs.dodgeit.actions.events.EventAction;

/**
 * Created by jssingla on 9/3/17.
 *
 * Attaches the defined action to the tap listener and attaches the tap listener to the view.
 */
public class TapWorker implements GestureWorker {
    /**
     * Attaches the single click listener to the view. Assigns the defined action to be taken
     * on single tap.
     * @param v : View on which tap listener is to be attached.
     * @param event : Event which has to be triggered when attached listener listens.
     */
    @Override
    public void workOn(View v, final EventAction event) {
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                event.work();
            }
        });
    }
}
