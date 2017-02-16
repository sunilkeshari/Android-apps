package customadapter.sunil.com.customadapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.VideoView;

import java.io.File;

/**
 * Created by Sonu on 2/1/2017.
 */

public class GalleryAdapter extends BaseAdapter {

    String path="/storage/sdcard1/SHAREit/videos/";
    File f=new File(path);
    String[] videos=f.list();
    VideoView vview;
    @Override
    public int getCount() {
        return videos.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater=LayoutInflater.from(VideoHome.video);
        View v=inflater.inflate(R.layout.indi_view,null);
        CheckBox cb=(CheckBox)v.findViewById(R.id.cb1);
        cb.setText(videos[position]);
        final String newPath=path+videos[position];
        vview=(VideoView)v.findViewById(R.id.vidview);
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

               /* File new_f=new File(newPath);
                vview.setVideoURI(Uri.fromFile(new_f));*/
                vview.setVideoPath(newPath);
                if(isChecked)
                    vview.start();
                else
                    vview.stopPlayback();
            }
        });

        return v;
    }
}
