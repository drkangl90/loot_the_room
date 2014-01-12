package com.toastercat.loottheroom.ui;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;

import com.toastercat.loottheroom.game.Drawable2D;
import com.toastercat.loottheroom.game.Drawable3D;
import com.toastercat.loottheroom.game.GameCamera;
import com.toastercat.loottheroom.game.Touchable;

public class Joystick
	implements Drawable2D, Drawable3D, Touchable
{
	public static final int DEFAULT_JOYSTICK_RADIUS = 150;
	public static final int DEFAULT_THUMB_RADIUS    = 50;
	public static final int DEFAULT_OFFSET_X        = 25;
	public static final int DEFAULT_OFFSET_Y        = 15;
	
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
		
		if (! this.touchDown)
		{
			this.thumbX = cx;
			this.thumbY = cy;
		}
		
		paint.setColor(Color.rgb(128, 0, 0));
		paint.setAlpha(128);
		paint.setStrokeWidth(5);
		canvas.drawLine(cx, cy, this.thumbX, this.thumbY, paint);
			
		canvas.drawCircle(this.thumbX, this.thumbY, this.thumbRadius, paint);
			
		// Don't forget to be courteous... bitch.
		paint.reset();
	}
	@Override
	public void draw2D(Canvas canvas, Paint paint, GameCamera camera)
	{
		this.draw2D(canvas, paint);
	}
	
	@Override
	public void draw3D()
	{
		// TODO 3D and shit
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
