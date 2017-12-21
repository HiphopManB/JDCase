package fragmen.bwei.com.jdcase.view.Iview;

import java.util.List;

import fragmen.bwei.com.jdcase.bean.BannerBean;
import fragmen.bwei.com.jdcase.bean.ClassifyBean;
import fragmen.bwei.com.jdcase.bean.RemBean;
import fragmen.bwei.com.jdcase.bean.SearchBean;

/**
 * Created by kang on 2017/12/14.
 */

public interface IFirstPageActivity {
    void showBanner(List<BannerBean.DataBean> list);
    void shoeRem(List<BannerBean.TuijianBean.ListBean> list);


}
