package customadapter.sunil.com.customadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class Image_Grid extends AppCompatActivity {

    static Image_Grid img_context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image__grid);
        img_context=this;
        GridView grid=(GridView)findViewById(R.id.grid);
        grid.setAdapter(new GridAdapter());
    }
}
