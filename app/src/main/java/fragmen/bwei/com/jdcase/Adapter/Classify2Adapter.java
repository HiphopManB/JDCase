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
import fragmen.bwei.com.jdcase.bean.Classify2Bean;

/**
 * Created by kang on 2017/12/13.
 */

public class Classify2Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private  List<Classify2Bean.DataBean.ListBean> list2;


    public Classify2Adapter(Context context, List<Classify2Bean.DataBean.ListBean> list2) {
        this.context = context;
        this.list2 = list2;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

           View view = LayoutInflater.from(context).inflate(R.layout.child_item, parent, false);

           return new MyChildViewHolder(view);


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

             MyChildViewHolder holder1 = (MyChildViewHolder) holder;
             Classify2Bean.DataBean.ListBean listBean = list2.get(position);
             holder1.eat_tv.setText(listBean.getName());
             holder1.sdv.setImageURI(listBean.getIcon());


    }

    @Override
    public int getItemCount() {
        return list2.size();
    }

        @Override
        public int getItemViewType(int position) {
            Classify2Bean.DataBean.ListBean listBean = list2.get(position);
            String icon1 = listBean.getIcon();
            //判断是否有图片
            if(icon1 == null){
                return 0;
            }else {
                return 1;
            }

        }

        class MyGroupViewHolder extends RecyclerView.ViewHolder{

        private final TextView tv;

        public MyGroupViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.group_tv);

        }
    }
    class MyChildViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView sdv;
        private final TextView eat_tv;

        public MyChildViewHolder(View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.sdv);
            eat_tv = itemView.findViewById(R.id.eat_tv);
        }
    }
}
