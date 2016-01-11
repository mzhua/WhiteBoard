package im.hua.whiteboard.library.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

/**
 * Created by hua on 16/1/11.
 */
public class FreePathView extends BaseView {
    private Canvas mCanvas;
    private float mX, mY;
    private Path mPath;
    private Paint mPaint;

    public FreePathView(Canvas canvas) {
        mCanvas = canvas;
    }

    @Override
    public void onTouchStart(float x, float y) {
        super.onTouchStart(x, y);
        mPath = new Path();

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setColor(0xFFFF0000);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(12);

        mX = x;
        mY = y;

        mPath.reset();
        mPath.moveTo(x,y);
    }

    @Override
    public void onTouchMove(float x, float y) {
        super.onTouchMove(x, y);
        float dx = Math.abs(x - mX);
        float dy = Math.abs(y - mY);

        if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
            mPath.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
            mX = x;
            mY = y;
        }

    }

    @Override
    public void onTouchUp(float x, float y) {
        super.onTouchUp(x, y);
        mPath.lineTo(mX, mY);
        // commit the path to our offscreen
        mCanvas.drawPath(mPath, mPaint);
        // kill this so we don't double draw
        mPath.reset();
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mCanvas.drawPath(mPath, mPaint);
    }
}
