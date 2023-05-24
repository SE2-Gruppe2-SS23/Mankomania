package com.grimschitz.mankomania.BoardScreen;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class SquareGridView extends View {

    private static final int GRID_PADDING = 50;

    private int numColumns;
    private int numRows;
    private int cellSize;

    private Paint linePaint;
    private Paint textPaint;

    public SquareGridView(Context context) {
        super(context);
        init();
    }

    public SquareGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SquareGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        numColumns = 10;
        numRows = 16;
        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setColor(Color.BLACK);
        linePaint.setStrokeWidth(2);
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(24);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int availableWidth = width - (2 * GRID_PADDING);
        int availableHeight = height - (2 * GRID_PADDING);
        cellSize = Math.min(availableWidth / numColumns, availableHeight / numRows);
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int left = GRID_PADDING;
        int top = GRID_PADDING;
        int right = left + (numColumns * cellSize);
        int bottom = top + (numRows * cellSize);
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                int cellId = (i * numColumns) + j;
                int x = left + (j * cellSize) + (cellSize / 2);
                int y = top + (i * cellSize) + (cellSize / 2);
                canvas.drawText(Integer.toString(cellId), x, y, textPaint);
            }
        }
        for (int i = 0; i <= numRows; i++) {
            canvas.drawLine(left, top + (i * cellSize), right, top + (i * cellSize), linePaint);
        }
        for (int i = 0; i <= numColumns; i++) {
            canvas.drawLine(left + (i * cellSize), top, left + (i * cellSize), bottom, linePaint);
        }
    }

    public int[] getCellCoordinates(int cellId) {
        int column = cellId % numColumns;
        int row = cellId / numColumns;
        int x = GRID_PADDING + (column * cellSize) + (cellSize / 2);
        int y = GRID_PADDING + (row * cellSize) + (cellSize / 2);
        return new int[]{x-60, y-50};
    }
}

