package listfiles.sunil.com.listfiles;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    static MainActivity mainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivity=this;
     /*   Toast.makeText(this,"started",Toast.LENGTH_SHORT).show();
        ListView lv=(ListView)findViewById(R.id.lv);
        lv.setAdapter(new MyAdapter());
       Toast.makeText(this,"Loaded",Toast.LENGTH_LONG).show();
      */
        ass ob=new ass();
        ob.execute();
    }

    class ass extends AsyncTask{
        @Override
        protected Object doInBackground(Object[] params) {
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            Toast.makeText(MainActivity.this,"started",Toast.LENGTH_LONG).show();
          ListView lv=(ListView)findViewById(R.id.lv);
            lv.setAdapter(new MyAdapter());
            Toast.makeText(MainActivity.this,"Loaded",Toast.LENGTH_LONG).show();

        }
    }


}
