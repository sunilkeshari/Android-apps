package asynctask.sunil.com.asynctask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Button b;
    ImageView iview;
    ProgressBar pbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iview=(ImageView)findViewById(R.id.iview);
        b=(Button)findViewById(R.id.b1);
        pbar=(ProgressBar)findViewById(R.id.pbar);
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        pbar.setVisibility(View.GONE);
    }
    public void show(View v){
        new FetchImage().execute();
    }
    class FetchImage extends AsyncTask{
        InputStream istr;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
           iview.setVisibility(View.GONE);
            pbar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Object doInBackground(Object[] params) {
           try {
               URL u = new URL("https://www.apple.com/ac/structured-data/images/knowledge_graph_logo.png?201701231950");
               istr=u.openStream();
           }catch (Exception e){
               e.printStackTrace();
           }
               return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            Bitmap bmp= BitmapFactory.decodeStream(istr);
            pbar.setVisibility(View.GONE);
            iview.setVisibility(View.VISIBLE);
            iview.setImageBitmap(bmp);

        }
    }
}
