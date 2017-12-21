package fragmen.bwei.com.jdcase.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import fragmen.bwei.com.jdcase.R;
import fragmen.bwei.com.jdcase.bean.ClassifyBean;
import fragmen.bwei.com.jdcase.net.MyApi;

/**
 * Created by kang on 2017/12/9.
 */

public class ClassifyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<ClassifyBean.DataBean> list;
    private OnclickListener onclickListener;

    public ClassifyAdapter(Context context, List<ClassifyBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }
//1定义一个接口
    public interface OnclickListener{
        void OnItemclick(String cid);
    }
    //2定义一个方法
    public  void OnItemListener(OnclickListener onclickListener){
        this.onclickListener = onclickListener;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lift, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ClassifyBean.DataBean dataBean = list.get(position);
        MyViewHolder holder1 = (MyViewHolder) holder;
        holder1.tv.setText(dataBean.getName());
        final int cid = dataBean.getCid();
        if(dataBean.isCheck()){
            holder1.tv.setBackgroundColor(Color.parseColor("#F5F5F5"));
            holder1.tv.setTextColor(Color.parseColor("#ff3660"));
        }else{
            holder1.tv.setBackgroundColor(Color.parseColor("#ffffff"));
            holder1.tv.setTextColor(Color.parseColor("#000000"));
        }

        holder1.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclickListener.OnItemclick(cid+"");
                ClassifyAdapter.this.press(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{

        private final LinearLayout ll;
        private final TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            ll = (LinearLayout) itemView.findViewById(R.id.ll);
            tv = (TextView) itemView.findViewById(R.id.lift_tv);
        }
    }
    public void press(int position){

        for (int i = 0; i < list.size(); i++) {
            ClassifyBean.DataBean dataBean = list.get(i);
            dataBean.setCheck(false);
        }
        ClassifyBean.DataBean dataBean = list.get(position);
        dataBean.setCheck(true);
        notifyDataSetChanged();
    }
            }
