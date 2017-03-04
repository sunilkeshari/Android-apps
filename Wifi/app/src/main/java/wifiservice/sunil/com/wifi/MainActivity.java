package wifiservice.sunil.com.wifi;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivity=this;
        getFragmentManager().beginTransaction().add(R.id.flayout,new ScanFragment()).commit();
    }
    public void scan(View v){
        getFragmentManager().beginTransaction().replace(R.id.flayout,new ScanFragment()).commit();
     //   Toast.makeText(this,"Scan",Toast.LENGTH_LONG).show();
    }
    public void checkDevice(View v){
        getFragmentManager().beginTransaction().replace(R.id.flayout,new PairedFragment()).commit();
    }
}
