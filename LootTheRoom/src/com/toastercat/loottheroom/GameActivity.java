package com.toastercat.loottheroom;

import com.toastercat.loottheroom.game.GameModel;
import com.toastercat.loottheroom.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;


public class GameActivity extends Activity
{
	private GameView  view;
	private GameModel model;
	
	SystemUiHider mSystemUiHider;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_game);
		
		this.view = (GameView) this.findViewById(R.id.game_view);
		this.model = new GameModel();
		
		// Link Model and View
		this.view.setModel(this.model);
		
		mSystemUiHider = SystemUiHider.getInstance(this, this.view, SystemUiHider.FLAG_FULLSCREEN);
	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState)
	{
		super.onPostCreate(savedInstanceState);
		
		//this.mSystemUiHider.toggle();
	}
	
	public void pauseGame(View v)
	{
		this.mSystemUiHider.toggle();
	}
}
