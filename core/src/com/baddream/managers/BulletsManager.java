package com.baddream.managers;

import com.baddream.gameobjects.Bullet;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Yiin on 2015.09.09.
 */
public class BulletsManager {
    private Array<Bullet> bullets;

    public BulletsManager() {
        bullets = new Array<Bullet>();
    }

    public void create(Vector2 source, Vector2 direction, float speed) {
        bullets.add(new Bullet(source, direction, speed));
    }

    public void update() {
        for (Bullet bullet : bullets) {
            move(bullet);

            if(Gdx.graphics.getWidth() < bullet.getPosition().x || bullet.getPosition().x < 0
                    || Gdx.graphics.getHeight() < bullet.getPosition().y || bullet.getPosition().y < 0) {
                bullets.removeValue(bullet, true);
            }
        }
    }

    public Array<Bullet> getBullets() {
        return bullets;
    }

    private void move(Bullet bullet) {
        bullet.getPosition().add(bullet.getDirection().cpy().scl(bullet.getSpeed()));
    }
}
