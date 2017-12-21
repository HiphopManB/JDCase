package fragmen.bwei.com.jdcase.Persenter;

import java.util.List;

import fragmen.bwei.com.jdcase.bean.Classify2Bean;
import fragmen.bwei.com.jdcase.bean.ClassifyBean;
import fragmen.bwei.com.jdcase.model.Classify;
import fragmen.bwei.com.jdcase.model.IModel.IClassifyModel;
import fragmen.bwei.com.jdcase.net.OnNetListener;
import fragmen.bwei.com.jdcase.view.Iview.IClassify;
import fragmen.bwei.com.jdcase.view.Iview.IMainActivity;

/**
 * Created by kang on 2017/12/9.
 */

public class ClassifyPresenter {
    private IClassify iClassify;
    private final IClassifyModel classify;

    public ClassifyPresenter(IClassify iClassify){
        this.iClassify = iClassify;
        classify = new Classify();
    }

    public void getClassify(){
        classify.Classify(new OnNetListener<ClassifyBean>() {
            @Override
            public void OnFailure(Exception e) {

            }

            @Override
            public void OnSuccess(ClassifyBean classifyBean) {
                List<ClassifyBean.DataBean> data = classifyBean.getData();
                iClassify.show(data);

            }
        });
    }
    public void getClassify2(String uid){
        classify.Classify2(new OnNetListener<Classify2Bean>() {
            @Override
            public void OnFailure(Exception e) {

            }

            @Override
            public void OnSuccess(Classify2Bean dataBean) {
                List<Classify2Bean.DataBean> data = dataBean.getData();
                iClassify.show2(data);

            }
        },uid);
    }
}
