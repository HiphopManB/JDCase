package fragmen.bwei.com.jdcase.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import fragmen.bwei.com.jdcase.R;
import fragmen.bwei.com.jdcase.bean.ClassifyBean;

/**
 * Created by kang on 2017/12/14.
 */

public class NavAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<ClassifyBean.DataBean> list;

    public NavAdapter(Context context, List<ClassifyBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder holder1 = (MyViewHolder) holder;
        ClassifyBean.DataBean dataBean = list.get(position);
        holder1.tv.setText(dataBean.getName());
        holder1.sdv_nav.setImageURI(dataBean.getIcon());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView sdv_nav;

        private final TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            sdv_nav = itemView.findViewById(R.id.sdv_nav);
            tv = itemView.findViewById(R.id.tv_nav);

        }
    }
}
