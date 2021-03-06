package com.baddream.gameworld;

import com.baddream.gameobjects.Bullet;
import com.baddream.gameobjects.Enemy;
import com.baddream.helpers.AssetLoader;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Yiin on 2015.09.08.
 */
public class GameRenderer {

    private GameWorld gameWorld;

    private OrthographicCamera cam;

    private ShapeRenderer shapeRenderer;

    private SpriteBatch batch;

    public GameRenderer(GameWorld world) {
        gameWorld = world;

        cam = new OrthographicCamera();
        cam.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        batch = new SpriteBatch();

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);

        Pixmap cursorImage = new Pixmap(32, 32, Pixmap.Format.RGBA8888);
        System.out.println(cursorImage.getHeight());
        Gdx.input.setCursorImage(cursorImage, 0, 0);
    }

    public void resize() {
        cam.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        shapeRenderer.setProjectionMatrix(cam.combined);
    }

    public void render(float delta) {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        // Išjungiam permatomumą
        // Piešiam stuff kuris nenaudoja permatomo. For better performance.
        // batch.disableBlending();


        // Įjungiam permatomumą vėl, kad nupieštumėm visą kitą
        batch.enableBlending();

        // Paišom efektus
        AssetLoader.drawFX(batch, delta);

        // End SpriteBatch
        batch.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        // Kulkos
        shapeRenderer.setColor(0, 0, 1, 1);
        for(Bullet bullet : gameWorld.getMainActor().getBulletsManager().getBullets()) {
            shapeRenderer.circle(bullet.getPosition().x, bullet.getPosition().y, 3);
        }
        shapeRenderer.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        // Pagr veikėjas
        shapeRenderer.setColor(0, 0, 0, 1);
        shapeRenderer.circle(gameWorld.getMainActor().getX(), gameWorld.getMainActor().getY(), 9);

        Enemy enemy = gameWorld.getEnemy();

        if(enemy.isAlive()) {
            shapeRenderer.setColor(1, 0, 0, 1);
            shapeRenderer.circle(enemy.getPosition().x, enemy.getPosition().y, enemy.getWidth());
        }
        shapeRenderer.end();
    }
}
