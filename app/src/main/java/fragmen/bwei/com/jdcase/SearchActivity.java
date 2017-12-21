package fragmen.bwei.com.jdcase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import fragmen.bwei.com.jdcase.Persenter.SearchPresenter;
import fragmen.bwei.com.jdcase.bean.SearchBean;
import fragmen.bwei.com.jdcase.view.Iview.ISearchActivity;

public class SearchActivity extends AppCompatActivity {

    private ImageView mImage;
    /**
     * 360京东
     */
    private EditText mAlertDialogEt;
    /**
     * 搜索
     */
    private TextView mSearchBadge;
    private MyTitile mt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        mt = findViewById(R.id.mt);
    }

}
