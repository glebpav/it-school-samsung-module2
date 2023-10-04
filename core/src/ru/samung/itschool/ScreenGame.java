package ru.samung.itschool;

import static ru.samung.itschool.MyGdxGame.SCR_HEIGHT;
import static ru.samung.itschool.MyGdxGame.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Random;

public class ScreenGame implements Screen {

    MyGdxGame myGdxGame;

    Bird bird;
    PointCounter pointCounter;

    int tubeCount = 3;
    Tube[] tubes;

    int gamePoints;
    boolean isGameOver;

    ScreenGame(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;

        initTubes();
        bird = new Bird(20, SCR_HEIGHT / 2, 10, 250, 200);
        pointCounter = new PointCounter(SCR_WIDTH - 400, SCR_HEIGHT - 60);
    }


    @Override
    public void show() {
        gamePoints = 0;
        isGameOver = false;
    }

    @Override
    public void render(float delta) {

        if (Gdx.input.justTouched()) {
            bird.onClick();
        }

        bird.fly();
        if (!bird.isInField()) {
            System.out.println("not in field");
            isGameOver = true;
        }
        for (Tube tube : tubes) {
            tube.move();
            if (tube.isHit(bird)) {
                System.out.println("hit");
                isGameOver = true;
            } else if (tube.isPassed(bird)) {
                gamePoints += 1;
                System.out.println(gamePoints);
            }
        }

        ScreenUtils.clear(1, 0, 0, 1);
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();

        bird.draw(myGdxGame.batch);
        for (Tube tube : tubes) tube.draw(myGdxGame.batch);
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
        bird.dispose();
        pointCounter.dispose();
        for (int i = 0; i < tubeCount; i++) {
            tubes[i].dispose();
        }
    }

    void initTubes() {
        tubes = new Tube[tubeCount];
        for (int i = 0; i < tubeCount; i++) {
            tubes[i] = new Tube(tubeCount, i);
        }
    }

}
