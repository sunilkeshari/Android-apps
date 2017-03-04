package wifiservice.sunil.com.wifi;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Sonu on 2/21/2017.
 */

public class PairedAdapter extends BaseAdapter {

     WifiManager wifiManager;
    List<WifiConfiguration> config;
    @Override
    public int getCount() {
        wifiManager=(WifiManager) MainActivity.mainActivity.getSystemService(Context.WIFI_SERVICE);
        config=wifiManager.getConfiguredNetworks();
        return config.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(MainActivity.mainActivity);
        View v=inflater.inflate(R.layout.paireddevice,null);
        TextView name=(TextView)v.findViewById(R.id.name);
        TextView tv=(TextView)v.findViewById(R.id.tv);
        WifiConfiguration conf= config.get(position);
        name.setText(conf.SSID);
        tv.setText(conf.status);
        return null;
    }
}
