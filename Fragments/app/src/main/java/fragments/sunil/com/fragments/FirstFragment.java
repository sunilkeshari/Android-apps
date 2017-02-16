package fragments.sunil.com.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Sonu on 2/9/2017.
 */

public class FirstFragment extends Fragment {
    EditText et;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.firstfragment,container,false);
        et=(EditText)v.findViewById(R.id.et);
        Button b=(Button)v.findViewById(R.id.b1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args=new Bundle();
                args.putString("textvalue",et.getText().toString());
                SecondFragment f=new SecondFragment();
                f.setArguments(args);
                getFragmentManager().beginTransaction().replace(R.id.f2,f).commit();
            }
        });
        return v;
    }

}
