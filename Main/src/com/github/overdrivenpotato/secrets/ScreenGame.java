package com.github.overdrivenpotato.secrets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by marko on 03/04/14.
 */
public class ScreenGame implements Screen {
    private World world;

    public ScreenGame()
    {
        try
        {
            world  = new World();
        } catch(Exception e)
        {
            e.printStackTrace();
            Gdx.app.exit();
        }
    }

    @Override
    public void render(float delta) {
        clearScreen();
        world.draw(delta);
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void resize(int width, int height) {

    }

    private void clearScreen()
    {
        Gdx.graphics.getGL20().glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.graphics.getGL20().glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
    }

    @Override
    public void update(float delta) {
        world.update(delta);
    }
}
