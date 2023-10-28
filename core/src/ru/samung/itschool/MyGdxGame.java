package ru.samung.itschool;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.samung.itschool.screens.ScreenGame;
import ru.samung.itschool.screens.ScreenMenu;
import ru.samung.itschool.screens.ScreenRestart;

public class MyGdxGame extends Game {

    public SpriteBatch batch;
    public OrthographicCamera camera;

    public static final int SCR_WIDTH = 1280;
    public static final int SCR_HEIGHT = 720;

    public ScreenGame screenGame;
    public ScreenMenu screenMenu;
    public ScreenRestart screenRestart;

    @Override
    public void create() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);

        screenGame = new ScreenGame(this);
        screenMenu = new ScreenMenu(this);
        screenRestart = new ScreenRestart(this);

        setScreen(screenMenu);
    }


    @Override
    public void dispose() {
        batch.dispose();
    }
}
