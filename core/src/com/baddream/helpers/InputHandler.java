package com.baddream.helpers;

import com.baddream.gameobjects.MainActor;
import com.badlogic.gdx.InputProcessor;

/**
 * Created by Yiin on 2015.09.08.
 */
public class InputHandler implements InputProcessor {

    private MainActor mainActor;

    public InputHandler(MainActor actor) {
        mainActor = actor;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        mainActor.onClick();
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
