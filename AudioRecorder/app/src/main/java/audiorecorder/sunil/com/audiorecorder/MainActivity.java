package audiorecorder.sunil.com.audiorecorder;

import android.media.MediaRecorder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

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
        recorder.setOutputFormat(MediaRecorder.OutputFormat.AMR_NB);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        recorder.setOutputFile("/storage/sdcard0/audio"+System.currentTimeMillis()+".amr");
        recorder.setMaxDuration(10000);
        recorder.setMaxFileSize(1024*1024*10);

        try {
            recorder.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }

    public void start(View v){
      init();
      recorder.start();
        Toast.makeText(this,"Recording started",Toast.LENGTH_LONG).show();
        recorder.setOnInfoListener(new MediaRecorder.OnInfoListener() {
            @Override
            public void onInfo(MediaRecorder mr, int what, int extra) {
                if(what==MediaRecorder.MEDIA_RECORDER_INFO_MAX_DURATION_REACHED){
                    Toast.makeText(MainActivity.this,"Max Duration Reached",Toast.LENGTH_LONG).show();
                    recorder.stop();
                }
                else if(what==MediaRecorder.MEDIA_RECORDER_INFO_MAX_FILESIZE_REACHED){
                    Toast.makeText(MainActivity.this,"Max File Size Reached",Toast.LENGTH_LONG).show();
                    recorder.stop();
                }
            }
        });
            }

    public void stop(View v){
      recorder.stop();
        Toast.makeText(this,"Recording Stopped",Toast.LENGTH_LONG).show();
    }
}
