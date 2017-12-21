package fragmen.bwei.com.jdcase.Persenter;

import java.util.List;

import fragmen.bwei.com.jdcase.SearchActivity;
import fragmen.bwei.com.jdcase.bean.SearchBean;
import fragmen.bwei.com.jdcase.model.IModel.ISearchModel;
import fragmen.bwei.com.jdcase.model.SearchModel;
import fragmen.bwei.com.jdcase.net.OnNetListener;
import fragmen.bwei.com.jdcase.view.Iview.ISearchActivity;

/**
 * Created by kang on 2017/12/14.
 */

public class SearchPresenter {
     private ISearchActivity iSearchActivity;
    private final ISearchModel searchModel;

    public SearchPresenter(ISearchActivity iSearchActivity){
        this.iSearchActivity = iSearchActivity;
        searchModel = new SearchModel();
    }
    public void showSearch(String key){
        searchModel.searchShow(new OnNetListener<SearchBean>() {
            @Override
            public void OnFailure(Exception e) {

            }

            @Override
            public void OnSuccess(SearchBean dataBean) {
                List<SearchBean.DataBean> data = dataBean.getData();
                iSearchActivity.showSearch(data);
            }
        },key);
    }
}
