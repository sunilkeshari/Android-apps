package simplecalculator.sunil.com.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.images);
        ImageView image=(ImageView)findViewById(R.id.image);
        image.setImageResource(R.drawable.image);
    }
}
