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
import fragmen.bwei.com.jdcase.bean.SearchBean;

/**
 * Created by kang on 2017/12/14.
 */

public class SearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<SearchBean.DataBean> list;

    public SearchAdapter(Context context, List<SearchBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.search, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        SearchBean.DataBean dataBean = list.get(position);
        MyViewHolder holder1 = (MyViewHolder) holder;
        holder1.fresco.setImageURI(dataBean.getImages());
        holder1.title.setText(dataBean.getTitle());
        holder1.price.setText(dataBean.getPrice());
}

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView fresco;
        private final TextView title;
        private final TextView price;

        public MyViewHolder(View itemView) {
            super(itemView);
            fresco = itemView.findViewById(R.id.fresco);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);

        }
    }
}
