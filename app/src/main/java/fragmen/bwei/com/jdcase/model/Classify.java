package fragmen.bwei.com.jdcase.model;

import fragmen.bwei.com.jdcase.bean.Classify2Bean;
import fragmen.bwei.com.jdcase.bean.ClassifyBean;
import fragmen.bwei.com.jdcase.model.IModel.IClassifyModel;
import fragmen.bwei.com.jdcase.net.HttpUtilsRxjava;
import fragmen.bwei.com.jdcase.net.OnNetListener;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by kang on 2017/12/9.
 */

public class Classify implements IClassifyModel{

    private Observable<Classify2Bean> getProductCatagory;

    @Override
    public void Classify(final OnNetListener<ClassifyBean> onNetListener) {
        Observable<ClassifyBean> list = HttpUtilsRxjava.getApi().list("getCatagory");
        list.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ClassifyBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.getMessage();
                    }

                    @Override
                    public void onNext(ClassifyBean classifyBean) {
                        onNetListener.OnSuccess(classifyBean);
                    }
                });
    }

    @Override
    public void Classify2(final OnNetListener<Classify2Bean> onNetListener, String uid) {

        getProductCatagory = HttpUtilsRxjava.getApi().list2( uid);
        getProductCatagory.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Classify2Bean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                                    e.getMessage();
                    }

                    @Override
                    public void onNext(Classify2Bean classify2Bean) {
                        onNetListener.OnSuccess(classify2Bean);
                    }
                });
    }
}
