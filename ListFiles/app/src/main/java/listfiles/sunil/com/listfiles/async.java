package listfiles.sunil.com.listfiles;

import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Sonu on 2/11/2017.
 */

public class async extends AsyncTask {
    @Override
    protected Object doInBackground(Object[] params) {

        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        LayoutInflater inflater=LayoutInflater.from(MainActivity.mainActivity);
        View v=inflater.inflate(R.layout.activity_main,null);
        Toast.makeText(MainActivity.mainActivity,"started",Toast.LENGTH_SHORT).show();
        ListView lv=(ListView)v.findViewById(R.id.lv);
        lv.setAdapter(new MyAdapter());
        Toast.makeText(MainActivity.mainActivity,"Loaded",Toast.LENGTH_SHORT).show();
        }
}
