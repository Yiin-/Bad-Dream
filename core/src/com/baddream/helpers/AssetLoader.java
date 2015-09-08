package com.baddream.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool.*;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Yiin on 2015.09.08.
 */
public class AssetLoader {

    public static ParticleEffectPool explosionEffectPool;
    public static Array<PooledEffect> effects;
    public static ParticleEffect explosionEffect;

    private static TextureAtlas explosionAtlas;

    public static void load() {
        explosionAtlas = new TextureAtlas(Gdx.files.local("/particles/explosion.pack"));
        explosionEffect = new ParticleEffect();
        explosionEffect.load(Gdx.files.internal("particles/explosion.p"), explosionAtlas);

        explosionEffectPool = new ParticleEffectPool(explosionEffect, 1, 2);

        effects = new Array();
    }

    public static void createExplosionFX(float x, float y) {
        PooledEffect effect = explosionEffectPool.obtain();
        effect.setPosition(x, y);
        effects.add(effect);
    }

    public static void drawFX(Batch batch, float delta) {
        // Update and draw effects:
        for (int i = effects.size - 1; i >= 0; i--) {
            PooledEffect effect = effects.get(i);
            effect.draw(batch, delta);
            if (effect.isComplete()) {
                effect.free();
                effects.removeIndex(i);
            }
        }
    }
}
