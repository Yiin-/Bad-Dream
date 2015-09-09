package com.baddream.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Yiin on 2015.09.08.
 */
public class MainActor {
    private Vector2 position;

    private int width;
    private int height;

    public MainActor(float x, float y, int width, int height) {
        this.width = width;
        this.height = height;
        position = new Vector2(x, y);
    }

    public void update(float delta) {
        Gdx.app.log("MainActor", "update");
        position.set(Gdx.input.getX(), Gdx.input.getY());
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

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
