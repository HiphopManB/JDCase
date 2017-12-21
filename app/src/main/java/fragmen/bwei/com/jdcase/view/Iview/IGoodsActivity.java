package fragmen.bwei.com.jdcase.view.Iview;

import java.util.List;

import fragmen.bwei.com.jdcase.bean.GoodsCarBean;

/**
 * Created by kang on 2017/12/18.
 */

public interface IGoodsActivity {
    void getShowCar(List<GoodsCarBean.DataBean> grouplist,List<List<GoodsCarBean.DataBean.ListBean>> childList);
}
