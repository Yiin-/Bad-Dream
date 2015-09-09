package com.baddream.gameobjects;

import com.baddream.managers.BulletsManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Yiin on 2015.09.09.
 */
public class Enemy {
    private BulletsManager bulletsManager;

    private Vector2 position;

    public Enemy(float x, float y) {
        Gdx.app.log("Enemy", "created");

        bulletsManager = new BulletsManager();

        position = new Vector2(x, y);
    }

    public void update(float delta) {
        bulletsManager.update(delta);
    }

    public BulletsManager getBulletsManager() {
        return bulletsManager;
    }

    public Vector2 getPosition() {
        return position;
    }
}
