package musicplayer.sunil.com.musicplayer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mplayer=null;
    static MainActivity mainActivity;
    Uri u;
    final Handler handler=new Handler();
    SharedPreferences sp;
    SharedPreferences.Editor spe;
    SeekBar sbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivity=this;
        sbar=(SeekBar)findViewById(R.id.seekbar);
        sp=getSharedPreferences("song",Context.MODE_PRIVATE);
        if(mplayer!=null)
        {
            mplayer.stop();
            mplayer=null;
        }

       try {
          if(!sp.getString("path","no path").equals("no path")) {
              mplayer=new MediaPlayer();
              mplayer.setDataSource(sp.getString("path", "no path"));
              mplayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
              mplayer.prepare();
          }
           else{

              mplayer=MediaPlayer.create(this,R.raw.file);
              Toast.makeText(this,"Playing default song",Toast.LENGTH_SHORT).show();
          }
       }catch (Exception e){
           Toast.makeText(this,"exce",Toast.LENGTH_LONG).show();
           e.printStackTrace();
       }

    }

    @Override
   protected void onStart() {
        super.onStart();
        mplayer.stop();
        mplayer=null;
        sp=getSharedPreferences("song",Context.MODE_PRIVATE);
          try {
            if(!sp.getString("path","no path").equals("no path")) {
                mplayer=new MediaPlayer();
                mplayer.setDataSource(sp.getString("path", "no path"));
                mplayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mplayer.prepare();
            }
            else{
                mplayer=MediaPlayer.create(this,R.raw.file);
                Toast.makeText(this,"Playing default song",Toast.LENGTH_SHORT).show();
            }
            sbar.setMax(mplayer.getDuration());
            sbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    mplayer.seekTo(progress);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
            sbar.setProgress(mplayer.getCurrentPosition());
           update();
        }catch (Exception e){
            Toast.makeText(this,"exce",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

}
    public void update(){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               sbar.setProgress(mplayer.getCurrentPosition());
                update();
            }
        },1000);
    }


    public void play(View v)
    {
        mplayer.start();
        sbar.setProgress(mplayer.getCurrentPosition());
        Toast.makeText(MainActivity.this, "Playing", Toast.LENGTH_SHORT).show();
    }

    public void pause(View v){
         mplayer.pause();
    }

    public void stop(View v){
       mplayer.stop();
       try{
        if(!sp.getString("path","no path").equals("no path")) {
            mplayer=new MediaPlayer();
            mplayer.setDataSource(sp.getString("path", "no path"));
            mplayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mplayer.prepare();
        }
        else{
            Thread.sleep(3000);
            mplayer=MediaPlayer.create(this,R.raw.file);
            Toast.makeText(this,"Playing default song",Toast.LENGTH_SHORT).show();
        }
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    public void forward(View v){
      mplayer.seekTo(mplayer.getCurrentPosition()+mplayer.getDuration()/10);
    }

    public void previous(View v){
      mplayer.seekTo(mplayer.getCurrentPosition()-mplayer.getDuration()/10);
    }
    public void close(View v){
        mplayer.stop();
        finish();
    }

    public void choose(View v){
       /* Intent i=new Intent();
        i.setAction(Intent.ACTION_GET_CONTENT);
        i.setType("audio*//*");
        startActivityForResult(i,123);
*/      Intent i=new Intent(MainActivity.this,SongsList.class);
        startActivity(i);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        u=data.getData();
        try {
            mplayer=new MediaPlayer();
            mplayer.setDataSource(u.getPath());
            sp=getSharedPreferences("song", Context.MODE_PRIVATE);
            spe=sp.edit();
            spe.putString("path",u.getPath());
            spe.commit();
            mplayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mplayer.prepare();
            mplayer.start();
            Toast.makeText(this,"Playing song",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
