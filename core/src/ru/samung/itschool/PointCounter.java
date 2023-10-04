package ru.samung.itschool;

import static ru.samung.itschool.MyGdxGame.SCR_HEIGHT;
import static ru.samung.itschool.MyGdxGame.SCR_WIDTH;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class PointCounter {

    int x, y;
    BitmapFont font;

    public PointCounter(int x, int y) {
        this.x = x;
        this.y = y;

        font = new BitmapFont();
        font.getData().scale(5f);
        font.setColor(Color.WHITE);
    }

    public void draw(Batch batch, int countOfPoints) {
        font.draw(batch, "Score: " + countOfPoints, x, y);
    }

    public void dispose() {
        font.dispose();
    }

}
