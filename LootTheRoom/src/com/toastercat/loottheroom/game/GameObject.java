package com.toastercat.loottheroom.game;

import com.toastercat.loottheroom.graphics.GraphicsObject;

public class GameObject
{
	private WorldCoordinate location = null;
	private GraphicsObject graphic = null;
	
	private boolean visible  = false;
	private boolean tangible = false;
	
	public GameObject()
	{
		this.location = new WorldCoordinate(0, 0, 0);
		this.graphic = new GraphicsObject();
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
}
