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
	
	public Actor testActor = null;
	
	public GameModel() 
	{
		super();
		
		this.state = GameState.INITIALIZE;
		this.roster = new SectorTree<GameObject>();
		
		this.testActor = new Actor();
		this.testActor.setSize(300.0f, 100.0f, 0.0f);
		//this.testObject.objectWidth = 200.0f;
		//this.testObject.objectDepth = 200.0f;
		this.testActor.setLocation(150, 100, 0);
	}
}
