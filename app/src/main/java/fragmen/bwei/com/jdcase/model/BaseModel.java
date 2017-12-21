package fragmen.bwei.com.jdcase.model;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by kang on 2017/11/9.
 * 所有Model的父类,里面主要是封装了Handler , 避免每一个Model都去创建一个Handler
 */

public class BaseModel {
    protected Handler handler = new Handler(Looper.getMainLooper());


}
