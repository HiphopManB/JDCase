package fragmen.bwei.com.jdcase.net;

import android.app.Application;
import android.content.SharedPreferences;

import com.facebook.drawee.backends.pipeline.Fresco;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by kang on 2017/12/13.
 */

public class App extends Application {
    public static SharedPreferences handle;
    public static SharedPreferences.Editor edit;
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        //创建对象
        handle = getSharedPreferences("user", MODE_PRIVATE);
        edit = handle.edit();

    }
}
