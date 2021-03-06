package com.example.realmthreadapp.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.realmthreadapp.model.Dot;

import io.realm.RealmResults;

public class DotsView extends View {

    // RealmResults will automatically be up to date.
    private RealmResults<Dot> results;

    private Paint circlePaint;
    private float circleRadius;
    private float pixelsPrWidth;
    private float pixelsPrHeight;


    public DotsView(Context context) {
        super(context);
        init();
    }

    public DotsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DotsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        circlePaint.setStyle(Paint.Style.FILL);
        circlePaint.setColor(Color.RED);
        circleRadius = 10;
    }

    public void setRealmResults(RealmResults results) {
        this.results = results;
        invalidate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        pixelsPrWidth = w/100f;
        pixelsPrHeight = h/100f;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (results == null) {
            return;
        }
        canvas.drawColor(Color.TRANSPARENT);
        for (Dot dot : results) {
            circlePaint.setColor(dot.getColor());
            canvas.drawCircle(dot.getX()*pixelsPrWidth, dot.getY()*pixelsPrHeight, circleRadius, circlePaint);
        }
    }
}