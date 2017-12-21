package fragmen.bwei.com.jdcase.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fragmen.bwei.com.jdcase.bean.BaseBeanTwo;
import fragmen.bwei.com.jdcase.bean.GoodsCarBean;
import fragmen.bwei.com.jdcase.model.IModel.IAddcar;
import fragmen.bwei.com.jdcase.net.HttpUtilsRxjava;
import fragmen.bwei.com.jdcase.net.OnNetListener;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by kang on 2017/12/18.
 */

public class IaddCarG implements IAddcar {
    @Override
    public void addGoods(String uid, String pid, final OnNetListener<BaseBeanTwo> onNetListener) {
        HashMap<String, String> Map = new HashMap<>();
        Map.put("uid",uid);
        Map.put("pid",pid);
        Map.put("source","android");
        Observable<BaseBeanTwo> two = HttpUtilsRxjava.getApi().Login_re(Map);
        two.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BaseBeanTwo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                            e.getMessage();
                    }

                    @Override
                        public void onNext(BaseBeanTwo baseBeanTwo) {
                    onNetListener.OnSuccess(baseBeanTwo);
                    }
                });

    }

    @Override
    public void showCar(String uid, final OnNetListener<GoodsCarBean> onNetListener) {
        Observable<GoodsCarBean> goods = HttpUtilsRxjava.getApi().goodsBean(uid);
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
