package im.hua.whiteboard.library.rva;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by hua on 16/1/11.
 */
public abstract class BaseVH<Bean extends BaseRVBean> extends RecyclerView.ViewHolder {
    public BaseVH(View itemView) {
        super(itemView);
    }

    public abstract void bind(Bean bean);
}
