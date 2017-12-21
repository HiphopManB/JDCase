package fragmen.bwei.com.jdcase.utils;

import android.app.Activity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by kang on 2017/11/8.
 * //一键关闭全部的Activity
 */

public class ActivityUtils {
    private  static List<Activity> list = new LinkedList<>();
    //添加Activity
    public  static void addActivity(Activity activity){
            list.add(activity);
    }
    //关闭
    public  void finishAll(){
        for (Activity ac :list) {
            if(ac != null){
                ac.finish();
            }
        }
    }
}
