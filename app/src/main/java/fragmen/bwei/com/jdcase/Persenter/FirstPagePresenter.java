package fragmen.bwei.com.jdcase.Persenter;

import java.util.List;

import fragmen.bwei.com.jdcase.bean.BannerBean;
import fragmen.bwei.com.jdcase.bean.RemBean;
import fragmen.bwei.com.jdcase.model.FirstPageModel;
import fragmen.bwei.com.jdcase.model.IModel.IFirstPageModel;
import fragmen.bwei.com.jdcase.net.OnNetListener;
import fragmen.bwei.com.jdcase.view.Iview.IFirstPageActivity;

/**
 * Created by kang on 2017/12/14.
 */

public class FirstPagePresenter {
    private IFirstPageActivity iFirstPageActivity;
    private final IFirstPageModel firstPageModel;

    public FirstPagePresenter(IFirstPageActivity iFirstPageActivity){
        this.iFirstPageActivity = iFirstPageActivity;
        firstPageModel = new FirstPageModel();
    }
    public void getShowBanner(){
        firstPageModel.getShow(new OnNetListener<BannerBean>() {
            @Override
            public void OnFailure(Exception e) {

            }

            @Override
            public void OnSuccess(BannerBean bannerBean) {
                List<BannerBean.DataBean> data = bannerBean.getData();
                iFirstPageActivity.showBanner(data);
                List<BannerBean.TuijianBean.ListBean> list = bannerBean.getTuijian().getList();
                iFirstPageActivity.shoeRem(list);

            }
        });
    }


}
