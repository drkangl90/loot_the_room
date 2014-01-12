package com.toastercat.loottheroom.game;

import java.util.Observable;

import com.toastercat.loottheroom.util.GameState;
import com.toastercat.loottheroom.util.data.QuadTree;
import com.toastercat.loottheroom.util.data.SectorTree;

public class GameModel extends Observable
{
	private GameCamera camera = null;
	private GameState state = null;
	private Realm realm = null;
	
	private QuadTree<GameObject> roster = null;
	
	public Actor prettyActor = null;
	public Actor boringActor = null;
	
	public GameModel() 
	{
		super();
		
		this.state = GameState.INITIALIZE;
		this.roster = new SectorTree<GameObject>();
		
		this.camera = new GameCamera();
		
		this.prettyActor = new Actor();
		this.prettyActor.setSize(200.0f, 150.0f, 0.0f);
		this.prettyActor.setLocation(450, 400, 0);
		
		this.boringActor = new Actor();
	}
	
	public void update()
	{
		/*
		float x = this.prettyActor.getLocation().getX();
		float y = this.prettyActor.getLocation().getY();
		
		this.prettyActor.setLocation(x + 0.3f, y + 0.1f, 0);
		*/
	}
	
	public GameCamera getCamera() { return this.camera; }
}
