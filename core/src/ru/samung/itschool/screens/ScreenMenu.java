package ru.samung.itschool.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.samung.itschool.componements.MovingBackground;
import ru.samung.itschool.MyGdxGame;
import ru.samung.itschool.componements.TextButton;

public class ScreenMenu implements Screen {

    MyGdxGame myGdxGame;

    MovingBackground background;
    TextButton buttonStart;
    TextButton buttonExit;

    public ScreenMenu(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;

        buttonStart = new TextButton(100, 400, "Start");
        buttonExit = new TextButton(700, 400, "Exit");
        background = new MovingBackground("backgrounds/restart_bg.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if (Gdx.input.justTouched()) {
            int tx = Gdx.input.getX();
            int ty = MyGdxGame.SCR_HEIGHT - Gdx.input.getY();

            if (buttonStart.isHit(tx, ty)) {
                myGdxGame.setScreen(myGdxGame.screenGame);
            }
            if (buttonExit.isHit(tx, ty)) {
                Gdx.app.exit();
            }
        }

        ScreenUtils.clear(1, 0, 0, 1);
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();

        background.draw(myGdxGame.batch);
        buttonStart.draw(myGdxGame.batch);
        buttonExit.draw(myGdxGame.batch);

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
        background.dispose();
        buttonExit.dispose();
        buttonStart.dispose();
    }
}
