package fragmen.bwei.com.jdcase.net;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kang on 2017/12/9.
 */

public class HttpUtilsRxjava {
    private static OkHttpClient client;
    private static MyApi api;
    static {

        init();
    }

    private static void init() {
        if(client == null){
            synchronized (HttpUtilsRxjava.class){
                if(client == null){
                    client = new OkHttpClient.Builder()
                            .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                            .build();
                }
            }
        }
    }
public static MyApi getApi(){
        if(api == null){
            synchronized (MyApi.class){
                if(api == null){
                    api = HttpUtilsRxjava.Oncreate(MyApi.class,ApiTwo.URLS);
                }
            }
        }
        return api;
    }
    public static <T> T Oncreate(Class<T> clazz,String url){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(clazz);
    }
}
