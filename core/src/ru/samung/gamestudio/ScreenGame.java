package ru.samung.gamestudio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;

public class ScreenGame implements Screen {

    MyGdxGame myGdxGame;

    Bird bird;

    ScreenGame(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;

        bird = new Bird(0, 0, 10, 250, 200);
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        if (Gdx.input.justTouched()) {
            bird.onClick();
        }

        bird.fly();

        ScreenUtils.clear(1, 0, 0, 1);
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();

        bird.draw(myGdxGame.batch);

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
        bird.dispose();
    }
}
