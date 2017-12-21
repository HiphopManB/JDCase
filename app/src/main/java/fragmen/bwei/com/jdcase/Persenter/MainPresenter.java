package fragmen.bwei.com.jdcase.Persenter;




import fragmen.bwei.com.jdcase.bean.LoginBean;
import fragmen.bwei.com.jdcase.model.IModel.ILoginModel;
import fragmen.bwei.com.jdcase.model.LoginModel;
import fragmen.bwei.com.jdcase.net.App;
import fragmen.bwei.com.jdcase.net.OnNetListener;
import fragmen.bwei.com.jdcase.view.Iview.IMainActivity;

/**
 * Created by kang on 2017/11/8.
 */

public class MainPresenter {
    private IMainActivity iMainActivity;
    private final ILoginModel iLoginModel;
    private String uid;



    public  MainPresenter(IMainActivity iMainActivity){
        this.iMainActivity = iMainActivity;
        //创建model
        iLoginModel = new LoginModel();


    }
    public void Login(String phone,String pass){

            iLoginModel.login( phone,pass ,new OnNetListener<LoginBean>() {

                private String nickname;

                @Override
                public void OnFailure(Exception e) {
                    //失败
                }

                @Override
                public void OnSuccess(LoginBean loginBean) {
                    iMainActivity.toLogin(loginBean);


                }
            });

        }
}
