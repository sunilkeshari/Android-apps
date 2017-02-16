package musicplayer.sunil.com.musicplayer;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Sonu on 2/11/2017.
 */

public class MyAdapter extends BaseAdapter {

    ArrayList<HashMap<String,String>> songlist;

    @Override
    public int getCount() {
        songlist=new logic().getPlayList("/storage/sdcard1/Music/");
        if(songlist!=null)
            return songlist.size();
        else
            return 0;
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
        LayoutInflater inflater=LayoutInflater.from(SongsList.songsList);
        View v=inflater.inflate(R.layout.lview,null);
        TextView fname=(TextView)v.findViewById(R.id.filename);
        final TextView fpath=(TextView)v.findViewById(R.id.filepath);
        fname.setText(songlist.get(position).get("file_name"));
        fpath.setText(songlist.get(position).get("file_path"));
        Button play=(Button)v.findViewById(R.id.play);
        final int pos=position;
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp=SongsList.songsList.getSharedPreferences("song", Context.MODE_PRIVATE);
                SharedPreferences.Editor spe=sp.edit();
                spe.putString("path",songlist.get(pos).get("file_path"));
                spe.commit();
                SongsList.songsList.finish();

            }
        });
        return v;
    }
}
