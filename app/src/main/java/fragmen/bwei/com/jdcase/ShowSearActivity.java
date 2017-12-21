package fragmen.bwei.com.jdcase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.List;

import fragmen.bwei.com.jdcase.Adapter.SearchAdapter;
import fragmen.bwei.com.jdcase.Persenter.SearchPresenter;
import fragmen.bwei.com.jdcase.bean.SearchBean;
import fragmen.bwei.com.jdcase.view.Iview.ISearchActivity;

public class ShowSearActivity extends AppCompatActivity implements ISearchActivity {
    private SearchPresenter searchPresenter;
    private ImageView mBack;
    private EditText mImg;
    private ImageView mQiehuan;
    private RecyclerView mRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_sear);
        initView();
        Intent intent = getIntent();
        String key = intent.getStringExtra("key");
        searchPresenter = new SearchPresenter(this);
        searchPresenter.showSearch(key);
    }

    @Override
    public void showSearch(List<SearchBean.DataBean> list) {
        SearchAdapter searchAdapter = new SearchAdapter(this, list);
        mRv.setAdapter(searchAdapter);
    }

    private void initView() {
        mBack = (ImageView) findViewById(R.id.back);
        mImg = (EditText) findViewById(R.id.img);
        mQiehuan = (ImageView) findViewById(R.id.qiehuan);
        mRv = (RecyclerView) findViewById(R.id.rv);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowSearActivity.this.finish();
            }
        });
    }
}
