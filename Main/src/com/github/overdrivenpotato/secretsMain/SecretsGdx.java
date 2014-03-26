package com.github.overdrivenpotato.secretsMain;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.github.overdrivenpotato.secrets.underthehood.KeyboardMgr;

public class SecretsGdx extends Game {
    private Player tempPlayer;
    private KeyboardMgr keyboardMgr;
//    private TileMap map;

    @Override
    public void create() {
//        map = new TmxMapLoader().load("Main/assets/map1.tmx");
        tempPlayer = new Player(new Texture("Main/assets/player.png"), 16 ,16);
        tempPlayer.setPosition(100, 100);
        keyboardMgr = new KeyboardMgr();
    }

    @Override
    public void render() {
        Gdx.graphics.getGL20().glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.graphics.getGL20().glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );

        super.render();

        tempPlayer.draw();
        Vector2 vec = new Vector2();
        vec.x += keyboardMgr.keyRight() ? 1 : 0;
        vec.x -= keyboardMgr.keyLeft() ? 1 : 0;
        vec.y += keyboardMgr.keyUp() ? 1 : 0;
        vec.y -= keyboardMgr.keyDown() ? 1 : 0;
        vec.nor();

        tempPlayer.move(vec.x, vec.y, 3);
    }
}
