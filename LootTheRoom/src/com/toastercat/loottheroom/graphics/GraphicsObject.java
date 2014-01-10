package com.toastercat.loottheroom.graphics;

import com.toastercat.loottheroom.util.AssetMap;

public class GraphicsObject
{
	//- Constants ----------------------------------------=
	//
	public static final String DEFAULT_IMAGE = AssetMap.MANDO;
	
	//- Boundary fields ----------------------------------=
	//
	private float objectWidth  = 0.0f; // delta-x
	private float objectDepth  = 0.0f; // delta-y
	private float objectHeight = 0.0f; // delta-z	
	
	private Sprite sprite;
	
	public GraphicsObject()
	{
		this.sprite = new Sprite(DEFAULT_IMAGE, (int) this.objectWidth, (int) this.objectDepth);
	}
	public GraphicsObject(float width, float depth, float height)
	{
		this.objectWidth = width;
		this.objectDepth = depth;
		this.objectHeight = height;
		this.sprite = new Sprite(DEFAULT_IMAGE, (int) this.objectWidth, (int) this.objectDepth);
	}
	
	public Sprite getSprite() { return this.sprite; }

	//~ ACCESSORS =============================================== ~//
	//
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
