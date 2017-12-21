package fragmen.bwei.com.jdcase.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

import fragmen.bwei.com.jdcase.Fragment.Fragment01;
import fragmen.bwei.com.jdcase.Fragment.Fragment02;
import fragmen.bwei.com.jdcase.Fragment.Fragment03;
import fragmen.bwei.com.jdcase.Fragment.Fragment04;
import fragmen.bwei.com.jdcase.Fragment.Fragment05;
import fragmen.bwei.com.jdcase.R;

public class ShowActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 首页
     */
    private RadioButton mRb1;
    /**
     * 资询
     */
    private RadioButton mRb2;
    /**
     * 自选
     */
    private RadioButton mRb3;
    /**
     * 行情
     */
    private RadioButton mRb4;
    private RadioGroup mRg;
    private LinearLayout mActivityShow;
    private ArrayList<Fragment> fragments;
    private FrameLayout mContent;
    /**
     * 我的
     */
    private RadioButton mRb5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        initView();
    }

    private void initView() {
        mRb1 = (RadioButton) findViewById(R.id.rb1);
        mRb1.setOnClickListener(this);
        mRb2 = (RadioButton) findViewById(R.id.rb2);
        mRb2.setOnClickListener(this);
        mRb3 = (RadioButton) findViewById(R.id.rb3);
        mRb3.setOnClickListener(this);
        mRb4 = (RadioButton) findViewById(R.id.rb4);
        mRb4.setOnClickListener(this);
        mRg = (RadioGroup) findViewById(R.id.rg);
        //创建fragment实例并把他们加入集合
        fragments = new ArrayList<>();
        addFragment();
        //设置默认被选中的RadioButton
        mRg.check(R.id.rb1);
        mRb1.setBackgroundResource(R.drawable.ac1);
        switchFragment(0);
        //radiogroup中的radiobutton的点击事件
        mRg.setOnClickListener(this);
        mContent = (FrameLayout) findViewById(R.id.content);
        mRb5 = (RadioButton) findViewById(R.id.rb5);
        mRb5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
                        bai();
                    switch (v.getId()) {
                        default:
                            break;
                        case R.id.rb1:
                            switchFragment(0);
                            mRb1.setBackgroundResource(R.drawable.ac1);
                            break;
                        case R.id.rb2:
                            switchFragment(1);
                            mRb2.setBackgroundResource(R.drawable.abx);
                            break;
                        case R.id.rb3:
                            switchFragment(2);
                            mRb3.setBackgroundResource(R.drawable.abz);
                            break;
                        case R.id.rb4:
                            switchFragment(3);
                            mRb4.setBackgroundResource(R.drawable.abv);
                            break;
                        case R.id.rb5:
                            switchFragment(4);
                            mRb5.setBackgroundResource(R.drawable.ac3);
                            break;
                        case R.id.rg:
                            break;
                    }
                }

                /**
                 * 创建fragment实例并把他们加入集合
                 */

            public void addFragment() {
                fragments.add(new Fragment01());
                fragments.add(new Fragment02());
                fragments.add(new Fragment03());
                fragments.add(new Fragment04());
                fragments.add(new Fragment05());
            }

            /**
             * 点击切换fragment
             *
             * @param position
             */
            public void switchFragment(int position) {
                //开启事务
                FragmentTransaction fragmentTransaction =
                        getSupportFragmentManager().beginTransaction();
                //遍历集合
                for (int i = 0; i < fragments.size(); i++) {
                    Fragment fragment = fragments.get(i);
                    if (i == position) {
                        //显示fragment
                        if (fragment.isAdded()) {
                    //如果这个fragment已经被事务添加,显示
                    fragmentTransaction.show(fragment);
                } else {
                    //如果这个fragment没有被事务添加过,添加
                    fragmentTransaction.add(R.id.content, fragment);
                }
            } else {
                //隐藏fragment
                if (fragment.isAdded()) {
                    //如果这个fragment已经被事务添加,隐藏
                    fragmentTransaction.hide(fragment);
                }
            }
        }
        //提交事务
        fragmentTransaction.commit();
    }
    private void bai() {
        mRb1.setBackgroundResource(R.drawable.ac0);
        mRb2.setBackgroundResource(R.drawable.abw);
        mRb3.setBackgroundResource(R.drawable.aby);
        mRb4.setBackgroundResource(R.drawable.abu);
        mRb5.setBackgroundResource(R.drawable.ac2);
    }


    @Override
    protected void onResume() {
        super.onResume();
        int id = getIntent().getIntExtra("id", 0);

        if(id == 5){
            bai();
            switchFragment(4);
            mRb5.setBackgroundResource(R.drawable.ac3);
        }

    }
}
