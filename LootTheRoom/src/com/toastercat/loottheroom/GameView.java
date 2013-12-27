package com.toastercat.loottheroom;

import java.util.Observable;
import java.util.Observer;

import com.toastercat.loottheroom.game.GameModel;

import android.content.Context;
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
			this.brush.setColor(Color.rgb(0, 0, 0));
			canvas.drawRect(0, 0, screen_width, screen_height, this.brush);
			
			this.brush.setColor(Color.rgb(0, 200, 0));
			canvas.drawRect(0,  0, 10, screen_height, this.brush);
		}
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
