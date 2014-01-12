package com.toastercat.loottheroom.game;

import com.toastercat.loottheroom.graphics.GraphicsObject;
import com.toastercat.loottheroom.graphics.Sprite;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Actor extends GameObject
	implements Drawable2D, Drawable3D, Collidable
{
	private GraphicsObject graphic = null;
	
	public Actor()
	{
		super();
	}
	
	@Override
	public void setSize(float width, float depth, float height)
	{
		super.setSize(width, depth, height);
		this.graphic = new GraphicsObject(width, depth, height);
	}

	//~ DEFAULT BEHAVIORS ======================================= ~//
	//
	/**
	 * Default collision Behavior
	 */
	@Override
	public void onCollide(Collidable other)
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
		this.draw2D(canvas, paint, null);
	}
	@Override
	public void draw2D(Canvas canvas, Paint paint, GameCamera camera)
	{		
		float x = this.getLocation().getX();
		float y = this.getLocation().getY();
		if (camera != null)
		{
			x -= camera.getLocation().getX();
			y -= camera.getLocation().getY();
		}
		
		if (this.graphic == null)
		{
			// BG Rect
			paint.setColor(Color.rgb(200, 200, 200));
			canvas.drawRect(x, y, x + 50, y + 50, paint);
		}
		else
		{
			Sprite sprite = this.getGraphic().getSprite();
			float width = this.getObjectWidth();
			float depth = this.getObjectDepth();
			
			// BG Rect
			paint.setColor(sprite.getColor());
			canvas.drawRect(x, y, x + width, y + depth, paint);
			
			// Coordinate
			paint.setColor(Color.rgb(200, 200, 200));
			String coord = "(" + this.getLocation().getX() + ", " 
					+ this.getLocation().getY() + ", " 
					+ this.getLocation().getZ() + ")";
			canvas.drawText(coord, x, y, paint);
			
			// Image
			canvas.drawBitmap(sprite.getImage(), x, y, paint);
		}
	}
	
	//~ ACCESSORS =============================================== ~//
	//
	//- Graphic ------------------------------------------=
	public GraphicsObject getGraphic() { return graphic; }
}
