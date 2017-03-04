package wifiservice.sunil.com.wifi;

import android.app.Fragment;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Sonu on 2/21/2017.
 */

public class ScanFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.scanfragment,container,false);
        ListView listView=(ListView)v.findViewById(R.id.lv);
        listView.setAdapter(new ScanAdapter());

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
