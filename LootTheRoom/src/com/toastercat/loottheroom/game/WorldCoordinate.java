package com.toastercat.loottheroom.game;

/**
 * com.toastercat.loottheroom.game.WorldCoordinate.java
 * WorldCoordinate
 * 
 * 3D location struct
 *  - X axis
 *  - Y axis
 *  - Z axis (pronounced "ZED" dammit!)
 * 
 * @author Dirk N. Hortensius
 * @version Dec 26, 2013
 */
public class WorldCoordinate
{
	private float x = 0.0f;
	private float y = 0.0f;
	private float z = 0.0f;
	
	/**
	 * CONSTRUCTOR - Explicit
	 *
	 * @param x - X-Axis value
	 * @param y - Y-Axis value
	 * @param z - Z-Axis value
	 */
	public WorldCoordinate(float x, float y, float z) 
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	//~ ACCESSORS =============================================== ~//
	//
	//- X ------------------------------------------------=
	public float getX()	{ return x; }
	public void setX(float x) { this.x = x; }
	//- Y ------------------------------------------------=
	public float getY()	{ return y; }
	public void setY(float y) { this.y = y; }
	//- Z ------------------------------------------------=
	public float getZ()	{ return z; }
	public void setZ(float z) { this.z = z; }	
}
