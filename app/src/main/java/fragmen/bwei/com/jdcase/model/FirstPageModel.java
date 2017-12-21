package fragmen.bwei.com.jdcase.model;

import java.util.HashMap;

import fragmen.bwei.com.jdcase.bean.BannerBean;
import fragmen.bwei.com.jdcase.bean.RemBean;
import fragmen.bwei.com.jdcase.model.IModel.IFirstPageModel;
import fragmen.bwei.com.jdcase.net.HttpUtils;
import fragmen.bwei.com.jdcase.net.HttpUtilsRxjava;
import fragmen.bwei.com.jdcase.net.OnNetListener;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by kang on 2017/12/14.
 */

public class FirstPageModel implements IFirstPageModel{
  
    @Override
    public void getShow(final OnNetListener<BannerBean> onNetListener) {
        Observable<BannerBean> banner = HttpUtilsRxjava.getApi().bannerList("getAd");
        banner.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BannerBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                e.getMessage();
                    }

                    @Override
                    public void onNext(BannerBean bannerBean) {
                        onNetListener.OnSuccess(bannerBean);
                    }
                });

    }



    @Override
    public void getRem(final OnNetListener<RemBean> onNetListener, String pid) {
        HashMap<String, String> Map = new HashMap<>();
        Map.put("pid",pid);
        Map.put("resource","Android");
        final Observable<RemBean> rembean = HttpUtilsRxjava.getApi().rembean(Map);
        rembean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<RemBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                         e.getMessage();
                    }

                    @Override
                    public void onNext(RemBean remBean) {
                        onNetListener.OnSuccess(remBean);
                    }
                });
    }
}
