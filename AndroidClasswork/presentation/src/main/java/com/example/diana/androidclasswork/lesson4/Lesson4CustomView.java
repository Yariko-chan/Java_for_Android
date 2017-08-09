package com.example.diana.androidclasswork.lesson4;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import com.example.diana.androidclasswork.R;

/**
 * Created by Diana on 31.07.2017.
 */

public class Lesson4CustomView extends View {

    private Paint paint = new Paint();
    private RectF arcRectF = new RectF();
    private int cx = getWidth()/2;
    private int cy = getHeight()/2;

    public Lesson4CustomView(Context context) {
        super(context);
        init();
    }

    public Lesson4CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Lesson4CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Lesson4CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        // here no measurements, width and heights to get fron onSizeChanged()

        paint.setAntiAlias(true);// сглаживание
        paint.setColor(ContextCompat.getColor(getContext(), R.color.blue));
        paint.setStyle(Paint.Style.STROKE);

        // convertation from dip
        Resources r = getResources();
        float strokeWidthInPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                2, r.getDisplayMetrics());

        paint.setStrokeWidth(strokeWidthInPx);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // implements very often
        // here only draw, all hard works in init

        // draw circle in center , radius = half of minimal measurement
        int r = 50;
        canvas.drawCircle(cx, cy, r, paint);

//        canvas.drawLine(0, 0, getWidth(), getHeight(), paint);
//        paint.setTextSize(50);
//        canvas.drawText("1 2 3 4 5 6 7", 25, getHeight()/2, paint);
//
//        arcRectF.bottom = getHeight();
//        arcRectF.top = 0;
//        arcRectF.left = 0;
//        arcRectF.right = getWidth();
//        paint.setStyle(Paint.Style.FILL);
//        // 1 - from were, 2 - how much
//        canvas.drawArc(arcRectF, 90, 90, false, paint);
//
//        canvas.drawRect(getWidth()/2, 0, getWidth(), getHeight()/2, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        // here defining wrap_content behaviour
        // depends on content
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        // any screen size changes
        // called on first vreate of view
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        // Подписка к событиям, в соответсв методе отписка
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // any clicks on screen
        // here to write behaviour

        // different click - click pressed, click left and click draws on screen

        // here to catch drawing on screen
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            cx = (int) event.getX();
            cy = (int) event.getY();
            invalidate(); // redraw
            requestLayout();
        } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
            cx = (int) event.getX();
            cy = (int) event.getY();
            invalidate(); // redraw
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            cx = (int) event.getX();
            cy = (int) event.getY();
            invalidate(); // redraw
        }

        return true;// say others view have you used this event or not
    }
}
