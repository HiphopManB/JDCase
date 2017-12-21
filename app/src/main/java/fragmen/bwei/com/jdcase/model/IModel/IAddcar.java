package fragmen.bwei.com.jdcase.model.IModel;

import fragmen.bwei.com.jdcase.bean.BaseBeanTwo;
import fragmen.bwei.com.jdcase.bean.GoodsCarBean;
import fragmen.bwei.com.jdcase.net.OnNetListener;

/**
 * Created by kang on 2017/12/18.
 */

public interface IAddcar {
    void addGoods(String uid, String pid,OnNetListener<BaseBeanTwo> onNetListener);
    void showCar(String uid, OnNetListener<GoodsCarBean> onNetListener);
}
