package fragmen.bwei.com.jdcase;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import fragmen.bwei.com.jdcase.net.App;

public class OutLoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mMyBack2;
    private SimpleDraweeView mMyXimg;
    /**
     * **
     */
    private TextView mMyNickname2;
    private LinearLayout mMyL;
    /**
     * 退出登录
     */
    private Button mMyTui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_login);
        initView();
        String name = getIntent().getStringExtra("name");

        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }

    private void initView() {
        mMyBack2 = (ImageView) findViewById(R.id.my_back2);
        mMyXimg = (SimpleDraweeView) findViewById(R.id.my_ximg);
        mMyNickname2 = (TextView) findViewById(R.id.my_nickname2);
        mMyL = (LinearLayout) findViewById(R.id.my_l);
        mMyTui = (Button) findViewById(R.id.my_tui);
        mMyTui.setOnClickListener(this);
        //关闭thisActivity
        mMyBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();;
            }
        });
        //退出账号
        mMyTui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //创建一个AlertDialog.Builder
                AlertDialog.Builder builder = new AlertDialog.Builder(OutLoginActivity.this);
                //设置图片
                builder.setIcon(R.mipmap.ic_launcher);
                //设置内容
                builder.setMessage("是否退出登录!!!");
                builder.setPositiveButton("true", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        App.edit.putBoolean("flag",false);
                        App.edit.commit();
                        mMyNickname2.setText("");
                        finish();
                    }
                });
                builder.setNegativeButton("false", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(OutLoginActivity.this, "再逗留一会!!", Toast.LENGTH_SHORT).show();
                    }
                });
                //忽略
                builder.setNegativeButton("忽略", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(OutLoginActivity.this, "忽略", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.my_tui:
                break;
        }
    }
}
