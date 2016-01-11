package im.hua.whiteboard.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by hua on 16/1/8.
 */
public class BezierView extends View {
    private Path mPath;
    private Paint mPaint;

    public BezierView(Context context) {
        super(context);
        init(context);
    }

    public BezierView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BezierView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
//        mPaint.setDither(true);
        mPaint.setColor(0xFFFF0000);
        mPaint.setStyle(Paint.Style.STROKE);
//        mPaint.setStrokeJoin(Paint.Join.ROUND);
//        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(12);

        mPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPath.moveTo(100, 100);
        mPath.cubicTo(800, 100, 100, 800, 800, 800);
        // 一共四个点，(100, 100)和(800, 800)分别为起点和终点,(800, 100)和(100, 800)为操作点

        canvas.drawPath(mPath, mPaint);
    }
}
