package com.github.overdrivenpotato.secretsDesktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.github.overdrivenpotato.secrets.SecretsGdx;

/**
 * Created by Marko on 1/16/14.
 */
public class DesktopStarter {
    public static void main(String[] args) {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "Secrets Pre-Alpha!";
        cfg.useGL20 = true;
        cfg.width = 800;
        cfg.height = 480;
        cfg.resizable = false;
        new LwjglApplication(new SecretsGdx(), cfg);
    }
}