package com.toastercat.loottheroom.game;

import com.toastercat.loottheroom.graphics.GraphicsObject;

public class GameObject
{
	private WorldCoordinate location;
	private GraphicsObject graphic;
	
	private boolean visible;
	private boolean tangible;
	
	public GameObject()
	{
		this.visible = true;
		this.tangible = true;
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
