package fragmen.bwei.com.jdcase.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import fragmen.bwei.com.jdcase.Adapter.RemAdapter2;
import fragmen.bwei.com.jdcase.Adapter.SearchAdapter;
import fragmen.bwei.com.jdcase.Mytitle2;
import fragmen.bwei.com.jdcase.Persenter.FirstPagePresenter;
import fragmen.bwei.com.jdcase.R;
import fragmen.bwei.com.jdcase.RemActivity;
import fragmen.bwei.com.jdcase.banner.GlideImageLoader;
import fragmen.bwei.com.jdcase.bean.BannerBean;
import fragmen.bwei.com.jdcase.bean.SearchBean;
import fragmen.bwei.com.jdcase.view.Iview.IFirstPageActivity;

/**
 * Created by kang on 2017/11/10.
 */

public class Fragment01 extends Fragment implements IFirstPageActivity {

    private LinearLayout line;
    private Banner banner;
    private List<String> listS = new ArrayList<>();
    private FirstPagePresenter firstPagePresenter;
    private List<Fragment> fragmentList = new ArrayList<>();
    private View view;
    private ViewPager mVp;
    private Mytitle2 myt;
    private SimpleDraweeView sd;
    private String icon;
    /**
     * 京东秒杀
     */
    private TextView mTvMiao;
    /**
     * 8点场
     */
    private TextView mTime;
    /**
     * 02
     */
    private TextView mHours;
    /**
     * 33
     */
    private TextView mMinute;
    /**
     * 33
     */
    private TextView mSecond;

    private Mytitle2 mMyt2;
    private long mHour = 9;
    private long mMin = 25;
    private long second = 36;
    private boolean isRun = true;
    private Handler timeHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==1) {
                computeTime();
                if (mHour<10){
                    mHours.setText("0"+mHour+"");
                }else {
                    mHours.setText(mHour+"");
                }
                if (mMin<10){
                    mMinute.setText("0"+mMin+"");
                }else {
                    mMinute.setText(mMin+"");
                }
                if (second<10){
                    mSecond.setText("0"+second+"");
                }else {
                    mSecond.setText(second+"");
                }
            }
        }
    };
    private ViewFlipper vf;
    private RecyclerView rem;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item01, null);
        //line = (LinearLayout) view.findViewById(R.id.line);
        myt = view.findViewById(R.id.myt2);
        sd = view.findViewById(R.id.sdv_o);
        rem = view.findViewById(R.id.rem_rcv);
        rem.setLayoutManager(new GridLayoutManager(getContext(),2));
        firstPagePresenter = new FirstPagePresenter(this);
        firstPagePresenter.getShowBanner();
        banner = (Banner) view.findViewById(R.id.banner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        fragmentList.add(new fragment_nav1());
        fragmentList.add(new fragment_nav2());
        initView(view);
        return view;
    }

    @Override
    public void showBanner(List<BannerBean.DataBean> list) {
        for (int i = 0; i < list.size(); i++) {
            BannerBean.DataBean dataBean = list.get(i);
            icon = dataBean.getIcon();
            listS.add(icon);
            banner.setImages(listS);
            //banner设置方法全部调用完毕时最后调用
            banner.start();
        }

    }

    @Override
    public void shoeRem(List<BannerBean.TuijianBean.ListBean> list) {
        RemAdapter2 adapter = new RemAdapter2(getContext(),list);
        rem.setAdapter(adapter);
        adapter.OnClickItem(new RemAdapter2.OnclickListener() {
            @Override
            public void OnItemClick(String str) {
                Intent intent = new Intent(getContext(), RemActivity.class);
                intent.putExtra("pid",str);
                startActivity(intent);
            }
        });
    }


    private void initView(View view) {

        mVp = (ViewPager) view.findViewById(R.id.vp);
        mVp.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });
        mTvMiao = (TextView) view.findViewById(R.id.tv_miao);
        mTime = (TextView) view.findViewById(R.id.time);
        mHours = (TextView) view.findViewById(R.id.hours);
        mMinute = (TextView) view.findViewById(R.id.minute);
        mSecond = (TextView) view.findViewById(R.id.second);
        mMyt2 = (Mytitle2) view.findViewById(R.id.myt2);
        vf = view.findViewById(R.id.vf);
        startRun();
        //跑马灯
        vf.addView(View.inflate(getActivity(),R.layout.jingdong_text1,null));
        vf.addView(View.inflate(getActivity(),R.layout.jingdong_text2,null));
        vf.addView(View.inflate(getActivity(),R.layout.jingdong_text3,null));
    }

    /**
     * 开启倒计时
     */
    private void startRun() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (isRun) {
                    try {
                        Thread.sleep(1000); // sleep 1000ms
                        Message message = Message.obtain();
                        message.what = 1;
                        timeHandler.sendMessage(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    /**
     * 倒计时计算
     */
    private void computeTime() {
        second--;
        if (second < 0) {
            mMin--;
            second = 59;
            if (mMin < 0) {
                mMin = 59;
                mHour--;
            }
        }
    }
}
