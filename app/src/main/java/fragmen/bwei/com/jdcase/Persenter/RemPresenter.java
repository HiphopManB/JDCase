package fragmen.bwei.com.jdcase.Persenter;

import fragmen.bwei.com.jdcase.bean.BaseBeanTwo;
import fragmen.bwei.com.jdcase.bean.RemBean;
import fragmen.bwei.com.jdcase.model.FirstPageModel;
import fragmen.bwei.com.jdcase.model.IModel.IAddcar;
import fragmen.bwei.com.jdcase.model.IModel.IFirstPageModel;
import fragmen.bwei.com.jdcase.model.IaddCarG;
import fragmen.bwei.com.jdcase.net.OnNetListener;
import fragmen.bwei.com.jdcase.view.Iview.IFirstPageActivity;
import fragmen.bwei.com.jdcase.view.Iview.IRemActivity;

/**
 * Created by kang on 2017/12/16.
 */

public class RemPresenter {
    private IRemActivity iRemActivity;
    private final IFirstPageModel firstPageModel;
    private final IAddcar iaddCarG;

    public RemPresenter(IRemActivity iRemActivity){
        this.iRemActivity = iRemActivity;
        firstPageModel = new FirstPageModel();
        iaddCarG = new IaddCarG();
    }
    public void getRem(String pid){
        firstPageModel.getRem(new OnNetListener<RemBean>() {
            @Override
            public void OnFailure(Exception e) {

            }

            @Override
            public void OnSuccess(RemBean remBean) {

                iRemActivity.show(remBean);

            }
        },pid);
    }
    public  void getAdd(String uid,String pid){
        iaddCarG.addGoods(uid, pid, new OnNetListener<BaseBeanTwo>() {
            @Override
            public void OnFailure(Exception e) {

            }

            @Override
            public void OnSuccess(BaseBeanTwo baseBeanTwo) {
                iRemActivity.addGoods(baseBeanTwo);
            }
        });
    }
}
