package com.jtlabs.dodgeit.actions.events;

import android.content.Context;
import android.content.Intent;

import com.google.gson.Gson;
import com.jtlabs.dodgeit.gameactivity.GameActivity;
import com.jtlabs.dodgeit.gameactivity.containers.GameActivityStartRequest;

import lombok.Builder;
import lombok.NonNull;

/**
 * Created by jssingla on 9/3/17.
 *
 * Starts the game activity with required game type as defined in {@link GameActivityStartRequest}
 */
@Builder
public class GameStartEventAction implements EventAction {
    /**
     * Context of the activity from which the new intent is to be fired. This is required by
     * {@link Context#startActivity} method call
     */
    @NonNull
    Context context;
    /**
     * Input object required before staring the game activity, It will be passed to the intent
     * before starting the activity so that game activity can be configured as per request object.
     */
    @NonNull
    GameActivityStartRequest gameActivityStartRequest;

    /**
     * starts the game activity with required request.
     */
    @Override
    public void work() {
        Intent intent = new Intent(context, GameActivity.class);
        intent.putExtra("request", convertRequestToString(gameActivityStartRequest));
        context.startActivity(intent);
    }

    private String convertRequestToString(GameActivityStartRequest gameActivityStartRequest) {
        return new Gson().toJson(gameActivityStartRequest);
    }
}
