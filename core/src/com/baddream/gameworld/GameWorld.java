package com.baddream.gameworld;

import com.baddream.gameobjects.Bullet;
import com.baddream.gameobjects.MainActor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Yiin on 2015.09.08.
 */
public class GameWorld {
    private MainActor mainActor;
    private Array<Bullet> bullets;

    public GameWorld() {
        Gdx.app.log("GameWorld", "created");

        mainActor = new MainActor(0, 0, 6, 6);
        bullets = new Array<Bullet>();
    }

    public void createBullet(Vector2 source, Vector2 direction, float speed) {
        bullets.add(new Bullet(source, direction, speed));
    }

    public void update(float delta) {
        Gdx.app.log("GameWorld", "update");

        mainActor.update(delta);

        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            createBullet(mainActor.getPosition().cpy(), new Vector2(0, -1), 15f);
        }

        for (Bullet bullet : bullets) {
            bullet.update();
            if(Gdx.graphics.getWidth() < bullet.getPosition().x || bullet.getPosition().x < 0
                    || Gdx.graphics.getHeight() < bullet.getPosition().y || bullet.getPosition().y < 0) {
                bullets.removeValue(bullet, true);
            }
        }
    }

    public MainActor getMainActor() {
        return mainActor;
    }
    public Array<Bullet> getBullets() { return bullets; }
}
