package videorecorder.sunil.com.videorecorder;

import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaRecorder recorder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void init(){
     recorder=new MediaRecorder();
      recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
      recorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
      CamcorderProfile profile=CamcorderProfile.get(CamcorderProfile.QUALITY_HIGH);
      recorder.setProfile(profile);
      recorder.setOutputFile("/storage/sdcard0/video_"+ System.currentTimeMillis()+".mp4");
      SurfaceView sview=(SurfaceView)findViewById(R.id.sview);
      SurfaceHolder sholder=sview.getHolder();
      recorder.setPreviewDisplay(sholder.getSurface());
        try{
            recorder.prepare();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void record(View v){
      init();
        recorder.start();
        Toast.makeText(this,"Recording",Toast.LENGTH_LONG).show();
    }

    public void stop(View v){
     recorder.stop();
        Toast.makeText(this,"Stopped",Toast.LENGTH_LONG).show();
    }
}
