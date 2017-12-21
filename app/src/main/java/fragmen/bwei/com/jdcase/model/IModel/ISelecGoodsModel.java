package fragmen.bwei.com.jdcase.model.IModel;

import fragmen.bwei.com.jdcase.bean.GoodsCarBean;
import fragmen.bwei.com.jdcase.net.OnNetListener;

/**
 * Created by kang on 2017/12/18.
 */

public interface ISelecGoodsModel {
    void getGoods(String uid, OnNetListener<GoodsCarBean> onNetListener);
}
