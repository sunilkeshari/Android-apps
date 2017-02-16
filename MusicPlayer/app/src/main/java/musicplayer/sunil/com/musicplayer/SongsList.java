package musicplayer.sunil.com.musicplayer;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class SongsList extends AppCompatActivity {

    static SongsList songsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs_list);
        songsList=this;
        new myTask().execute();
    }

    class myTask extends AsyncTask {
        @Override
        protected Object doInBackground(Object[] params) {
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            ListView lv=(ListView)findViewById(R.id.lv);
            lv.setAdapter(new MyAdapter());
        }
    }
}
