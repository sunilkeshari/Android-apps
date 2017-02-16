package videoview.sunil.com.videoview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VideoView vview=(VideoView)findViewById(R.id.vview);
        vview.setVideoPath("/storage/sdcard1/SHAREit/videos/accenture.mp4");
        vview.setMediaController(new MediaController(this));
        vview.start();
    }
}
