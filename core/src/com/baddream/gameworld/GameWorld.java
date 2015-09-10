package com.baddream.gameworld;

import com.baddream.gameobjects.Bullet;
import com.baddream.gameobjects.Enemy;
import com.baddream.gameobjects.MainActor;
import com.badlogic.gdx.Gdx;

/**
 * Created by Yiin on 2015.09.08.
 */
public class GameWorld {
    private MainActor mainActor;
    private Enemy enemy;

    public GameWorld() {
        Gdx.app.log("GameWorld", "created");

        mainActor = new MainActor(0, 0);
        enemy = new Enemy(300, 200, 50f);
    }

    public void update(float delta) {
        mainActor.update(delta);
        enemy.update(delta);

        for (Bullet b : mainActor.getBulletsManager().getBullets()) {
            if(enemy.isAlive()) {
                if (enemy.isColliding(b.getPosition())) {
                    enemy.hit(0.7f);
                    mainActor.getBulletsManager().remove(b);
                }
            }
        }
    }

    public MainActor getMainActor() {
        return mainActor;
    }

    public Enemy getEnemy() {
        return enemy;
    }
}
