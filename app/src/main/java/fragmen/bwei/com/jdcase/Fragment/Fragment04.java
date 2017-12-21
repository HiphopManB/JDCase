package fragmen.bwei.com.jdcase.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.EventLog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import fragmen.bwei.com.jdcase.Adapter.ExpendAdapter;
import fragmen.bwei.com.jdcase.EventBus.EventPrice;
import fragmen.bwei.com.jdcase.EventBus.MessageEvent;
import fragmen.bwei.com.jdcase.Persenter.GoodsPresenter;
import fragmen.bwei.com.jdcase.R;
import fragmen.bwei.com.jdcase.bean.GoodsCarBean;
import fragmen.bwei.com.jdcase.net.App;
import fragmen.bwei.com.jdcase.view.Iview.IGoodsActivity;

/**
 * Created by kang on 2017/11/10.
 */

public class Fragment04 extends Fragment implements IGoodsActivity {

    private GoodsPresenter goodsPresenter;
    private View view;
    private ExpandableListView mExview;
    private CheckBox mCheckbox2;
    /**
     * 结算(0)
     */
    private TextView mTvNum;
    private ExpendAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item04, null);

        goodsPresenter = new GoodsPresenter(this);
        String uid = App.handle.getString("uid", "");
        goodsPresenter.getCar(uid);
        initView(view);
        EventBus.getDefault().register(this);
        mCheckbox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.changeAllListCbState(mCheckbox2.isChecked());
            }
        });
        return view;
    }

    @Override
    public void getShowCar(List<GoodsCarBean.DataBean> grouplist, List<List<GoodsCarBean.DataBean.ListBean>> childList) {
        adapter = new ExpendAdapter(getContext(), grouplist, childList);
        mExview.setAdapter(adapter);
        mExview.setGroupIndicator(null);
        for (int i = 0; i < grouplist.size(); i++) {
            mExview.expandGroup(i);
        }
    }

    private void initView(View view) {
        mExview = (ExpandableListView) view.findViewById(R.id.exview);
        mCheckbox2 = (CheckBox) view.findViewById(R.id.checkbox2);
        mTvNum = (TextView) view.findViewById(R.id.tv_num);
    }
    @Subscribe
    public void onMessage(MessageEvent messageEvent){
        mCheckbox2.setChecked(messageEvent.isChecked());
    }

    @Subscribe
    public void EventPrice(EventPrice eventPrice){
        mTvNum.setText("结算("+eventPrice.getPrice()+")");
    }
}
