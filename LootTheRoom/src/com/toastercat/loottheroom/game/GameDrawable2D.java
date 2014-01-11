package com.toastercat.loottheroom.game;

import android.graphics.Canvas;
import android.graphics.Paint;

public interface GameDrawable2D
{
	public void draw2D(Canvas canvas, Paint paint);
	public void draw2D(Canvas canvas, Paint paint, GameCamera camera);
}
