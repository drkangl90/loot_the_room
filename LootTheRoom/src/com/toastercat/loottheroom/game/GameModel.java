package com.toastercat.loottheroom.game;

import java.util.Observable;

import com.toastercat.loottheroom.utilities.GameState;

public class GameModel extends Observable
{
	private GameCamera camera = null;
	private GameState state = null;
	private Realm realm = null;
	
	public GameModel() 
	{
		super();
		
		this.state = GameState.INITIALIZE;
	}
}
