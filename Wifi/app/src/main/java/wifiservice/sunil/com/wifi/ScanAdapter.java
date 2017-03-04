package wifiservice.sunil.com.wifi;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Sonu on 2/21/2017.
 */

public class ScanAdapter extends BaseAdapter {
    WifiManager wifiManager=(WifiManager) MainActivity.mainActivity.getSystemService(Context.WIFI_SERVICE);
    int state;
    static int count;
    List<ScanResult> results=wifiManager.getScanResults();
      @Override
    public int getCount() {

        state=wifiManager.getWifiState();
        if(state==0||state==1){
            wifiManager.setWifiEnabled(true);
        }
        count=results.size();
        //Toast.makeText(MainActivity.mainActivity,count,Toast.LENGTH_LONG).show();
        return count;
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
        View v=inflater.inflate(R.layout.scanresult,null);
        TextView name=(TextView)v.findViewById(R.id.name);
        TextView frequency=(TextView)v.findViewById(R.id.frequency);
        ScanResult res=results.get(position);
        name.setText(res.SSID);
        frequency.setText(res.frequency);
        return null;
    }
}
