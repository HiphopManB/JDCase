package fragmen.bwei.com.jdcase.model;

import java.util.HashMap;

import fragmen.bwei.com.jdcase.bean.SearchBean;
import fragmen.bwei.com.jdcase.model.IModel.ISearchModel;
import fragmen.bwei.com.jdcase.net.HttpUtilsRxjava;
import fragmen.bwei.com.jdcase.net.OnNetListener;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by kang on 2017/12/14.
 */

public class SearchModel implements ISearchModel {
    @Override
    public void searchShow(final OnNetListener<SearchBean> onNetListener, String keywords) {
        HashMap<String, String> map = new HashMap<>();
        map.put("keywords",keywords);
        map.put("source","Android");
        Observable<SearchBean> dataBeanObservable =
                HttpUtilsRxjava.getApi().searchList(map);
        dataBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SearchBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                    e.getMessage();
                    }

                    @Override
                    public void onNext(SearchBean dataBean) {
                        onNetListener.OnSuccess(dataBean);
                    }
                });
    }
}
