package fragmen.bwei.com.jdcase.model.IModel;

import fragmen.bwei.com.jdcase.bean.Basebean;
import fragmen.bwei.com.jdcase.net.OnNetListener;

/**
 * Created by kang on 2017/11/9.
 */

public interface IRegisterModel {
    public void register(String account, String pwd, OnNetListener<Basebean> onNetListener);


}
