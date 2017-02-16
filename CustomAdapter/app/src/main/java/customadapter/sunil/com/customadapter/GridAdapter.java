package customadapter.sunil.com.customadapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

/**
 * Created by Sonu on 2/2/2017.
 */

public class GridAdapter extends BaseAdapter {
    String path="/storage/sdcard1/DCIM/Facebook/";
    File f=new File(path);
    String files[]=f.list();
    @Override
    public int getCount() {
        return files.length;
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
        LayoutInflater inflater=LayoutInflater.from(Image_Grid.img_context);
        View v=inflater.inflate(R.layout.gridview,null);
        TextView tv=(TextView)v.findViewById(R.id.fname);
        tv.setText(files[position]);
        ImageView img=(ImageView)v.findViewById(R.id.img);
        File new_f=new File(path+files[position]);
        img.setImageURI(Uri.fromFile(new_f));
        img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return v;
    }
}
