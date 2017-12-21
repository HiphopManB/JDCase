package fragmen.bwei.com.jdcase.net;

/**
 * Created by kang on 2017/11/8.
 */

public interface Api {
    public static boolean isOnline = false;//是否在线上
    public static final String DEV = "http://120.27.23.105/";//线下接口
    public static final String WORK = "";//线上接口
    public static final String HOST = isOnline ? WORK : DEV;
    public static final String LOGIN = HOST + "user/login";//登录
    public static final String REGISTER = HOST + "user/reg";//注册


}
