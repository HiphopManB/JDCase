package fragmen.bwei.com.jdcase.model;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import fragmen.bwei.com.jdcase.bean.Basebean;
import fragmen.bwei.com.jdcase.model.IModel.IRegisterModel;
import fragmen.bwei.com.jdcase.net.Api;
import fragmen.bwei.com.jdcase.net.HttpUtils;
import fragmen.bwei.com.jdcase.net.OnNetListener;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by kang on 2017/11/9.
 * 真正的网络请求
 */

public class Register extends BaseModel implements IRegisterModel {
    @Override
    public void register(String account, String pwd, final OnNetListener<Basebean> onNetListener) {
        //创建一个map集合
        Map<String , String> params = new HashMap<>();
        params.put("mobile",account);
        params.put("password",pwd);
         HttpUtils.gethttpUtils().doPost(Api.REGISTER, params, new Callback() {
             @Override
             public void onFailure(Call call, final IOException e) {
                 //失败
                 handler.post(new Runnable() {
                     @Override
                     public void run() {
                         onNetListener.OnFailure(e);
                     }
                 });
             }

             @Override
             public void onResponse(Call call, Response response) throws IOException {
                 //成功
               String string = response.body().string();
                 final Basebean basebean = new Gson().fromJson(string, Basebean.class);
                 handler.post(new Runnable() {
                        @Override
                        public void run() {
                            onNetListener.OnSuccess(basebean);
                        }
                    });
             }
         });
    }
}
