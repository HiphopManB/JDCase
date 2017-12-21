package fragmen.bwei.com.jdcase;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by kang on 2017/12/15.
 */

public class MyTitile extends LinearLayout {

    private ImageView img;
    private EditText et;
    private TextView sea;

    public MyTitile(Context context) {
        this(context, null);
    }

    public MyTitile(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        final Activity activity = (Activity) context;
        View view = LayoutInflater.from(context).inflate(R.layout.mytitle_item, this);
        img = findViewById(R.id.image);
        et = findViewById(R.id.alertDialog_et);
        sea = findViewById(R.id.search_badge);
        sea.setOnClickListener(new OnClickListener() {
            private String s;
            @Override
            public void onClick(View view) {
                s = et.getText().toString().trim();
                if(s == null){
                    Toast.makeText(getContext(), "请输入搜索内容!", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(getContext(),ShowSearActivity.class);
                    intent.putExtra("key", s);
                    activity.startActivity(intent);
                }

            }
        });
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.finish();
            }
        });

    }
}
