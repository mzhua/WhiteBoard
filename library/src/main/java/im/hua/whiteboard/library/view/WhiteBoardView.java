package im.hua.whiteboard.library.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import static im.hua.whiteboard.library.view.WhiteBoardView.SHAPE.FreePath;

/**
 * TODO: document your custom view class.
 */
public class WhiteBoardView extends View {
    private static final float MINP = 0.25f;
    private static final float MAXP = 0.75f;

    private Paint mPaint;
    private Paint mBitmapPaint;
    private Bitmap mBitmap;
    private Canvas mCanvas;

    private int mBackgroundColor = 0xFFAAAAAA;

    private BaseView mBaseView;

    private SHAPE mShape = FreePath;

    /**
     * draw shape
     */
    public enum SHAPE {
        FreePath,Line,Circle,Rectangle,Arc,Triangle
    }

    public WhiteBoardView(Context context) {
        super(context);
        init(context);
    }

    public WhiteBoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public WhiteBoardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setColor(0xFFFF0000);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(5);

        mBitmapPaint = new Paint(Paint.DITHER_FLAG);

        setBackgroundColor(getResources().getColor(android.R.color.white));
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(mBackgroundColor);

        canvas.drawBitmap(mBitmap, 0, 0, mBitmapPaint);

        if (mBaseView != null) {
            mBaseView.onDraw(canvas);
        }

    }

    private void touchStart(float x, float y) {
        switch (mShape) {
            case FreePath:
                mBaseView = new FreePathView(mCanvas);
                break;
        }

        mBaseView.onTouchStart(x, y);
    }

    private void touchMove(float x, float y) {
        mBaseView.onTouchMove(x, y);
    }

    private void touchUp(float x, float y) {
        mBaseView.onTouchUp(x, y);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                touchStart(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                touchMove(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                touchUp(x, y);
                invalidate();
                break;
        }
        return true;
    }

    /**
     * set the shape that is going to draw
     * @param shape
     */
    public void setShape(SHAPE shape) {
        mShape = shape;
    }

    /**
     * set the background of canvas
     * @param color
     */
    public void setBackgroundColor(@ColorInt int color) {
        mBackgroundColor = color;
    }

    public void clear() {
        mBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
        invalidate();
    }
}
