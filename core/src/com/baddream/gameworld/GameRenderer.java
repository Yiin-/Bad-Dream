package com.baddream.gameworld;

import com.baddream.helpers.AssetLoader;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
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
        cam.setToOrtho(true, Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 4);

        batch = new SpriteBatch();

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
    }

    public void render(float delta) {
        Gdx.app.log("GameRenderer", "render");

        /*
         * 1. We draw a white background. This prevents flickering.
         */

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        /*
         * 2. We draw the Filled rectangle
         */

        // Tells shapeRenderer to begin drawing filled shapes
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        shapeRenderer.setColor(1f, 1f, 1f, 1);

        // Tells the shapeRenderer to finish rendering
        // We MUST do this every time.
        shapeRenderer.end();

        // Begin SpriteBatch
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
    }
}
