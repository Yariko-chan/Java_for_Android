package com.gmail.ganeeva.d.homework.lesson4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.icu.util.Calendar;
import android.icu.util.GregorianCalendar;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.gmail.ganeeva.d.homework.R;

import java.util.Date;

/**
 * Created by Diana on 04.08.2017 at 11:27.
 */

public class Lesson4ClockView extends View {
    private static final int THIN_DEGREE_WIDTH = 10;
    private static final int THIN_DEGREE_HEIGHT = 20;
    private static final int BOLD_DEGREE_WIDTH = 20;
    private static final int BOLD_DEGREE_HEIGHT = 40;
    private static final int NUMBERS_PAINT_WIDTH = 10;
    private static final int NUMBERS_WIDTH = 60;
    private static final int NUMBERS_SIZE = 100;
    private static final int HOURS_ARROW_WIDTH = 30;
    private static final int MIN_ARROW_WIDTH = 15;
    private static final int SEC_ARROW_WIDTH = 5;
    private static final int HOURS_ARROW_HEIGHT = 200;
    private static final int MIN_ARROW_HEIGHT = 260;
    private static final int SEC_ARROW_HEIGHT = 300;

    private Paint paint = new Paint();
    private Paint backgroundPaint = new Paint();
    private Paint thinDegreePaint = new Paint();
    private Paint boldDegreePaint = new Paint();
    private Paint numbersPaint = new Paint();
    private int widthSize;
    private int heightSize;

    public Lesson4ClockView(Context context) {
        super(context);
        init();
    }

    public Lesson4ClockView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Lesson4ClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Lesson4ClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        paint.setAntiAlias(true);// сглаживание
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);

        backgroundPaint.setColor(ContextCompat.getColor(getContext(), R.color.transparent_white));
        backgroundPaint.setStyle(Paint.Style.FILL);

        thinDegreePaint.setColor(Color.BLACK);
        thinDegreePaint.setStrokeWidth(THIN_DEGREE_WIDTH);
        thinDegreePaint.setStyle(Paint.Style.FILL);

        boldDegreePaint.setColor(Color.BLACK);
        boldDegreePaint.setStrokeWidth(BOLD_DEGREE_WIDTH);
        boldDegreePaint.setStyle(Paint.Style.FILL);

        numbersPaint.setColor(Color.BLACK);
        numbersPaint.setStrokeWidth(NUMBERS_PAINT_WIDTH);
        numbersPaint.setStyle(Paint.Style.FILL);
        numbersPaint.setTextSize(NUMBERS_SIZE);

        updateClockRunnable.run();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int radius = Math.min(widthSize/2, heightSize/2);
        int centerX = widthSize/2;
        int centerY = heightSize/2;

        // draw transparent white background
        canvas.drawCircle(centerX, centerY, radius, backgroundPaint);

        // draw clock face
        int oneClockDegree = 360/60;
        for (int i = 0; i < 60; i++) { // thin degrees
            canvas.rotate(oneClockDegree, centerX, centerY);
            if (i%15 == 0 || (i+1)%15 == 0 || (i+2)%15 == 0) continue; // place for number
            canvas.drawLine(centerX, centerY - radius,
                        centerX, centerY - radius + THIN_DEGREE_HEIGHT, thinDegreePaint);
        }
        for (int i = 0; i < 12; i++) { // bold degrees
            canvas.rotate(5*oneClockDegree, centerX, centerY);
            if ((i+1)%3 == 0) continue; // place for number
            canvas.drawLine(centerX, centerY - radius,
                centerX, centerY - radius + BOLD_DEGREE_HEIGHT, boldDegreePaint);
        }

        String[] numbers = {"3", "6", "9", "12"};
        Rect textBounds = new Rect();

        // draw numbers
        // numbersPaint.measureText - more correct value, textBounds.width doesn't place text in center
        numbersPaint.getTextBounds(numbers[0], 0, numbers[0].length(), textBounds);
        canvas.drawText(numbers[0], centerX + radius - numbersPaint.measureText(numbers[0]), centerY + textBounds.height()/2, numbersPaint);
        numbersPaint.getTextBounds(numbers[1], 0, numbers[1].length(), textBounds);
        canvas.drawText(numbers[1], centerX - numbersPaint.measureText(numbers[1])/2 , centerY + radius, numbersPaint);
        numbersPaint.getTextBounds(numbers[2], 0, numbers[2].length(), textBounds);
        canvas.drawText(numbers[2], centerX - radius, centerY + textBounds.height()/2, numbersPaint);
        numbersPaint.getTextBounds(numbers[3], 0, numbers[3].length(), textBounds);
        canvas.drawText(numbers[3], centerX - numbersPaint.measureText(numbers[3])/2 , centerY - radius + textBounds.height(), numbersPaint);

        // draw arrows
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);
        int min = calendar.get(Calendar.MINUTE);
        int sec = calendar.get(Calendar.SECOND);
        canvas.drawCircle(centerX, centerY, HOURS_ARROW_WIDTH/2, paint);

        // HOUR ARROW
        // 6 - to make 12h align on 12 hours (on 6 without it)
        double degreeAngle = (360/12)*(hour + (double) min/60 + 6);
        // "-" - to make arrow go clockwise (counter-cw by default)
        double radianAngle = - Math.toRadians(degreeAngle);
        int endX = centerX + (int)(HOURS_ARROW_HEIGHT*Math.sin(radianAngle));
        int endY = centerY + (int)(HOURS_ARROW_HEIGHT*Math.cos(radianAngle));
        paint.setStrokeWidth(HOURS_ARROW_WIDTH);
        canvas.drawLine(centerX, centerY, endX, endY, paint);

        //MINUTE ARROW
        // 30 - to make 0min align on 12 hours (on 6 without it)
        degreeAngle = (360/60)*(min + 30);
        // "-" - to make arrow go clockwise (counter-cw by default)
        radianAngle = - Math.toRadians(degreeAngle);
        endX = centerX + (int)(MIN_ARROW_HEIGHT*Math.sin(radianAngle));
        endY = centerY + (int)(MIN_ARROW_HEIGHT*Math.cos(radianAngle));
        paint.setStrokeWidth(MIN_ARROW_WIDTH);
        canvas.drawLine(centerX, centerY, endX, endY, paint);

        //SECOND ARROW
        // 30 - to make 0sec align on 12 hours (on 6 without it)
        degreeAngle = (360/60)*(sec + 30);
        // "-" - to make arrow go clockwise (counter-cw by default)
        radianAngle = - Math.toRadians(degreeAngle);
        endX = centerX + (int)(SEC_ARROW_HEIGHT*Math.sin(radianAngle));
        endY = centerY + (int)(SEC_ARROW_HEIGHT*Math.cos(radianAngle));
        paint.setStrokeWidth(SEC_ARROW_WIDTH);
        canvas.drawLine(centerX, centerY, endX, endY, paint);

        Log.d("updateView", "sec = " + sec);
        invalidate();
    }

    Handler handler = new Handler(Looper.getMainLooper());
    Runnable updateClockRunnable = new Runnable(){
        public void run(){
            invalidate();
            handler.postDelayed(this, 1000); // invalidate every second
        }
    };

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        widthSize = MeasureSpec.getSize(widthMeasureSpec);
        heightSize = MeasureSpec.getSize(heightMeasureSpec);

        setMeasuredDimension(widthSize, heightSize);
    }
}
