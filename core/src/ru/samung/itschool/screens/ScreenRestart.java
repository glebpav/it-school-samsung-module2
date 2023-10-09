package ru.samung.itschool.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.samung.itschool.components.MovingBackground;
import ru.samung.itschool.MyGdxGame;
import ru.samung.itschool.components.PointCounter;
import ru.samung.itschool.components.TextButton;

public class ScreenRestart implements Screen {

    MyGdxGame myGdxGame;

    MovingBackground background;
    PointCounter pointCounter;
    TextButton buttonRestart;
    TextButton buttonMenu;

    int gamePoints;

    public ScreenRestart(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;

        pointCounter = new PointCounter(750, 530);
        buttonRestart = new TextButton(100, 400, "Restart");
        buttonMenu = new TextButton(100, 150, "Menu");
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

            if (buttonRestart.isHit(tx, ty)) {
                myGdxGame.setScreen(myGdxGame.screenGame);
            }
            if (buttonMenu.isHit(tx, ty)) {
                myGdxGame.setScreen(myGdxGame.screenMenu);
            }
        }

        ScreenUtils.clear(1, 0, 0, 1);
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();

        background.draw(myGdxGame.batch);
        buttonMenu.draw(myGdxGame.batch);
        buttonRestart.draw(myGdxGame.batch);
        pointCounter.draw(myGdxGame.batch, gamePoints);

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
        buttonRestart.dispose();
    }
}
