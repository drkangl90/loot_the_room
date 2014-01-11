package com.toastercat.loottheroom.game;

public class GameObject
{
	private WorldCoordinate location = null;
	
	private float objectWidth  = 0.0f; // delta-x
	private float objectDepth  = 0.0f; // delta-y
	private float objectHeight = 0.0f; // delta-z
	
	public GameObject()
	{
		this.location = new WorldCoordinate(0, 0, 0);
	}
	
	public void setSize(float width, float depth, float height)
	{
		this.objectWidth = width;
		this.objectDepth = depth;
		this.objectHeight = height;
	}

	//~ ACCESSORS =============================================== ~//
	//
	//- Location -----------------------------------------=
	public WorldCoordinate getLocation() { return location; }
	public void setLocation(float x, float y, float z) {
		this.location = new WorldCoordinate(x, y, z);
	}
	//- Width -------------------------------------------=
	public float getObjectWidth() { return objectWidth; }
	public void setObjectWidth(float w) { this.objectWidth = w; }
	//- Depth -------------------------------------------=
	public float getObjectDepth() { return objectDepth; }
	public void setObjectDepth(float d) { this.objectDepth = d; }
	//- Height -------------------------------------------=
	public float getObjectHeight() { return objectHeight; }
	public void setObjectHeight(float h) { this.objectHeight = h; }
}
