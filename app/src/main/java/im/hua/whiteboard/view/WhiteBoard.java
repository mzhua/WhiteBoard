package im.hua.whiteboard.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

/**
 * TODO: document your custom view class.
 */
public class WhiteBoard extends View {
    private Path mPath;
    private Canvas mCanvas;
    private Bitmap mBitmap;
    private Paint mPaint;

    public WhiteBoard(Context context) {
        super(context);
        init(context);
    }

    public WhiteBoard(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public WhiteBoard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public WhiteBoard(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        mPath = new Path();

        mPaint = new Paint();
        mPaint.setColor(getResources().getColor(android.R.color.holo_red_dark));
        mPaint.setStrokeWidth(5);

        WindowManager manager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        Point point = new Point();
        manager.getDefaultDisplay().getSize(point);

        mBitmap = Bitmap.createBitmap(point.x,point.y, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("WhiteBoard", "draw");
        canvas.drawPath(mPath,mPaint);
    }

    private Point mStartPoint = new Point();

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mStartPoint.set((int)event.getX(),(int)event.getY());
                mPath.moveTo(event.getX(),event.getY());
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(event.getX(),event.getY());
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.onTouchEvent(event);
    }
}
