package com.github.overdrivenpotato.secrets.underthehood;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class KeyboardMgr {
    private int[] movementKeys;

    public KeyboardMgr()
    {
        movementKeys = new int[4];
        movementKeys[0] = Input.Keys.LEFT;
        movementKeys[1] = Input.Keys.RIGHT;
        movementKeys[2] = Input.Keys.UP;
        movementKeys[3] = Input.Keys.DOWN;
    }

    public boolean keyLeft()
    {
        return Gdx.input.isKeyPressed(movementKeys[0]);
    }

    public boolean keyRight()
    {
        return Gdx.input.isKeyPressed(movementKeys[1]);
    }

    public boolean keyUp()
    {
        return Gdx.input.isKeyPressed(movementKeys[2]);
    }

    public boolean keyDown()
    {
        return Gdx.input.isKeyPressed(movementKeys[3]);
    }
}
