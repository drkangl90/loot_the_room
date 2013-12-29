package com.toastercat.loottheroom;

import java.io.IOException;

import com.toastercat.loottheroom.game.GameModel;
import com.toastercat.loottheroom.utilities.AssetMap;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;


public class GameActivity extends Activity
{
	private GameView  view;
	private GameModel model;
	
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
	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState)
	{
		super.onPostCreate(savedInstanceState);
		
		//this.mSystemUiHider.toggle();
	}
	
	public void pauseGame(View v)
	{
		return;
	}
}
