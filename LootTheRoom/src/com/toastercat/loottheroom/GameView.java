package com.toastercat.loottheroom;

import java.util.Observable;
import java.util.Observer;

import com.toastercat.loottheroom.game.GameModel;
import com.toastercat.loottheroom.game.GameObject;
import com.toastercat.loottheroom.game.WorldCoordinate;
import com.toastercat.loottheroom.graphics.Sprite;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class GameView extends View
	implements Observer
{
	private Paint brush = null;
	private GameModel model = null;

	public GameView(Context context, AttributeSet attrs)
	{
		super(context, attrs);

		this.brush = new Paint();
	}
	
	@Override
	public void onDraw(Canvas canvas) 
	{
		int screen_width  = canvas.getWidth();
		int screen_height = canvas.getHeight();
		
		if (this.model == null)
		{
			this.brush.setColor(Color.rgb(16, 0, 0));
			canvas.drawRect(0, 0, screen_width, screen_height, this.brush);
			
			this.brush.setColor(Color.rgb(200, 200, 200));
			canvas.drawText("Loading...", 25, 25, this.brush);
		}
		else
		{
			// Default Backdrop (Black)
			this.brush.setColor(Color.rgb(0, 0, 0));
			canvas.drawRect(0, 0, screen_width, screen_height, this.brush);
			
			// Test, test, Motherfucker?
			this.drawObject(this.model.testObject, canvas);
			
			// Health Bar
			this.brush.setColor(Color.rgb(0, 200, 0));
			canvas.drawRect(0,  0, 10, screen_height, this.brush);
		}
	}
	
	private void drawObject(GameObject object, Canvas canvas)
	{
		WorldCoordinate loc = object.getLocation();
		Sprite sprite = object.getGraphic().getSprite();
		
		float x = loc.getX();
		float y = loc.getY();
		
		float w = object.getObjectWidth();
		float d = object.getObjectDepth();
		
		// BG Rect
		this.brush.setColor(sprite.getColor());
		canvas.drawRect(x, y, x + w, y + d, this.brush);
		
		// Coordinate
		this.brush.setColor(Color.rgb(200, 200, 200));
		String coord = "(" + x + ", " + y + ", " + loc.getZ() + ")";
		canvas.drawText(coord, x, y, this.brush);
		
		// Image
		canvas.drawBitmap(sprite.getImage(), loc.getX(), loc.getY(), this.brush);
	}
	
	public void setModel(GameModel model)
	{
		this.model = model;
		this.model.addObserver(this);
	}
	
	@Override
	public void update(Observable arg0, Object arg1)
	{
		this.postInvalidate();
	}
}
