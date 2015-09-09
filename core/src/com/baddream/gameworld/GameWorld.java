package com.baddream.gameworld;

import com.baddream.gameobjects.Enemy;
import com.baddream.gameobjects.MainActor;
import com.badlogic.gdx.Gdx;

/**
 * Created by Yiin on 2015.09.08.
 */
public class GameWorld {
    private MainActor mainActor;
    private Enemy enemy;

    public GameWorld() {
        Gdx.app.log("GameWorld", "created");

        mainActor = new MainActor(0, 0);
        enemy = new Enemy(300, 200);
    }

    public void update(float delta) {
        Gdx.app.log("GameWorld", "update");

        mainActor.update(delta);
        enemy.update(delta);
    }

    public MainActor getMainActor() {
        return mainActor;
    }

    public Enemy getEnemy() {
        return enemy;
    }
}
