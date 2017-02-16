package fragments.sunil.com.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Sonu on 2/3/2017.
 */

public class Fragment1 extends Fragment {

    EditText uname,pass;
    Button login;
    Communicator comm;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment1,container,false);
        uname=(EditText)v.findViewById(R.id.uname);
        pass=(EditText)v.findViewById((R.id.pass));
        login=(Button)v.findViewById(R.id.login);
        comm=(Communicator) getActivity();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              // comm.respond((uname.getText().toString()),(pass.getText().toString()));
           /*   Bundle args=new Bundle();
              args.putString("uname",uname.getText().toString());
              args.putString("pass",pass.getText().toString());
           */
                SharedPreferences sp=getActivity().getSharedPreferences("mydb", Context.MODE_PRIVATE);
                if((uname.getText().toString()).equals(sp.getString("uname","No value")) && (pass.getText().toString()).equals(sp.getString("pass","No Value")))
                {
                    Toast.makeText(getActivity(),"Success",Toast.LENGTH_LONG).show();
                    Fragment2 f2=new Fragment2();
                    //f2.setArguments(args);
                    getFragmentManager().beginTransaction().replace(R.id.flayout,f2).commit();

                }
                else{
                    Toast.makeText(getActivity(),"Failed",Toast.LENGTH_LONG).show();
                }

                    }
        });
        return v;
    }
}
