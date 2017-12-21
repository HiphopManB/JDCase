package fragmen.bwei.com.jdcase.Adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import fragmen.bwei.com.jdcase.R;
import fragmen.bwei.com.jdcase.bean.Classify2Bean;

/**
 * Created by kang on 2017/12/13.
 */

public class Classify3Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Classify2Bean.DataBean> list;
    private Classify2Adapter classify2Adapter;

    public Classify3Adapter(Context context, List<Classify2Bean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.group_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder holder1 = (MyViewHolder) holder;
        Classify2Bean.DataBean dataBean = list.get(position);
        holder1.tv.setText(dataBean.getName());
        holder1.rcv.setLayoutManager(new GridLayoutManager(context,3));
        List<Classify2Bean.DataBean.ListBean> list = dataBean.getList();
        classify2Adapter = new Classify2Adapter(context,list);
        holder1.rcv.setAdapter(classify2Adapter);
    }

    @Override
    public int getItemCount() {
        if (list == null){
            return 0;
        }
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv;
        private  RecyclerView rcv;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.group_tv);
            rcv = itemView.findViewById(R.id.rcv3);
        }
    }
}
