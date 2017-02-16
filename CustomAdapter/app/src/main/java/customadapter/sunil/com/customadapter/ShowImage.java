package customadapter.sunil.com.customadapter;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class ShowImage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);
        String path=getIntent().getStringExtra("path");
        String fname=getIntent().getStringExtra("fname");
        File f=new File(path+fname);
        ImageView img=(ImageView)findViewById(R.id.img1);
        img.setImageURI(Uri.fromFile(f));
        TextView tv=(TextView)findViewById(R.id.tv1);
        tv.setText(fname);

    }
}
