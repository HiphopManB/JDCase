package fragmen.bwei.com.jdcase.Persenter;

import java.util.ArrayList;
import java.util.List;

import fragmen.bwei.com.jdcase.bean.GoodsCarBean;
import fragmen.bwei.com.jdcase.model.IaddCarG;
import fragmen.bwei.com.jdcase.net.OnNetListener;
import fragmen.bwei.com.jdcase.view.Iview.IGoodsActivity;

/**
 * Created by kang on 2017/12/18.
 */
//查询购物车
public class GoodsPresenter {
private IGoodsActivity iGoodsActivity;
    private final IaddCarG iaddCarG;

    public  GoodsPresenter(IGoodsActivity iGoodsActivity){
        this.iGoodsActivity  = iGoodsActivity;
        iaddCarG = new IaddCarG();
    }
    public void getCar(String uid){
        iaddCarG.showCar(uid, new OnNetListener<GoodsCarBean>() {
            @Override
            public void OnFailure(Exception e) {

            }

            @Override
            public void OnSuccess(GoodsCarBean goodsCarBean) {
                List<GoodsCarBean.DataBean> data = goodsCarBean.getData();
                List<List<GoodsCarBean.DataBean.ListBean>> childlist = new ArrayList<>();
                for (int i = 0; i < data.size(); i++) {
                    List<GoodsCarBean.DataBean.ListBean> list = data.get(i).getList();
                    childlist.add(list);
                }
                iGoodsActivity.getShowCar(data,childlist);
            }
        });
    }
}
