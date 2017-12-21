package fragmen.bwei.com.jdcase.model;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import fragmen.bwei.com.jdcase.bean.BaseBeanTwo;
import fragmen.bwei.com.jdcase.bean.LoginBean;
import fragmen.bwei.com.jdcase.model.IModel.ILoginModel;
import fragmen.bwei.com.jdcase.net.Api;
import fragmen.bwei.com.jdcase.net.HttpUtils;
import fragmen.bwei.com.jdcase.net.HttpUtilsRxjava;
import fragmen.bwei.com.jdcase.net.OnNetListener;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by kang on 2017/11/8.
 */

public class LoginModel extends BaseModel implements ILoginModel{

    @Override
    public void login(String account, String pwd, final OnNetListener<LoginBean> onNetListener) {
        //创建一个map集合
        Map<String,String> params  = new HashMap<>();
        params.put("mobile",account);
        params.put("password",pwd);
        HttpUtils.gethttpUtils().doPost(Api.LOGIN, params, new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.OnFailure(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                final LoginBean bean = new Gson().fromJson(string, LoginBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.OnSuccess(bean);
                    }
                });
            }
        });
    }

}
