package ru.samung.itschool;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class MovingBackground {

    Texture texture;

    int x, x2;
    int speed = 3;

    public MovingBackground(String pathToTexture) {
        x = 0;
        x2 = MyGdxGame.SCR_WIDTH;
        texture = new Texture(pathToTexture);
    }

    public void move() {
        x -= speed;
        x2 -= speed;

        if (x <= -MyGdxGame.SCR_WIDTH) {
            x = MyGdxGame.SCR_WIDTH;
        }
        if (x2 <= -MyGdxGame.SCR_WIDTH) {
            x2 = MyGdxGame.SCR_WIDTH;
        }
    }

    public void draw(Batch batch) {
        batch.draw(texture, x, 0, MyGdxGame.SCR_WIDTH + 2, MyGdxGame.SCR_HEIGHT);
        batch.draw(texture, x2, 0, MyGdxGame.SCR_WIDTH + 2, MyGdxGame.SCR_HEIGHT);
    }

    public void dispose() {
        texture.dispose();
    }

}
