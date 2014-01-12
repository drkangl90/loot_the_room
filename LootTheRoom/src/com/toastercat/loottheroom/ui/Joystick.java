package com.toastercat.loottheroom.ui;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;

import com.toastercat.loottheroom.game.Drawable2D;
import com.toastercat.loottheroom.game.GameCamera;
import com.toastercat.loottheroom.game.Touchable;

public class Joystick
	implements Drawable2D, Touchable
{
	public static final int DEFAULT_JOYSTICK_RADIUS = 200;
	public static final int DEFAULT_THUMB_RADIUS    = 75;
	public static final int DEFAULT_OFFSET_X        = 25;
	public static final int DEFAULT_OFFSET_Y        = 25;
	
	private int joystickRadius = DEFAULT_JOYSTICK_RADIUS;
	private int thumbRadius    = DEFAULT_THUMB_RADIUS;
	private int offsetX        = DEFAULT_OFFSET_X;
	private int offsetY        = DEFAULT_OFFSET_Y;
	
	private boolean touchDown;
	private int thumbX;
	private int thumbY;
	
	public Joystick()
	{
		this.touchDown = false;
		this.thumbX = 0;
		this.thumbY = 0;
	}

	@Override
	public void draw2D(Canvas canvas, Paint paint)
	{
		int cx = this.offsetX + this.joystickRadius;
		int cy = canvas.getHeight() - (this.offsetY + this.joystickRadius);
		
		paint.setColor(Color.rgb(128, 128, 128));
		paint.setAlpha(64);
		canvas.drawCircle(cx, cy, this.joystickRadius, paint);
		
		if (this.touchDown)
		{
			paint.setColor(Color.rgb(128, 0, 0));
			paint.setAlpha(128);
			paint.setStrokeWidth(4);
			canvas.drawLine(cx, cy, this.thumbX, this.thumbY, paint);
			
			canvas.drawCircle(this.thumbX, this.thumbY, this.thumbRadius, paint);
		}
	}
	@Override
	public void draw2D(Canvas canvas, Paint paint, GameCamera camera)
	{
		this.draw2D(canvas, paint);
	}
	
	@Override
	public void onTouch(MotionEvent e)
	{
		if (e.getPointerCount() > 1)
		{
			return;
		}
		
		switch(e.getAction()) {
			case MotionEvent.ACTION_DOWN:
				this.touchDown = true;
				this.thumbX = (int) e.getX();
				this.thumbY = (int) e.getY();
				break;
				
			case MotionEvent.ACTION_MOVE: 
				this.thumbX = (int) e.getX();
				this.thumbY = (int) e.getY();
				break;
				
			case MotionEvent.ACTION_UP:
				this.touchDown = false;
				break;
		}
	}
}
