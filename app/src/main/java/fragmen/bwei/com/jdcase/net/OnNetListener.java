package fragmen.bwei.com.jdcase.net;

/**
 * Created by kang on 2017/11/8.\
 * 网络回调接口
 */

public interface OnNetListener<T> {
    //失败
    public void OnFailure(Exception e);
    //成功
    public  void OnSuccess(T t);
}
