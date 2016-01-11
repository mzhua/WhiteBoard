package im.hua.whiteboard.library.rva;

import android.content.Context;
import android.view.View;

import im.hua.whiteboard.library.rva.bean.WBBean;
import im.hua.whiteboard.library.rva.vh.WBShapeVH;

/**
 * Created by hua on 16/1/11.
 */
public class WhiteBoardRVAdapter extends BaseRVAdapter<WBBean> {

    public WhiteBoardRVAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseVH<WBBean> createViewHolder(View itemView, int viewType) {
        BaseVH baseVH = null;
        if (viewType == WBBean.LAYOUT_SHAPE) {
            baseVH = new WBShapeVH(itemView);
        }
        return baseVH;
    }

}
