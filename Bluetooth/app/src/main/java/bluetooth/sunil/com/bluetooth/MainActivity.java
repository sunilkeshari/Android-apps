package bluetooth.sunil.com.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
     BluetoothAdapter bluetoothAdapter;
    String devices="";
    ListView lv;
    ProgressBar pg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Switch sw = (Switch) findViewById(R.id.sw);
        lv=(ListView)findViewById(R.id.lv);
        pg=(ProgressBar)findViewById(R.id.pg);
        pg.setVisibility(View.INVISIBLE);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked && bluetoothAdapter.isEnabled() == false) {
                    bluetoothAdapter.enable();
                } else if (isChecked == false && bluetoothAdapter.isEnabled() == true) {
                    bluetoothAdapter.disable();
                    lv.setVisibility(View.INVISIBLE);
                }
            }
        });
    }


        public void scan(View v) {
            bluetoothAdapter.startDiscovery();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(BluetoothDevice.ACTION_FOUND);
            registerReceiver(new BR(), intentFilter);
            pg.setVisibility(View.VISIBLE);
        }


    class BR extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            BluetoothDevice device=intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            devices=devices+","+device.getName();
            Toast.makeText(getApplicationContext(),device.getName(),Toast.LENGTH_LONG).show();
            String[] values=devices.split(",");
            ArrayAdapter adapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_spinner_dropdown_item,values);
            pg.setVisibility(View.INVISIBLE);
            lv.setAdapter(adapter);
        }
        }
    }

