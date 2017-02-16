package fragments.sunil.com.fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Sonu on 2/3/2017.
 */

public class Fragment2 extends Fragment {
    TextView tv1,tv2,tv3;
    View v;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment2,container,false);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tv1=(TextView)v.findViewById(R.id.tv2);
        tv2=(TextView)v.findViewById(R.id.tv3);
        tv3=(TextView)v.findViewById(R.id.tv4);
  /*      tv1.setText(MainActivity.uname);
        tv2.setText(MainActivity.pass);
*/
        /*tv1.setText(getArguments().getString("uname"));
        tv2.setText(getArguments().getString("pass"));
    */
        SharedPreferences sp=getActivity().getSharedPreferences("mydb", Context.MODE_PRIVATE);

        tv1.setText("User Name - "+sp.getString("uname","No Value"));
        tv2.setText("Password - "+sp.getString("pass","No Value"));
        tv3.setText("Address - "+sp.getString("addr","No Value"));
    }


}
