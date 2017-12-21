package fragmen.bwei.com.jdcase.model.IModel;

import fragmen.bwei.com.jdcase.bean.BaseBeanTwo;
import fragmen.bwei.com.jdcase.bean.LoginBean;
import fragmen.bwei.com.jdcase.net.OnNetListener;

/**
 * Created by kang on 2017/11/8.
 */

public interface ILoginModel {

    public  void login(String phone,String pass,OnNetListener<LoginBean> onNetListener);
}
