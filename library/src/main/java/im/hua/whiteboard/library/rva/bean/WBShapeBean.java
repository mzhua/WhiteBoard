package im.hua.whiteboard.library.rva.bean;

import android.databinding.ObservableField;

/**
 * Created by hua on 16/1/11.
 */
public class WBShapeBean extends WBBean {

    private ObservableField<String> name = new ObservableField<>();

    @Override
    public int getItemLayout() {
        return WBBean.LAYOUT_SHAPE;
    }

}
