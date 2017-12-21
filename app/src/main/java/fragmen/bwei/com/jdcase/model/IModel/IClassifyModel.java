package fragmen.bwei.com.jdcase.model.IModel;

import fragmen.bwei.com.jdcase.bean.Classify2Bean;
import fragmen.bwei.com.jdcase.bean.ClassifyBean;
import fragmen.bwei.com.jdcase.net.OnNetListener;

/**
 * Created by kang on 2017/12/9.
 */

public interface IClassifyModel {
    public void Classify(OnNetListener<ClassifyBean> onNetListener);
    public void Classify2(OnNetListener<Classify2Bean> onNetListener,String cid);

}
