package customadapter.sunil.com.customadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lview;
    static MainActivity mActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActivity=this;
        lview=(ListView)findViewById(R.id.lview);
        lview.setAdapter(new MyAdapter());

    }
    public void refresh(){
      lview.setAdapter(new MyAdapter());
    }
}
