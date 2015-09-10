package com.baddream.gameobjects;

import com.baddream.helpers.AssetLoader;
import com.baddream.managers.BulletsManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Yiin on 2015.09.09.
 */
public class Enemy {
    private BulletsManager bulletsManager;

    private Circle col;

    private Vector2 position;
    private float width;

    private boolean alive;

    public Enemy(float x, float y, float width) {
        Gdx.app.log("Enemy", "created");

        bulletsManager = new BulletsManager();

        position = new Vector2(x, y);
        this.width = width;

        col = new Circle(x, y, width);

        alive = true;
    }

    public void update(float delta) {
        bulletsManager.update(delta);
    }

    public void hit(float amount) {
        width -= amount;
        col.setRadius(width);

        if(width <= 5f) {
            Gdx.app.log("Enemy", "dead");
            alive = false;
            AssetLoader.createExplosionFX(position.x, Gdx.graphics.getHeight() - position.y);
        }
    }

    public BulletsManager getBulletsManager() {
        return bulletsManager;
    }

    public Vector2 getPosition() {
        return position;
    }

    public float getWidth() {
        return width;
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean isColliding(Vector2 point) {
        return col.contains(point);
    }

    public boolean isColliding(Circle circle) {
        return col.overlaps(circle);
    }
}
