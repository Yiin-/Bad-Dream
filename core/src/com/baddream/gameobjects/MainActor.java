package com.baddream.gameobjects;

import com.baddream.managers.BulletsManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Yiin on 2015.09.08.
 */
public class MainActor {
    private Vector2 position;

    private BulletsManager bulletsManager;

    public MainActor(float x, float y) {
        position = new Vector2(x, y);
        bulletsManager = new BulletsManager();
    }

    public void update(float delta) {
        position.set(Gdx.input.getX(), Gdx.input.getY());

        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            bulletsManager.create(position.cpy(), new Vector2(0, -1), 15f);
        }

        bulletsManager.update(delta);
    }

    public void onClick() {
        shoot();
    }

    private void shoot() {
        Gdx.app.log("MainActor", "shoot");
        //AssetLoader.createExplosionFX(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
    }

    public Vector2 getPosition() {
        return position;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public BulletsManager getBulletsManager() {
        return bulletsManager;
    }
}
