package fragmen.bwei.com.jdcase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import fragmen.bwei.com.jdcase.Persenter.RegisterPresenter;
import fragmen.bwei.com.jdcase.view.Iview.IRegisterActivity;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener, IRegisterActivity {

    /**
     * 请输入手机号
     */
    private EditText mEtPhone;
    /**
     * 请输入密码
     */
    private EditText mEtPwd;
    /**
     * 注册
     */
    private Button mBtnLogin;
    private LinearLayout mActivityMain;
    private RegisterPresenter registerPresenter;
    private ImageView mIvCha;
    /**
     * 注册
     */
    private Button mBtnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerPresenter = new RegisterPresenter(this);
        initView();

    }

    private void initView() {
        mEtPhone = (EditText) findViewById(R.id.et_Phone);
        mEtPwd = (EditText) findViewById(R.id.et_Pwd);
        mBtnLogin = (Button) findViewById(R.id.btn_Register);
        mBtnLogin.setOnClickListener(this);
        mActivityMain = (LinearLayout) findViewById(R.id.activity_main);
        mIvCha = (ImageView) findViewById(R.id.iv_cha);
        mIvCha.setOnClickListener(this);
        mBtnRegister = (Button) findViewById(R.id.btn_Register);
        mBtnRegister.setOnClickListener(this);
        mActivityMain.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_Register:
                registerPresenter.Register();
                break;
            case R.id.iv_cha:
                 re();
                break;

        }
    }


    @Override
    public String getAccount() {
        return mEtPhone.getText().toString();
    }

    @Override
    public String getpwd() {
        return mEtPwd.getText().toString();
    }

    @Override
    public void finishAC() {
        finish();
    }

    @Override
    public void show(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void re() {
        finish();
    }
}
