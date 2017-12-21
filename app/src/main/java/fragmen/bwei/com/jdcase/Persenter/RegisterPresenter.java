package fragmen.bwei.com.jdcase.Persenter;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fragmen.bwei.com.jdcase.bean.Basebean;
import fragmen.bwei.com.jdcase.model.IModel.IRegisterModel;
import fragmen.bwei.com.jdcase.model.Register;
import fragmen.bwei.com.jdcase.net.OnNetListener;
import fragmen.bwei.com.jdcase.view.Iview.IRegisterActivity;

/**
 * Created by kang on 2017/11/9.
 */

public class RegisterPresenter {
    private IRegisterActivity iRegisterActivity;
    private final IRegisterModel register;

    public  RegisterPresenter(IRegisterActivity iRegisterActivity){
        this.iRegisterActivity = iRegisterActivity;
        //创建Register
        register = new Register();
    }
    //注册
    public void Register(){
        String phone = iRegisterActivity.getAccount();
        String Pwd = iRegisterActivity.getpwd();
        if(checkPhone(phone) && checkPwd(Pwd)){
            register.register(phone, Pwd, new OnNetListener<Basebean>() {
                @Override
                public void OnFailure(Exception e) {

                }

                @Override
                public void OnSuccess(Basebean basebean) {
                    if(basebean.getCode().equals("1")){
                        iRegisterActivity.show(basebean.getMsg());
                    }else{
                        iRegisterActivity.show(basebean.getMsg());
                        iRegisterActivity.finishAC();
                    }

                }
            });
        }

    }

    //判断密码
    private boolean checkPwd(String pwd){
        if (TextUtils.isEmpty(pwd)){
            iRegisterActivity.show("请输入密码");
            return false;
        }
        if(pwd.length() != 6){
            iRegisterActivity.show("请输入6位密码");
            return false;
        }
        return true;
    }
    //验证手机号是否正确````````
    private boolean  checkPhone(String phone){
        if (TextUtils.isEmpty(phone)){
            iRegisterActivity.show("请输入账号");
            return false;
        }
        if (!isMobileNO(phone)){
            iRegisterActivity.show("请输入正确的手机号");
            return false;
        }
        return true;
    }

    /*
   判断是否是手机号
    */
    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^(13[0-9]|14[57]|15[0-35-9]|17[6-8]|18[0-9])[0-9]{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }
}
