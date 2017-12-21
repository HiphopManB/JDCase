package fragmen.bwei.com.jdcase.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fragmen.bwei.com.jdcase.R;

/**
 * Created by kang on 2017/11/10.
 */

public class Fragment03 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item03, null);
        return view;
    }
}
