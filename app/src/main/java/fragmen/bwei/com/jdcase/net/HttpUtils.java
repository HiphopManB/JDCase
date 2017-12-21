package fragmen.bwei.com.jdcase.net;

import java.util.Map;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by kang on 2017/11/8.
 */

public class HttpUtils {

    private static HttpUtils httpUtils;
    private final HttpLoggingInterceptor interceptor;
    private final OkHttpClient client;

    //构造
    private  HttpUtils(){

        //创建拦截器
        interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //创建一个ok
        client = new OkHttpClient.Builder()
                //拦截器
                .addInterceptor(interceptor)
                .build();


    }
    //单例模式
    public static HttpUtils gethttpUtils(){
        if(httpUtils == null){
            synchronized (HttpUtils.class){
                if (httpUtils == null){
                    httpUtils = new HttpUtils();

                }
            }
        }

        return httpUtils;
    }
    /*
    *
    * */
    //创建post请求方法
    public  void doPost(String url , Map<String , String> params, Callback callback){
        //判断参数
        if(params == null || params.size() == 0){
                throw new RuntimeException("params is null!!!");
        }
        //创建formbODY.Builder
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String,String> entry:params.entrySet()) {
            builder.add(entry.getKey(),entry.getValue());
        }
        FormBody body = builder.build();
        //请求Request
        Request build = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        client.newCall(build).enqueue(callback);


    }
}
