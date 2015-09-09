package com.baddream.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Yiin on 2015.09.09.
 */
public class Bullet {
    private Vector2 position;
    private Vector2 direction;
    private float speed;

    public Bullet(Vector2 source, Vector2 direction, float speed) {
        Gdx.app.log("Bullet", "created");
        this.position = source;
        this.direction = direction;
        this.speed = speed;
    }

    public float getSpeed() {
        return speed;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getDirection() {
        return direction;
    }
}
