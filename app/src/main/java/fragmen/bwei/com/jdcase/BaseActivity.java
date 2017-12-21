package fragmen.bwei.com.jdcase;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import fragmen.bwei.com.jdcase.bean.LoginBean;

/**
 * Created by kang on 2017/12/18.
 */

public class BaseActivity extends AppCompatActivity {
    private List<LoginBean.DataBean> list = new ArrayList<>();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }
}
