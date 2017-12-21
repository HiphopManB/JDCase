package fragmen.bwei.com.jdcase.model.IModel;

import fragmen.bwei.com.jdcase.bean.SearchBean;
import fragmen.bwei.com.jdcase.net.OnNetListener;

/**
 * Created by kang on 2017/12/14.
 */

public interface ISearchModel {
    void searchShow(OnNetListener<SearchBean> onNetListener,String keywords);
}
