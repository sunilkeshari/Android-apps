package filelist.sunil.com.filelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    String path;
    ListView lview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        path = "/storage/sdcard0/";
        File f = new File(path);
        String[] values = f.list();
        lview1 = (ListView) findViewById(R.id.lview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, values);
        lview1.setAdapter(adapter);
        lview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = lview1.getItemAtPosition(position).toString();
                path = path + text + "/";
                File f = new File(path);
                String[] values = f.list();
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, values);
                lview1.setAdapter(adapter);


            }
        });
    }
}