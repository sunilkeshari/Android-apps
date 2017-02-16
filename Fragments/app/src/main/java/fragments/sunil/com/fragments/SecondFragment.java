package fragments.sunil.com.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Sonu on 2/9/2017.
 */

public class SecondFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.secondfragment,container,false);
        TextView tv=(TextView)v.findViewById(R.id.tv);
        String textval=getArguments().getString("textvalue");
        tv.setText(textval);
        return v;
    }
}
