package fragmen.bwei.com.jdcase.model.IModel;

import fragmen.bwei.com.jdcase.bean.BannerBean;
import fragmen.bwei.com.jdcase.bean.RemBean;
import fragmen.bwei.com.jdcase.net.OnNetListener;

/**
 * Created by kang on 2017/12/14.
 */

public interface IFirstPageModel {
        void getShow(OnNetListener<BannerBean> onNetListener);
        void getRem(OnNetListener<RemBean> onNetListener, String pid);
}
