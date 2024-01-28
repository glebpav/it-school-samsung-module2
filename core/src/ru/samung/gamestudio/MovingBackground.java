package ru.samung.gamestudio;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class MovingBackground {

    Texture texture;

    int texture1X, texture2X;
    int speed = 2;

    MovingBackground() {
        texture1X = 0;
        texture2X = MyGdxGame.SCR_WIDTH;
        texture = new Texture("game_bg.png");
    }

    void move() {
        texture1X -= speed;
        texture2X -= speed;

        if (texture1X <= -MyGdxGame.SCR_WIDTH) {
            texture1X = MyGdxGame.SCR_WIDTH;
        }
        if (texture2X <= -MyGdxGame.SCR_WIDTH) {
            texture2X = MyGdxGame.SCR_WIDTH;
        }
    }

    void draw(Batch batch) {
        batch.draw(texture, texture1X, 0, MyGdxGame.SCR_WIDTH, MyGdxGame.SCR_HEIGHT);
        batch.draw(texture, texture2X, 0, MyGdxGame.SCR_WIDTH, MyGdxGame.SCR_HEIGHT);
    }

    void dispose() {
        texture.dispose();
    }

}
