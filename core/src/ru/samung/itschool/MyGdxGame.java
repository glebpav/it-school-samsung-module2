package ru.samung.itschool;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture birdTexture;

	int birdX, birdY;
	int birdSpeed = 5;

	int birdWidth = 250;
	int birdHeight = 200;

	boolean up = true;

	int screenHeight, screenWidth;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		birdTexture = new Texture("bird0.png");

		birdX = 0;
		birdY = 0;

		screenHeight = Gdx.graphics.getHeight();
		screenWidth = Gdx.graphics.getWidth();

	}

	@Override
	public void render () {

		if (birdY >= screenHeight - birdHeight) {
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
		batch.begin();
		batch.draw(birdTexture, birdX, birdY, birdWidth, birdHeight);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		birdTexture.dispose();
	}
}
