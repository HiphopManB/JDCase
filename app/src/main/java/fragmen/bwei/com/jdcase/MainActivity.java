package fragmen.bwei.com.jdcase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import fragmen.bwei.com.jdcase.Persenter.MainPresenter;
import fragmen.bwei.com.jdcase.bean.LoginBean;
import fragmen.bwei.com.jdcase.net.App;
import fragmen.bwei.com.jdcase.view.Iview.IMainActivity;
import fragmen.bwei.com.jdcase.view.ShowActivity;
/*
主类

*/

public class MainActivity extends BaseActivity implements View.OnClickListener, IMainActivity {


    private TextView mTvRegister;
    private LinearLayout mActivityMain;
    private MainPresenter mainPresenter;
    private ImageView mIvCha;
    /**
     * 请输入手机号
     */
    private EditText mEtPhone;
    /**
     * 请输入密码
     */
    private EditText mEtPwd;
    /**
     * 登录
     */
    private Button mBtnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //关联presenter层
        mainPresenter = new MainPresenter(this);
        // new RegisterPresenter(this);


    }

    private void initView() {
        mIvCha = (ImageView) findViewById(R.id.iv_cha);
        mEtPhone = (EditText) findViewById(R.id.et_Phone);
        mEtPwd = (EditText) findViewById(R.id.et_Pwd);
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(this);
        mTvRegister = (TextView) findViewById(R.id.tv_Register);
        mTvRegister.setOnClickListener(this);
        mActivityMain = (LinearLayout) findViewById(R.id.activity_main);
        mIvCha.setOnClickListener(this);
        mActivityMain.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_login:
                String phone = mEtPhone.getText().toString();
                String pass = mEtPwd.getText().toString();
                mainPresenter.Login(phone,pass);
                Intent intent1 = new Intent(MainActivity.this,ShowActivity.class);
                intent1.putExtra("id",5);
                startActivity(intent1);
                break;
            case R.id.tv_Register:
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_cha:
               finish();
                break;
            case R.id.activity_main:
                break;
        }
    }


    @Override
    public void toLogin(LoginBean loginBean) {
        String code = loginBean.getCode();

        if (code.equals("0")){
            LoginBean.DataBean data = loginBean.getData();
            String uid = data.getUid();
            String nickname = data.getUsername();
            App.edit.putString("name",nickname);
            App.edit.putString("uid",uid);
            App.edit.putBoolean("flag",true);
            App.edit.commit();


            Toast.makeText(this, loginBean.getMsg(), Toast.LENGTH_SHORT).show();
        }else{
            App.edit.putBoolean("flag",false);
            App.edit.commit();
            Toast.makeText(this, loginBean.getMsg(), Toast.LENGTH_SHORT).show();
        }
    }




}
