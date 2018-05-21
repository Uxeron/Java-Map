package com.uxeron.map;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

public class Map implements ApplicationListener {

	static final int WORLD_WIDTH = 100;
	static final int WORLD_HEIGHT = 100;

	private OrthographicCamera cam;
	private SpriteBatch batch;

	private Sprite mapSprite;
	private float rotationSpeed;

	Vector3 tp = new Vector3();

	@Override
	public void create() {
		rotationSpeed = 0.5f;

		mapSprite = new Sprite(new Texture("badlogic.jpg"));
		mapSprite.setPosition(0, 0);
		mapSprite.setSize(WORLD_WIDTH, WORLD_HEIGHT);

		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		// Constructs a new OrthographicCamera, using the given viewport width and height
		// Height is multiplied by aspect ratio.
		cam = new OrthographicCamera(30, 30 * (h / w));

		cam.position.set(cam.viewportWidth / 2f, cam.viewportHeight / 2f, 0);
		cam.update();

		batch = new SpriteBatch();

		Gdx.input.setInputProcessor(new InputAdapter() {
			@Override
			public boolean scrolled (int change) {
				cam.unproject(tp.set(Gdx.input.getX(), Gdx.input.getY(), 0 ));
				float px = tp.x;
				float py = tp.y;
				cam.zoom += change * cam.zoom * 0.1f;
				cam.update();

				cam.unproject(tp.set(Gdx.input.getX(), Gdx.input.getY(), 0 ));
				cam.position.add(px - tp.x, py- tp.y, 0);
				cam.update();
				return true;
			}
			public boolean touchDown(int screenX, int screenY, int pointer, int button) {
				if (button == Input.Buttons.FORWARD) {
					cam.zoom += 0.02;
				}
				if (button == Input.Buttons.BACK) {
					cam.zoom -= 0.02;
				}
				return true;
			}
		});
	}

	@Override
	public void render() {
		handleInput();
		cam.update();
		batch.setProjectionMatrix(cam.combined);

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		mapSprite.draw(batch);
		batch.end();
	}

	private void handleInput() {
		if (Gdx.input.isKeyPressed(Input.Buttons.LEFT)) {
			cam.zoom += 0.02;
		}
		if (Gdx.input.isKeyPressed(Input.Buttons.RIGHT)) {
			cam.zoom -= 0.02;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			cam.translate(-3, 0, 0);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			cam.translate(3, 0, 0);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			cam.translate(0, -3, 0);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			cam.translate(0, 3, 0);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.W)) {
			cam.rotate(-rotationSpeed, 0, 0, 1);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.E)) {
			cam.rotate(rotationSpeed, 0, 0, 1);
		}

		cam.zoom = MathUtils.clamp(cam.zoom, 0.1f, 100/cam.viewportWidth);

		float effectiveViewportWidth = cam.viewportWidth * cam.zoom;
		float effectiveViewportHeight = cam.viewportHeight * cam.zoom;

		cam.position.x = MathUtils.clamp(cam.position.x, effectiveViewportWidth / 2f, 100 - effectiveViewportWidth / 2f);
		cam.position.y = MathUtils.clamp(cam.position.y, effectiveViewportHeight / 2f, 100 - effectiveViewportHeight / 2f);
	}

	@Override
	public void resize(int width, int height) {
		cam.viewportWidth = 30f;
		cam.viewportHeight = 30f * height/width;
		cam.update();
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		mapSprite.getTexture().dispose();
		batch.dispose();
	}

	@Override
	public void pause() {
	}
}