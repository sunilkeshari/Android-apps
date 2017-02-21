package locationservice.sunil.com.locationservice;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    double lat, lon;
    TextView tv1, tv2;
    LocationManager locationManager;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void network(View v) {
      Intent i=new Intent(this,NetworkProvider.class);
        startActivity(i);

    }
    public void GPS(View v) {
        Intent i=new Intent(this,GPS.class);
        startActivity(i);

    }
}
