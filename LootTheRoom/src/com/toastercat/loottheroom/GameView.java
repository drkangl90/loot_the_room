package com.toastercat.loottheroom;

import java.util.Observable;
import java.util.Observer;

import com.toastercat.loottheroom.game.GameModel;
import com.toastercat.loottheroom.game.GameObject;
import com.toastercat.loottheroom.game.WorldCoordinate;
import com.toastercat.loottheroom.graphics.Sprite;
import com.toastercat.loottheroom.ui.Joystick;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class GameView extends View
	implements Observer
{
	private Paint brush = null;
	private GameModel model = null;
	private Joystick joystick = null;

	public GameView(Context context, AttributeSet attrs)
	{
		super(context, attrs);

		this.brush = new Paint();
		this.joystick = new Joystick();
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
			this.model.prettyActor.draw2D(canvas, this.brush, this.model.getCamera());
			this.model.boringActor.draw2D(canvas, this.brush, null);
			
			// Health Bar
			this.brush.setColor(Color.rgb(0, 200, 0));
			canvas.drawRect(0,  0, 10, screen_height, this.brush);
		}
		this.joystick.draw2D(canvas, this.brush);
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
	
	@Override
	public boolean onTouchEvent(MotionEvent e) 
	{
		int p = e.getPointerCount();
		switch (e.getAction()) {
			case MotionEvent.ACTION_DOWN:
				switch(p) {
					case 1:
						this.model.getCamera().setLocation(e.getX(), e.getY(), 0);
						break;
					default:
						break;
				}
				break;
			case MotionEvent.ACTION_MOVE:  
				switch(p) {
					case 1:
						this.model.getCamera().setLocation(e.getX(), e.getY(), 0);
						break;
					default:
						break;
				}				
				break;
			}
		
		this.joystick.onTouch(e);
		
		return true;
	}
}
