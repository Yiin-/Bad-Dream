package com.baddream.managers;

import com.baddream.gameobjects.Bullet;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;

/**
 * Created by Yiin on 2015.09.09.
 */
public class BulletsManager {
    // Array kuriame laikomos aktyvios kulkos
    private final Array<Bullet> activeBullets = new Array<Bullet>();
    // bullet pool
    private final Pool<Bullet> bulletPool = Pools.get(Bullet.class);

    public BulletsManager() {
    }

    public void create(Vector2 source, Vector2 direction, float speed) {
        Bullet bullet = bulletPool.obtain();

        bullet.init(source.x, source.y, direction, speed);

        activeBullets.add(bullet);
    }

    public void remove(Bullet bullet) {
        activeBullets.removeValue(bullet, true);
        bulletPool.free(bullet);
    }

    public void update(float delta) {
        for (Bullet activeBullet : activeBullets) {
            activeBullet.update(delta);
        }

        Bullet bullet;
        int size = activeBullets.size;

        for (int i = size; --i >= 0;) {
            bullet = activeBullets.get(i);

            if ( ! bullet.isAlive()) {
                activeBullets.removeIndex(i);
                bulletPool.free(bullet);
            }
        }
    }

    public Array<Bullet> getBullets() {
        return activeBullets;
    }
}
