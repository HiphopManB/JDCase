package fragmen.bwei.com.jdcase.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import fragmen.bwei.com.jdcase.Adapter.Classify2Adapter;
import fragmen.bwei.com.jdcase.Adapter.ClassifyAdapter;
import fragmen.bwei.com.jdcase.Mytitle2;
import fragmen.bwei.com.jdcase.Persenter.ClassifyPresenter;
import fragmen.bwei.com.jdcase.R;
import fragmen.bwei.com.jdcase.bean.Classify2Bean;
import fragmen.bwei.com.jdcase.bean.ClassifyBean;
import fragmen.bwei.com.jdcase.model.Classify;
import fragmen.bwei.com.jdcase.view.Iview.IClassify;

/**
 * Created by kang on 2017/11/10.
 */

public class Fragment02 extends Fragment implements IClassify{

    private RecyclerView recyclerView;
    private ClassifyPresenter classifyPresenter;
    private RecyclerView recyclerView1;
    List<Classify2Bean.DataBean.ListBean> list=new ArrayList<>();
    private Mytitle2 classify;
    private ClassifyAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        classifyPresenter = new ClassifyPresenter(this);
        //加载布局
        View view = inflater.inflate(R.layout.fragment_item02, null);
        classify = view.findViewById(R.id.mytClassify);
        //id
        recyclerView = (RecyclerView) view.findViewById(R.id.rcv);
        recyclerView1 = view.findViewById(R.id.rcv2);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView1.setLayoutManager(new GridLayoutManager(getActivity(),3));
        classifyPresenter.getClassify();
        return view;
    }

    @Override
    public void show(List<ClassifyBean.DataBean> list) {
        adapter = new ClassifyAdapter(getContext(),list);
        recyclerView.setAdapter(adapter);
        adapter.OnItemListener(new ClassifyAdapter.OnclickListener() {
            @Override
            public void OnItemclick(String cid) {
                Toast.makeText(getContext(), cid+"", Toast.LENGTH_SHORT).show();
                classifyPresenter.getClassify2(cid);
            }
        });
    }

    @Override
    public void show2(List<Classify2Bean.DataBean> list2) {
        list.clear();
         for(int i=0;i<list2.size();i++)
         {
             List<Classify2Bean.DataBean.ListBean> classify2Bean=list2.get(i).getList();
             for(int j=0;j<classify2Bean.size();j++)
             {
                 list.add(classify2Bean.get(j));
             }
         }
        Classify2Adapter adapter2 = new Classify2Adapter(getContext(),list);
        recyclerView1.setAdapter(adapter2);
    }


}
