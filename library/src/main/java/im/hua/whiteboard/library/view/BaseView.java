package im.hua.whiteboard.library.view;

import android.graphics.Canvas;

/**
 * Created by hua on 16/1/11.
 */
public abstract class BaseView {
    public static final float TOUCH_TOLERANCE = 4;

    protected OnInvalidate mOnInvalidate;

    public void onTouchStart(float x, float y) {
    }

    public void onTouchMove(float x, float y) {
    }

    public void onTouchUp(float x, float y) {
    }

    public void onDraw(Canvas canvas) {
    }

    public void setOnInvalidate(OnInvalidate onInvalidate) {
        mOnInvalidate = onInvalidate;
    }

    public interface OnInvalidate {
        void baseViewInvalidate();
    }
}
