package com.github.overdrivenpotato.secrets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Player{
    private Animation anim;
    private SpriteBatch batch;
    private float stateTime;
    private float x, y;

    public Player() throws Exception
    {
        stateTime = 0;
        this.batch = new SpriteBatch();
        loadSheet(new Texture("Main/assets/player.png"), 16, 16);
    }

    private enum Movemt
    {
        LEFT(2, 2, 0, 1),
        RIGHT(2, 2, 0, 2),
        UP(2, 2, 0, 3),
        DOWN(2, 2, 0, 0),
        ATKUP(1, 1, 3, 0, 16, 32),
        ATKDOWN(1, 1, 2, 0, 16, 32),
        ATKLEFT(1, 1, 2, 2, 32, 16),
        ATKRIGHT(1, 1, 2, 3, 32, 16);

        private final int length, boxWidth, x, y, width, height;

        Movemt(int length, int boxWidth, int x, int y, int width, int height)
        {
            this.length = length;
            this.boxWidth = boxWidth;
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        Movemt(int length, int boxWidth, int x, int y)
        {
            this(length, boxWidth, x, y, 16, 16);
        }

        public int getFrameX(int frame) throws Exception {
            if(frame < 0 || frame >= length)
            {
                throw new Exception("Frame is out of bounds");
            }

            return width * (frame % boxWidth + x);
        }

        public int getFrameY(int frame) throws Exception {
            if(frame < 0 || frame >= length)
            {
                throw new Exception("Frame is out of bounds");
            }

            return height * (frame / boxWidth + y);
        }
    }

    private void loadSheet(Texture sheet, int width, int height) throws Exception {
        TextureRegion[][] cut = new TextureRegion[Movemt.values().length][];

        for(Movemt movemt : Movemt.values())
        {
            cut[movemt.ordinal()] = new TextureRegion[movemt.length];
            for(int i = 0; i < movemt.length; i++)
            {
                try
                {
                    cut[movemt.ordinal()][i] = new TextureRegion(sheet, movemt.getFrameX(i), movemt.getFrameY(i), movemt.width, movemt.height);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                    throw new Exception("Error initializing character.");
                }
            }
        }
        int totalFrames = 0;
        for(int i = 0; i < cut.length; i++)
        {
            for(int j = 0; j < cut[i].length; j++)
            {
                totalFrames++;
            }
        }
        TextureRegion[] textures = new TextureRegion[totalFrames];
        int i = 0;
        for(TextureRegion[] l1 : cut)
        {
            for(TextureRegion l2 : l1)
            {
                textures[i++] = l2;
            }
        }
        this.anim = new Animation(0.5f, textures);
    }

    public void draw(float delta)
    {
        stateTime += delta;
        batch.begin();
        batch.draw(anim.getKeyFrame(stateTime, true), x, y);
        batch.end();
    }

    public void move(Vector2 vec)
    {
        move(vec.x, vec.y);
    }

    public void move(float x, float y)
    {
        move(x, y, 1);
    }

    public void move(float x, float y, float scl) {
        this.setX(getX() + x * scl);
        this.setY(getY() + y * scl);
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
        setX(x);
        setY(y);
    }

    public void update(float delta) {
        move(KeyboardMgr.getDirectionVec().scl(delta * 200));
    }
}