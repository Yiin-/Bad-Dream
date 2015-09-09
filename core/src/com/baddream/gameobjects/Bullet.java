package com.baddream.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool;

/**
 * Created by Yiin on 2015.09.09.
 */
public class Bullet implements Pool.Poolable {
    private Vector2 position;
    private Vector2 direction;
    private float speed;
    private boolean alive;

    public Bullet() {
        Gdx.app.log("Bullet", "created");
        alive = false;
        this.position = new Vector2();
    }

    public void init(float x, float y, Vector2 direction, float speed) {
        this.position.set(x, y);
        this.direction = direction;
        this.speed = speed;

        alive = true;
    }

    public void update(float delta) {
       this.position.add(delta * 60 * speed * direction.x, delta * 60 * speed * direction.y);//this.direction.cpy().scl(this.speed));

        if(isOutOfScreen()) {
            alive = false;
        }
    }

    public boolean isAlive() {
        return alive;
    }

    public Vector2 getPosition() {
        return position;
    }

    private boolean isOutOfScreen() {
        return Gdx.graphics.getWidth() < position.x
                || Gdx.graphics.getHeight() < position.y
                || position.x < 0
                || position.y < 0;
    }

    @Override
    public void reset() {
        position.set(0, 0);
        alive = false;
    }
}
