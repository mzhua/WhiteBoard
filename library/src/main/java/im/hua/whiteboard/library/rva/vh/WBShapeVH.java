package im.hua.whiteboard.library.rva.vh;

import android.view.View;

import im.hua.whiteboard.library.databinding.ItemRvWbShapeBinding;
import im.hua.whiteboard.library.rva.BaseVH;
import im.hua.whiteboard.library.rva.bean.WBShapeBean;

/**
 * Created by hua on 16/1/11.
 */
public class WBShapeVH extends BaseVH<WBShapeBean> {
    private ItemRvWbShapeBinding binding;

    public WBShapeVH(View itemView) {
        super(itemView);

        binding = ItemRvWbShapeBinding.bind(itemView);
    }

    @Override
    public void bind(WBShapeBean bean) {
        binding.setShape(bean);
        binding.setHandler(this);
    }

    public void onClick(View view) {
        switch (getAdapterPosition()) {
            case 0:
                //free path
                break;
            case 1:
                //rectangle
                break;
        }
    }
}
