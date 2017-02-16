package fragments.sunil.com.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Sonu on 2/4/2017.
 */

public class Fragment3 extends Fragment {
    View v;
    Button register;
    EditText uname,pass,addr;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment3,container,false);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        uname=(EditText) v.findViewById(R.id.uname);
        pass=(EditText)v.findViewById(R.id.pass);
        addr=(EditText)v.findViewById(R.id.addr);
        register=(Button)v.findViewById(R.id.signup);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp= getActivity().getSharedPreferences("mydb", Context.MODE_PRIVATE);
                SharedPreferences.Editor spe=sp.edit();
                spe.putString("uname",uname.getText().toString());
                spe.putString("pass",pass.getText().toString());
                spe.putString("addr",addr.getText().toString());
                spe.commit();
                getFragmentManager().beginTransaction().replace(R.id.flayout,new Fragment1()).commit();
            }
        });

    }
}
