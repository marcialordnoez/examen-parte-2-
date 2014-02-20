package com.me.mygdxgame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGdxGame implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;
	private Sprite sprite_nave;
	private Texture texture_nave;
	private Texture texture_enemigo;
    private Sprite sprite_enemigo;
    private Texture texture_fondo;
    private Sprite sprite_fondo;
	float translate;
	@Override
	public void create() {		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		
		texture = new Texture(Gdx.files.internal("data/libgdx.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);
		
		sprite = new Sprite(region);
		sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
		sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
		sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
		
		texture_nave = new Texture(Gdx.files.internal("data/nave.png"));
		sprite_nave=new Sprite(texture_nave,128,64);
		sprite_nave.setPosition(-0.5f,-0.2f);
		sprite_nave.setSize(0.5f, 0.50f);
		
		texture_enemigo = new Texture(Gdx.files.internal("data/enemy.png"));
		sprite_enemigo = new Sprite(texture_enemigo ,128,128);
		sprite_enemigo.setPosition(-0.2f,-0.2f);
		sprite_enemigo.setSize(0.5f, 0.5f);
		
		texture_fondo = new Texture(Gdx.files.internal("data/fondo.png"));
		sprite_fondo = new Sprite(texture_fondo ,128,64);
		sprite_fondo.setPosition(-0.5f,-0.5f);
		sprite_fondo.setSize(1f, 1f);
	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		sprite_enemigo.setX(translate);
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();

		sprite_fondo.draw(batch);
		sprite_nave.draw(batch);
		sprite_enemigo.draw(batch);
		//sprite.draw(batch);
		batch.end();
		
		if(Gdx.input.isTouched())
		{
			translate-=0.01;
		}
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
}
