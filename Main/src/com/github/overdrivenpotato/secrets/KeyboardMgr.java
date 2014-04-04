package com.github.overdrivenpotato.secrets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class KeyboardMgr {
    private static int[] movementKeys;

    static
    {
        movementKeys = new int[4];
        movementKeys[0] = Input.Keys.LEFT;
        movementKeys[1] = Input.Keys.RIGHT;
        movementKeys[2] = Input.Keys.UP;
        movementKeys[3] = Input.Keys.DOWN;
    }

    public static boolean keyLeft()
    {
        return Gdx.input.isKeyPressed(movementKeys[0]);
    }

    public static boolean keyRight()
    {
        return Gdx.input.isKeyPressed(movementKeys[1]);
    }

    public static boolean keyUp()
    {
        return Gdx.input.isKeyPressed(movementKeys[2]);
    }

    public static boolean keyDown()
    {
        return Gdx.input.isKeyPressed(movementKeys[3]);
    }

    public static Vector2 getDirectionVec()
    {
        Vector2 vec = new Vector2();
        vec.x += KeyboardMgr.keyRight() ? 1 : 0;
        vec.x -= KeyboardMgr.keyLeft() ? 1 : 0;
        vec.y += KeyboardMgr.keyUp() ? 1 : 0;
        vec.y -= KeyboardMgr.keyDown() ? 1 : 0;
        vec.nor();
        return vec;
    }
}
