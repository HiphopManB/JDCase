package fragmen.bwei.com.jdcase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import fragmen.bwei.com.jdcase.Persenter.FirstPagePresenter;
import fragmen.bwei.com.jdcase.Persenter.RemPresenter;
import fragmen.bwei.com.jdcase.banner.GlideImageLoader;
import fragmen.bwei.com.jdcase.bean.BaseBeanTwo;
import fragmen.bwei.com.jdcase.bean.RemBean;
import fragmen.bwei.com.jdcase.net.App;
import fragmen.bwei.com.jdcase.view.Iview.IRemActivity;

public class RemActivity extends BaseActivity implements IRemActivity, View.OnClickListener {

    private FirstPagePresenter firstPagePresenter;
    private ImageView mIvEdit;
    private ImageView mFenxiang;
    private TextView mTvGoodsName;
    private TextView mTvGoodsPrice;
    /**
     * 购物车
     */
    private TextView mTvGouwu;
    /**
     * 加入购物车
     */
    private Button mButAddcar;
    private Banner mBanner;
    private com.youth.banner.Banner ban;
    private RemPresenter remPresenter;
    private List<String> list = new ArrayList<>();

    private String pid;
    private String uid;
    private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rem);
        initView();
        remPresenter = new RemPresenter(this);
        Intent intent = getIntent();
        pid = intent.getStringExtra("pid");
        uid = App.handle.getString("uid", "");
        remPresenter.getRem(pid);

    }

    private void initView() {
        mIvEdit = (ImageView) findViewById(R.id.iv_edit);
        mFenxiang = (ImageView) findViewById(R.id.fenxiang);
        mTvGoodsName = (TextView) findViewById(R.id.tv_goods_name);
        mTvGoodsPrice = (TextView) findViewById(R.id.tv_goods_price);
        mTvGouwu = (TextView) findViewById(R.id.tv_gouwu);
        mButAddcar = (Button) findViewById(R.id.but_addcar);
        mButAddcar.setOnClickListener(this);
        mIvEdit.setOnClickListener(this);
        mFenxiang.setOnClickListener(this);
        ban = findViewById(R.id.banner);
        mTvGoodsName.setOnClickListener(this);
        mTvGoodsPrice.setOnClickListener(this);
        mTvGouwu.setOnClickListener(this);
        mIvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RemActivity.this.finish();
            }
        });
        mButAddcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                remPresenter.getAdd(uid,pid);
                Toast.makeText(RemActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.but_addcar:
                break;
            case R.id.iv_edit:
                break;
            case R.id.fenxiang:
                break;
            case R.id.tv_goods_name:
                break;
            case R.id.tv_goods_price:
                break;
            case R.id.tv_gouwu:
                break;
        }
    }

    @Override
    public void show(RemBean remBean) {
        RemBean.DataBean data = remBean.getData();
        String images = data.getImages();
        String[] split = images.split("\\|");
        for (int i = 0; i < 3; i++) {
            list.add(split[i]);
        }
        ban.setImageLoader(new GlideImageLoader());
        ban.setImages(list);
        ban.start();
        mTvGoodsName.setText(data.getSubhead());
        mTvGoodsPrice.setText(data.getPrice());
    }

    @Override
    public void addGoods(BaseBeanTwo baseBeanTwo) {
        msg = baseBeanTwo.getMsg();
    }


}
