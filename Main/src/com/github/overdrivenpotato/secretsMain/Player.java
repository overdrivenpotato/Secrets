package com.github.overdrivenpotato.secretsMain;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player{
    private Animation anim;
    private SpriteBatch batch;
    private float stateTime;
    private float x, y;

    public Player(Texture anim, int width, int height)
    {
        stateTime = 0;

        TextureRegion[][] regions = new TextureRegion(anim).split(width, height);
        TextureRegion[] textures = new TextureRegion[regions.length * regions[0].length];
//        System.out.println(textures.length);
        int i = 0;
        for(TextureRegion[] l1 : regions)
        {
            for(TextureRegion l2 : l1)
            {
                textures[i++] = l2;
            }
        }
        this.anim = new Animation(0.5f, textures);
        this.batch = new SpriteBatch();
    }

    public void draw()
    {
        stateTime += Gdx.graphics.getDeltaTime();
        batch.begin();
        batch.draw(anim.getKeyFrame(stateTime, true), x, y);
        batch.end();
    }

    public void moveLeft(int i) {
        this.setX(getX() + i);
    }

    public void move(double x, double y)
    {
        move(x, y, 1);
    }

    public void move(double x, double y, double distance) {
        x *= distance;
        y *= distance;
        this.setX((float) (getX() + x));
        this.setY((float) (getY() + y));
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }
}