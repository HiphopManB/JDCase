package fragmen.bwei.com.jdcase.Persenter;

import com.facebook.common.executors.UiThreadImmediateExecutorService;

import java.util.List;

import fragmen.bwei.com.jdcase.bean.ClassifyBean;
import fragmen.bwei.com.jdcase.model.Classify;
import fragmen.bwei.com.jdcase.model.IModel.IClassifyModel;
import fragmen.bwei.com.jdcase.net.OnNetListener;
import fragmen.bwei.com.jdcase.view.Iview.INavActivity;

/**
 * Created by kang on 2017/12/14.
 */

public class INavPresenter {
    private INavActivity iNavActivity;
    private final Classify classify;

    public INavPresenter(INavActivity iNavActivity){
        this.iNavActivity = iNavActivity;
        classify = new Classify();
    }
    public void getshowNav(){
        classify.Classify(new OnNetListener<ClassifyBean>() {
            @Override
            public void OnFailure(Exception e) {

            }

            @Override
            public void OnSuccess(ClassifyBean classifyBean) {
                List<ClassifyBean.DataBean> data = classifyBean.getData();
                iNavActivity.showNav(data);
            }
        });
    }
}
