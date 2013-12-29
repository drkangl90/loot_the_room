package com.toastercat.loottheroom.graphics;

import com.toastercat.loottheroom.util.AssetMap;

import android.graphics.Bitmap;
import android.graphics.Color;

public class Sprite
{
	private Bitmap image = null;
	private int  color;
	
	public Sprite(String imageKey)
	{
		this.image = AssetMap.getImage(imageKey);
		this.color = Color.rgb(64, 64, 64);
	}
	
	public int getColor() { return this.color; }
	public Bitmap getImage() { return this.image; }
}
