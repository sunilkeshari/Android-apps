package listfiles.sunil.com.listfiles;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Sonu on 2/10/2017.
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
        LayoutInflater inflater=LayoutInflater.from(MainActivity.mainActivity);
        View v=inflater.inflate(R.layout.lview,null);
        TextView fname=(TextView)v.findViewById(R.id.filename);
        TextView fpath=(TextView)v.findViewById(R.id.filepath);
        fname.setText("File Name- "+songlist.get(position).get("file_name"));
        fpath.setText("File Path- "+songlist.get(position).get("file_path"));
        return v;
    }
}
