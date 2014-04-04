package com.github.overdrivenpotato.secrets;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class SecretsGdx extends Game {
    private ScreenGame screenGame;

    @Override
    public void create() {
        screenGame = new ScreenGame();
        setScreen(screenGame);
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();
        ((Screen)getScreen()).update(delta);
        getScreen().render(delta);
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
