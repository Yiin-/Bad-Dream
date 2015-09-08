package com.baddream.gameworld;

import com.baddream.gameobjects.MainActor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Yiin on 2015.09.08.
 */
public class GameWorld {
    private MainActor mainActor;

    public GameWorld() {
        Gdx.app.log("GameWorld", "created");

        mainActor = new MainActor(0, 0, 6, 6);
    }

    public void update(float delta) {
        Gdx.app.log("GameWorld", "update");
        mainActor.update(delta);
    }

    public MainActor getMainActor() {
        return mainActor;
    }
}
