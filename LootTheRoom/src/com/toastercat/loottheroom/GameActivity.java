package com.toastercat.loottheroom;

import java.io.IOException;

import com.toastercat.loottheroom.game.GameCamera;
import com.toastercat.loottheroom.game.GameModel;
import com.toastercat.loottheroom.util.AssetMap;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;


public class GameActivity extends Activity
{
	public static final long DEFAULT_GAME_RATE  = 16;
	public static final long DEFAULT_VIEW_RATE = 32;
	
	private GameView  view;
	private GameModel model;
	
	private Thread gameThread = null;
	private Thread viewThread = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		this.view = (GameView) this.findViewById(R.id.game_view);
		
		try
		{
			AssetManager mgr = this.getAssets();
			AssetMap.initImage(mgr);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		this.model = new GameModel();
		
		// Link Model and View
		// (Do this AFTER ALL INITIALIZATION)
		this.view.setModel(this.model);
		
		this.initThreads();
	}
	
	@Override 
	public void onStart()
	{
		super.onStart();
		
		// Start game thread
		if (this.gameThread != null)
		{
			this.gameThread.start();
		}
		
		// Start view thread
		if (this.viewThread != null)
		{
			this.viewThread.start();
		}
	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState)
	{
		super.onPostCreate(savedInstanceState);
		
		//this.mSystemUiHider.toggle();
	}
	
	public void pauseGame(View v)
	{
		GameCamera cam = this.model.getCamera();
		
		float x = cam.getLocation().getX();
		float y = cam.getLocation().getY();
		
		cam.setLocation(x + 50, y + 25, 0);
		
		//this.view.postInvalidate();
	}
	
	private void initThreads()
	{
		final long gameRate = DEFAULT_GAME_RATE;
		final long viewRate = DEFAULT_VIEW_RATE;
		
		Runnable gameRunner = new Runnable()
			{
				@Override
				public void run() {
					while (true) {
						try
						{
							Thread.sleep(gameRate);
							model.update();
						} catch (InterruptedException e)
						{
							e.printStackTrace();
						}
					}
				}
			};
		Runnable viewRunner = new Runnable()
			{
				@Override
				public void run() {
					while (true) {
						try
						{
							Thread.sleep(viewRate);
							view.postInvalidate();
						} catch (InterruptedException e)
						{
							e.printStackTrace();
						}
					}
				}
			};
			
		this.gameThread = new Thread(gameRunner);
		this.viewThread = new Thread(viewRunner);
	}
}
