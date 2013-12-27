package com.toastercat.loottheroom.graphics;

import com.toastercat.loottheroom.utilities.AssetMap;

import android.graphics.Bitmap;

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
	
	private Bitmap sprite;
	
	public GraphicsObject()
	{
		this.sprite = AssetMap.getImage(DEFAULT_IMAGE);
	}
	
	public Bitmap getSprite() 
	{
		return this.sprite;
	}
}
