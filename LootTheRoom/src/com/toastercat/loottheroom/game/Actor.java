package com.toastercat.loottheroom.game;

import com.toastercat.loottheroom.graphics.Sprite;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Actor extends GameObject
	implements GameDrawable2D, GameDrawable3D, GameCollidable
{
	public Actor()
	{
		super();
	}

	//~ DEFAULT BEHAVIORS ======================================= ~//
	//
	/**
	 * Default collision Behavior
	 */
	@Override
	public void onCollide(GameCollidable other)
	{
		// TODO Auto-generated method stub	
	}
	//
	/**
	 * Default 3D drawing method
	 */
	@Override
	public void draw3D()
	{
		// TODO Figure out Android 3D GL
	}
	//
	/**
	 * Default 2D drawing method
	 */
	@Override
	public void draw2D(Canvas canvas, Paint paint)
	{
		WorldCoordinate loc = this.getLocation();
		Sprite sprite = this.getGraphic().getSprite();
		
		float x = loc.getX();
		float y = loc.getY();
		
		float width = this.getObjectWidth();
		float depth = this.getObjectDepth();
		
		// BG Rect
		paint.setColor(sprite.getColor());
		canvas.drawRect(x, y, x + width, y + depth, paint);
		
		// Coordinate
		paint.setColor(Color.rgb(200, 200, 200));
		String coord = "(" + x + ", " + y + ", " + loc.getZ() + ")";
		canvas.drawText(coord, x, y, paint);
		
		// Image
		canvas.drawBitmap(sprite.getImage(), loc.getX(), loc.getY(), paint);
	}	
}
