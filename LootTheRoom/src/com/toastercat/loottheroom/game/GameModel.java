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
	
	public GameObject testObject = null;
	
	public GameModel() 
	{
		super();
		
		this.state = GameState.INITIALIZE;
		this.roster = new SectorTree<GameObject>();
		
		this.testObject = new GameObject();
		this.testObject.setSize(300.0f, 100.0f, 0.0f);
		//this.testObject.objectWidth = 200.0f;
		//this.testObject.objectDepth = 200.0f;
		this.testObject.setLocation(150, 100, 0);
	}
}
