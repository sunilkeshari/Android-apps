package customadapter.sunil.com.customadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Gallery;

public class VideoHome extends AppCompatActivity {

    static VideoHome video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_home);
        video=this;
        Gallery g1=(Gallery)findViewById(R.id.gal);
        g1.setAdapter(new GalleryAdapter());

    }
}
