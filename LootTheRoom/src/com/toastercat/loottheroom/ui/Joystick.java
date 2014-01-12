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
	private static final int JOY_WIDTH = 250;

	@Override
	public void draw2D(Canvas canvas, Paint paint)
	{
		//int width = canvas.getWidth();
		int height = canvas.getHeight();
		paint.setColor(Color.rgb(128, 128, 128));
		paint.setAlpha(128);
		canvas.drawCircle(50, height - (JOY_WIDTH+50), JOY_WIDTH / 2, paint);
	}
	@Override
	public void draw2D(Canvas canvas, Paint paint, GameCamera camera)
	{
		this.draw2D(canvas, paint);
	}
	
	@Override
	public void onTouch(MotionEvent e)
	{
		//int p = e.getPointerCount();
	}
}
