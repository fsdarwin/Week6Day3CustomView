package com.example.week6day3customview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.week6day3customview.R;

public class CustomView extends View {

    int fillColor = 255;
    float left;
    float top;
    float right;
    float bottom;

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomView);
        left = typedArray.getInt(R.styleable.CustomView_left, 200);
        top = typedArray.getInt(R.styleable.CustomView_top, 100);
        right = typedArray.getInt(R.styleable.CustomView_right, 300);
        bottom = typedArray.getInt(R.styleable.CustomView_bottom, 300);
        fillColor = typedArray.getInt(R.styleable.CustomView_fillColor, 0);
        typedArray.recycle();
    }


    @Override
    public void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(fillColor);
        canvas.drawRect(left, top, right,bottom, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int desiredWidth = 500;
        int desiredHeight = 500;

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        System.out.println("WM = " + widthMode);
        System.out.println("WS = " + widthSize);
        System.out.println("HM = " + heightMode);
        System.out.println("HS = " + heightSize);

        int width;
        int height;

        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else if (widthMode == MeasureSpec.AT_MOST) {
            width = Math.min(desiredWidth, widthSize);
        } else {
            width = desiredWidth;
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            height = Math.min(desiredHeight, heightSize);
        } else {
            height = desiredHeight;
        }
        setMeasuredDimension(width, height);
    }
}
