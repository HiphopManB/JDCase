package fragmen.bwei.com.jdcase.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import fragmen.bwei.com.jdcase.Banner;
import fragmen.bwei.com.jdcase.R;
import fragmen.bwei.com.jdcase.bean.BannerBean;
import fragmen.bwei.com.jdcase.bean.SearchBean;

/**
 * Created by kang on 2017/12/14.
 */

public class RemAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<BannerBean.TuijianBean.ListBean> list;
    private OnclickListener onclickListener;
    private String pid;

    public RemAdapter2(Context context, List<BannerBean.TuijianBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }
   //定义一个接口
public interface OnclickListener{
        void OnItemClick(String str);
    }
    //定义一个方法
    public void OnClickItem(OnclickListener onclickListener){
        this.onclickListener = onclickListener;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view1 = LayoutInflater.from(context).inflate(R.layout.rem_item,parent,false);
        return new MyViewHolder(view1);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final BannerBean.TuijianBean.ListBean listBean = list.get(position);
        MyViewHolder holder1 = (MyViewHolder) holder;
        holder1.fresco.setImageURI(listBean.getImages());
        holder1.title.setText(listBean.getTitle());
        holder1.price.setText(listBean.getPrice());

        holder1.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pid = listBean.getPid();
                onclickListener.OnItemClick(pid);
            }
        });
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
