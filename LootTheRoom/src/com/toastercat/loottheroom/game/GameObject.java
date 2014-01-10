package com.toastercat.loottheroom.game;

import com.toastercat.loottheroom.graphics.GraphicsObject;

public class GameObject
{
	private WorldCoordinate location = null;
	private GraphicsObject graphic = null;
	
	private boolean visible  = false;
	private boolean tangible = false;
	
	private float objectWidth  = 0.0f; // delta-x
	private float objectDepth  = 0.0f; // delta-y
	private float objectHeight = 0.0f; // delta-z
	
	public GameObject()
	{
		this.location = new WorldCoordinate(0, 0, 0);
		this.graphic = new GraphicsObject(1, 1, 1);
	}
	
	public void setSize(float width, float depth, float height)
	{
		this.objectWidth = width;
		this.objectDepth = depth;
		this.objectHeight = height;
		this.graphic = new GraphicsObject(width, depth, height);
	}

	//~ ACCESSORS =============================================== ~//
	//
	//- Graphic ------------------------------------------=
	public GraphicsObject getGraphic() { return graphic; }
	public void setGraphic(GraphicsObject graphic) { this.graphic = graphic; }
	//- Location -----------------------------------------=
	public WorldCoordinate getLocation() { return location; }
	public void setLocation(float x, float y, float z) {
		this.location = new WorldCoordinate(x, y, z);
	}
	//- Visible ------------------------------------------=
	public boolean isVisible() { return visible; }
	public void setVisible(boolean isVisible) {	this.visible = isVisible; }
	//- Tangible -----------------------------------------=
	public boolean isTangible() { return tangible; }
	public void setTangible(boolean isTangible) { this.tangible = isTangible; }
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
