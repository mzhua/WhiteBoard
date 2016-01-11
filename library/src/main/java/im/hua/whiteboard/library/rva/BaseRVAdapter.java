package im.hua.whiteboard.library.rva;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hua on 16/1/11.
 */
public abstract class BaseRVAdapter<Bean extends BaseRVBean> extends RecyclerView.Adapter<BaseVH<Bean>> {
    private LayoutInflater mInflater;
    private List<Bean> mDataList;

    protected BaseRVAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    public void setDataList(List<Bean> dataList) {
        if (mDataList == null) {
            mDataList = new ArrayList<>();
        } else {
            mDataList.clear();
        }
        if (dataList != null) {
            mDataList.addAll(dataList);
            notifyDataSetChanged();
        }
    }

    public Bean getBean(int position) {
        if (mDataList != null && position < mDataList.size()) {
            return mDataList.get(position);
        } else {
            return null;
        }
    }

    public void addBean(Bean bean) {
        if (mDataList == null) {
            mDataList = new ArrayList<>();
        }
        mDataList.add(bean);
        notifyItemInserted(mDataList.size() - 1);
    }

    @Override
    public BaseVH<Bean> onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(viewType, parent, false);
        return createViewHolder(itemView,viewType);
    }

    public abstract BaseVH<Bean> createViewHolder(View itemView, int viewType);

    @Override
    public void onBindViewHolder(BaseVH holder, int position) {
        holder.bind(getBean(position));
    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mDataList == null ? -1 : mDataList.get(position).getItemLayout();
    }
}
