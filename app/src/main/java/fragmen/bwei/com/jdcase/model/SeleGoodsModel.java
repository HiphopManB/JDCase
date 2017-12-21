package fragmen.bwei.com.jdcase.model;

import fragmen.bwei.com.jdcase.bean.GoodsCarBean;
import fragmen.bwei.com.jdcase.model.IModel.ISelecGoodsModel;
import fragmen.bwei.com.jdcase.net.HttpUtilsRxjava;
import fragmen.bwei.com.jdcase.net.OnNetListener;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by kang on 2017/12/18.
 */

public class SeleGoodsModel implements ISelecGoodsModel {
    @Override
    public void getGoods(String uid, final OnNetListener<GoodsCarBean> onNetListener) {
        final Observable<GoodsCarBean> goods =HttpUtilsRxjava.getApi().goodsBean(uid);
        goods.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GoodsCarBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(GoodsCarBean goodsCarBean) {
                            onNetListener.OnSuccess(goodsCarBean);
                    }
                });
    }
}
