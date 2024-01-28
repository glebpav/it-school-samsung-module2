package ru.samung.gamestudio;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Bird {

    float x, y;
    float birdWith, birdHeight;

    int speed;
    float jumpHeight;
    final float maxHeightOfJump = 200f;
    boolean jump = true;

    int frameCounter;
    Texture[] framesArray;

    public Bird(float x, float y, int speed, float birdWith, float birdHeight) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.birdWith = birdWith;
        this.birdHeight = birdHeight;
        frameCounter = 0;

        framesArray = new Texture[]{
                new Texture("birdTiles/bird0.png"),
                new Texture("birdTiles/bird1.png"),
                new Texture("birdTiles/bird2.png"),
                new Texture("birdTiles/bird1.png"),
        };
    }

    void onClick() {
        jump = true;
        jumpHeight = maxHeightOfJump + y;
    }

    void fly() {
        if (y >= jumpHeight) {
            jump = false;
        }

        if (jump) {
            y += speed;
        } else {
            y -= speed;
        }
    }

    void draw(Batch batch) {
        int frameMultiplier = 10;
        batch.draw(framesArray[frameCounter / frameMultiplier], x, y, birdWith, birdHeight);
        if (frameCounter++ == framesArray.length * frameMultiplier - 1) frameCounter = 0;
    }

    void dispose() {
        for (Texture texture : framesArray) {
            texture.dispose();
        }
    }

}
