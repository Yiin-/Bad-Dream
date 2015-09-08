package com.baddream.gameobjects;

import com.baddream.helpers.AssetLoader;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Yiin on 2015.09.08.
 */
public class MainActor {
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;

    private int width;
    private int height;

    public MainActor(float x, float y, int width, int height) {
        this.width = width;
        this.height = height;
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, 460);
    }

    public void update(float delta) {

        position = new Vector2(Gdx.input.getX(), Gdx.input.getY());
    }

    public void onClick() {
        shoot();
    }

    private void shoot() {
        AssetLoader.createExplosionFX(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
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
