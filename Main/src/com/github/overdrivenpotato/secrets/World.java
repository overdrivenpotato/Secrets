package com.github.overdrivenpotato.secrets;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by marko on 03/04/14.
 */
public class World {
    private Player tempPlayer;

    public World() throws Exception
    {
        tempPlayer = new Player();
        tempPlayer.setPosition(100, 100);
    }

    public void draw(float delta) {
        tempPlayer.draw(delta);
    }

    public void update(float delta) {
        tempPlayer.update(delta);
    }
}
