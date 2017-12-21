package fragmen.bwei.com.jdcase.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import fragmen.bwei.com.jdcase.MainActivity;
import fragmen.bwei.com.jdcase.OutLoginActivity;
import fragmen.bwei.com.jdcase.R;
import fragmen.bwei.com.jdcase.net.App;

/**
 * Created by kang on 2017/11/10.
 */

public class Fragment05 extends Fragment {

    private TextView tv_name;
    private TextView textView;
    private String name;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item05, null);
        textView = (TextView) view.findViewById(R.id.btn_login);
        //ImageView btn = view.findViewById(R.id.btn_login);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        tv_name = view.findViewById(R.id.tv_name);
        init();
        info();
        return view;
    }

    private void info() {
        boolean flag = App.handle.getBoolean("flag", false);
            if(flag){
            textView.setVisibility(View.GONE);
            tv_name.setVisibility(View.VISIBLE);
        }else {
            textView.setVisibility(View.VISIBLE);
            tv_name.setVisibility(View.GONE);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                }
            });
        }
    }

    private void init() {
        boolean flag = App.handle.getBoolean("flag", false);
        if(flag){
            name = App.handle.getString("name", "");
            tv_name.setText(name);
        }
        //点击跳转
        tv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(getContext(), OutLoginActivity.class);
                     intent.putExtra("name",name);
                     startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        init();
        info();
    }
}
