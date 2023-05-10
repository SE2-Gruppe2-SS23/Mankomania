package com.grimschitz.mankomania;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

public class RouletteWheelView extends View {
    private Paint paint;
    private RectF rectF;
    private int result = -1;

    private MediaPlayer mediaPlayer;

    public RouletteWheelView(Context context) {
        super(context);
        init();
    }

    public RouletteWheelView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rectF = new RectF();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();
        int radius = Math.min(width, height) / 2;
        int centerX = width / 2;
        int centerY = height / 2;

        float sweepAngle = 360f / 37; // 37 slots (0 to 36)
        float startAngle = 270f; // Start from the top-middle

        for (int i = 0; i < 37; i++) {
            paint.setStyle(Paint.Style.FILL);
            if (i == 0) {
                paint.setColor(Color.GREEN);
            } else if (i % 2 == 0) {
                paint.setColor(Color.RED);
            } else {
                paint.setColor(Color.BLACK);
            }

            rectF.set(centerX - radius, centerY - radius, centerX + radius, centerY + radius);
            canvas.drawArc(rectF, startAngle, sweepAngle, true, paint);

            paint.setColor(Color.WHITE);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(2);
            canvas.drawArc(rectF, startAngle, sweepAngle, true, paint);

            paint.setColor(Color.WHITE);
            paint.setStyle(Paint.Style.FILL);
            paint.setTextSize(radius / 16);

            String numberText = String.valueOf(i);
            float textWidth = paint.measureText(numberText);

            float angleInRadians = (float) Math.toRadians(startAngle + (sweepAngle / 2));
            float textX = centerX + (float) ((radius * 0.85) * Math.cos(angleInRadians) - (textWidth / 2));
            float textY = centerY + (float) ((radius * 0.85) * Math.sin(angleInRadians) + (paint.getTextSize() / 2));

            canvas.drawText(numberText, textX, textY, paint);
            
            startAngle += sweepAngle;
        }

        if (result >= 0) {
            String resultText = String.valueOf(result);
            float textWidth = paint.measureText(resultText);

        }
    }

    public void setResult(int result) {
        this.result = result;
        invalidate();
    }

    public int getResult() {
        return result;
    }

    public void spin(int result){
        setRotation(0);

        int fullRotations = (int) (Math.random() * 4) + 4; // 4 to 7 full rotations
        float extraRotation = calculateExtraRotation(result);
        float totalRotation = (fullRotations * 360) + extraRotation+5.0f;

        mediaPlayer = MediaPlayer.create(this.getContext(),R.raw.wheel_spin);
        mediaPlayer.start();
        ObjectAnimator animator = ObjectAnimator.ofFloat(this, "rotation", totalRotation);
        animator.setDuration(3000);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.start();

    }

    private float calculateExtraRotation(int result) {
        float sweepAngle = 360f / 37;
        int reversedResult = 36 - result;
        float extraRotation = sweepAngle * reversedResult;
        return extraRotation;
    }

    public void stopSpin(){
        clearAnimation();
    }
}
