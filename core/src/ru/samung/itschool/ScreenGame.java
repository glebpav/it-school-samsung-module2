package ru.samung.itschool;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class ScreenGame implements Screen {

    MyGdxGame myGdxGame;

    Texture birdTexture;

    int birdX, birdY;
    int birdSpeed = 5;

    int birdWidth = 250;
    int birdHeight = 200;

    boolean up = true;

    ScreenGame(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;

        birdTexture = new Texture("bird0.png");

        birdX = 0;
        birdY = 0;
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if (birdY >= myGdxGame.SCR_HEIGHT - birdHeight) {
            up = false;
        }
        if (birdY <= 0) {
            up = true;
        }

        if (up) {
            birdY += birdSpeed;
        } else {
            birdY -= birdSpeed;
        }

        ScreenUtils.clear(1, 0, 0, 1);
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();

        myGdxGame.batch.draw(birdTexture, birdX, birdY, birdWidth, birdHeight);

        myGdxGame.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        birdTexture.dispose();
    }
}
