package ru.samung.gamestudio;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class ScreenGame implements Screen {

    MyGdxGame myGdxGame;

    Texture birdTexture;

    int birdX = 0, birdY = 0;
    int birdSpeed = 5;


    ScreenGame(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        birdTexture = new Texture("bird0.png");
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        birdX += birdSpeed;
        birdY += birdSpeed;

        ScreenUtils.clear(1, 0, 0, 1);
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();

        myGdxGame.batch.draw(birdTexture, birdX, birdY);

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
