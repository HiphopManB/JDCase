package fragmen.bwei.com.jdcase.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import fragmen.bwei.com.jdcase.Adapter.NavAdapter;
import fragmen.bwei.com.jdcase.Persenter.INavPresenter;
import fragmen.bwei.com.jdcase.R;
import fragmen.bwei.com.jdcase.bean.ClassifyBean;
import fragmen.bwei.com.jdcase.view.Iview.INavActivity;

/**
 * Created by kang on 2017/12/14.
 */

public class fragment_nav1 extends Fragment implements INavActivity {

    private RecyclerView rcv;
    private INavPresenter iNavPresenter;
    private List<ClassifyBean.DataBean> list2 = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_nav1, null);
        rcv = view.findViewById(R.id.rcv);
        iNavPresenter = new INavPresenter(this);
        iNavPresenter.getshowNav();
        return view;
    }

    @Override
    public void showNav(List<ClassifyBean.DataBean> list) {

        for (int i = 0; i < 10; i++) {
            ClassifyBean.DataBean dataBean = list.get(i);
            list2.add(dataBean);
        }

        NavAdapter navAdapter = new NavAdapter(getActivity(),list2);
        rcv.setAdapter(navAdapter);
        rcv.setLayoutManager(new GridLayoutManager(getActivity(),5));
    }
}
