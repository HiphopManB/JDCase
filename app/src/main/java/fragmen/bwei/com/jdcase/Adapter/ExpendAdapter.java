package fragmen.bwei.com.jdcase.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import org.greenrobot.eventbus.EventBus;

import java.util.List;

import fragmen.bwei.com.jdcase.EventBus.EventPrice;
import fragmen.bwei.com.jdcase.EventBus.MessageEvent;
import fragmen.bwei.com.jdcase.R;
import fragmen.bwei.com.jdcase.bean.GoodsCarBean;

/**
 * Created by kang on 2017/12/18.
 */

public class ExpendAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<GoodsCarBean.DataBean> Grouplsit;
    private List<List<GoodsCarBean.DataBean.ListBean>> childList;
    private final LayoutInflater inflater;

    public ExpendAdapter(Context context, List<GoodsCarBean.DataBean> grouplsit, List<List<GoodsCarBean.DataBean.ListBean>> childList) {
        this.context = context;
        this.Grouplsit = grouplsit;
        this.childList = childList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getGroupCount() {
        return Grouplsit.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return childList.get(i).size();
    }

    @Override
    public Object getGroup(int i) {
        return Grouplsit.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return childList.get(i).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int i, boolean b, View view, ViewGroup viewGroup) {
       final MyGroupHolder holder;
       if(view == null){
           holder = new MyGroupHolder();
            view = inflater.inflate(R.layout.item_group, null);
            holder.cb = view.findViewById(R.id.cb_parent);
            holder.tv_shoper = view.findViewById(R.id.tv_sign);
            view.setTag(holder);
       }else
       {
           holder = (MyGroupHolder) view.getTag();
       }
        //赋值
        final GoodsCarBean.DataBean dataBean = Grouplsit.get(i);
       holder.cb.setChecked(dataBean.isChecked());
       holder.tv_shoper.setText(dataBean.getSellerName());
       //-------------------逻辑
        holder.cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //是否选中
                dataBean.setChecked(holder.cb.isChecked());
                //改变二级列表的状态值
                changeChildCbState(i,holder.cb.isChecked());
                //价钱
                EventBus.getDefault().post(compute());
                //改变全选的状态
                changeAllCbState(isAllGroupCbSelected());
                notifyDataSetChanged();
            }
        });
        return view;
    }



    @Override
    public View getChildView(final int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        final MyChildHolder holder;
        if(view == null){
            holder = new MyChildHolder();
            view = inflater.inflate(R.layout.item_child,null);
            holder.cbchild = view.findViewById(R.id.cb_child);
            holder.im = view.findViewById(R.id.img);
            holder.tv_title = view.findViewById(R.id.tv_tel);
            holder.tv_content = view.findViewById(R.id.tv_content);
            holder.im_delete = view.findViewById(R.id.im_delete);
            holder.im_add = view.findViewById(R.id.im_add);
            holder.tv_num = view.findViewById(R.id.tv_num);

            view.setTag(holder);
        }else
        {
            holder = (MyChildHolder) view.getTag();
        }
        //赋值
        final GoodsCarBean.DataBean.ListBean listBean = childList.get(i).get(i1);
        holder.cbchild.setChecked(listBean.isChecked());
        holder.tv_num.setText(listBean.getNum()+"");
        holder.im.setImageURI(listBean.getImages());
        holder.tv_title.setText(listBean.getTitle());
        holder.tv_content.setText(listBean.getPrice()+"");
        holder.im_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = listBean.getNum();
                if(num == 1){
                    return;
                }
                holder.tv_num.setText(--num+"");
                listBean.setNum(num);
                if(holder.cbchild.isChecked()){
                    EventPrice compute = compute();
                    EventBus.getDefault().post(compute);
                }
            }
        });
        holder.im_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = listBean.getNum();
                holder.tv_num.setText(++num+"");
                listBean.setNum(num);
                if (holder.cbchild.isChecked()){
                    EventPrice compute = compute();
                    EventBus.getDefault().post(compute);
                }
            }
        });
        //逻辑判断-----------------------------
        holder.cbchild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //设置该条目对象里的checked属性值
                listBean.setChecked(holder.cbchild.isChecked());
                EventPrice compute = compute();
                EventBus.getDefault().post(compute);
                if(holder.cbchild.isChecked()){
                    //如果当前是选中状态
                    if (isChildSelectable(i)) {
                        //改变一级列表的状态
                        changGroupCbState(i,true);
                        //设置全选的状态
                        changeAllCbState(isAllGroupCbSelected());
                    }
                }else{
                    //改变一级列表的状态
                    changGroupCbState(i,false);
                    //设置全选的状态
                    changeAllCbState(isAllGroupCbSelected());
                }
                notifyDataSetChanged();
            }
        });
        return view;
    }



    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }


    //以及列表
    class MyGroupHolder{
        CheckBox cb;
        TextView tv_shoper;
    }
    //二级列表
    class MyChildHolder{
        CheckBox cbchild;
        SimpleDraweeView im;
        TextView tv_title;
        TextView tv_content;
        ImageView im_delete;
        ImageView im_add;
        TextView tv_num;
    }
    //=-----------------逻辑方法
    //改变二级列表的状态
    private void changeChildCbState(int i, boolean flag) {
        List<GoodsCarBean.DataBean.ListBean> listBeans = childList.get(i);
        for (int j = 0; j < listBeans.size(); j++) {
            GoodsCarBean.DataBean.ListBean listBean = listBeans.get(j);
            listBean.setChecked(flag);
        }
    }
    //判断二级列表是否全部选中

    public boolean isChildSelectable(int i) {
        List<GoodsCarBean.DataBean.ListBean> listBeans = childList.get(i);
        for (int j = 0; j < listBeans.size(); j++) {
            GoodsCarBean.DataBean.ListBean listBean = listBeans.get(j);
            if(!listBean.isChecked()){
                return false;
            }

        }
        return true;
    }
    //改变一级列表的状态
    private void changGroupCbState(int i, boolean flag) {
        GoodsCarBean.DataBean dataBean = Grouplsit.get(i);
        dataBean.setChecked(flag);
    }
    //改变全选的状态
    public void changeAllCbState(boolean flag) {
        MessageEvent messageEvent = new MessageEvent();
        messageEvent.setChecked(flag);
        EventBus.getDefault().post(messageEvent);
    }
    //判断一级列表是否全部勾选
    private boolean isAllGroupCbSelected() {
        for (int i = 0; i < Grouplsit.size(); i++) {
            GoodsCarBean.DataBean dataBean = Grouplsit.get(i);
            if(!dataBean.isChecked()){
                return false;
            }

        }
        return  true;
    }
    //设置全选
    public void changeAllListCbState(boolean flag) {
        for (int i = 0; i < Grouplsit.size(); i++) {
            changGroupCbState(i, flag);
            changeChildCbState(i, flag);
        }
        EventBus.getDefault().post(compute());
        notifyDataSetChanged();
    }
    //计算总价
    private EventPrice compute(){
        double price = 0;
        int count =0;
        for (int i = 0; i < childList.size(); i++) {
            List<GoodsCarBean.DataBean.ListBean> listBeans = childList.get(i);
            for (int j = 0; j < listBeans.size(); j++) {
                GoodsCarBean.DataBean.ListBean listBean = listBeans.get(j);
                if (listBean.isChecked()){
                    price += listBean.getPrice()*listBean.getNum();
                    count +=listBean.getNum();
                }

            }
        }
        EventPrice eventPrice = new EventPrice();
        eventPrice.setPrice((int) price);
        return eventPrice;

    }


}
