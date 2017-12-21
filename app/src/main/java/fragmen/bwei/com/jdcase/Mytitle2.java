package fragmen.bwei.com.jdcase;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by kang on 2017/12/15.
 */

public class Mytitle2 extends LinearLayout {

    private TextView tv;
    private Activity activity;

    public Mytitle2(Context context) {
        this(context,null);
    }

    public Mytitle2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        activity = (Activity) context;
        View view = LayoutInflater.from(context).inflate(R.layout.mytitle_item2, this);
        tv = findViewById(R.id.alertDialog_et);
        tv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SearchActivity.class);
                activity.startActivity(intent);
            }
        });
    }
}
