package com.toastercat.loottheroom.graphics;

import com.toastercat.loottheroom.utilities.AssetMap;

public class GraphicsObject
{
	//- Constants ----------------------------------------=
	//
	public static final String DEFAULT_IMAGE = AssetMap.MANDO;
	
	//- Boundary fields ----------------------------------=
	//
	//TODO: Make private w/ getters
	float objectWidth  = 0.0f; // delta-x
	float objectDepth  = 0.0f; // delta-y
	float objectHeight = 0.0f; // delta-z	
	
	private Sprite sprite;
	
	public GraphicsObject()
	{
		this.sprite = new Sprite(DEFAULT_IMAGE);
	}
	
	public Sprite getSprite() { return this.sprite; }
}