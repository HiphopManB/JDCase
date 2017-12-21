package fragmen.bwei.com.jdcase.view.Iview;

import java.util.List;

import fragmen.bwei.com.jdcase.bean.Classify2Bean;
import fragmen.bwei.com.jdcase.bean.ClassifyBean;

/**
 * Created by kang on 2017/12/9.
 */

public interface IClassify {
    public void show(List<ClassifyBean.DataBean> list);
    void show2(List<Classify2Bean.DataBean> list2);
}
