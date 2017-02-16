package customadapter.sunil.com.customadapter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by Sonu on 1/31/2017.
 */

public class MyAdapter extends BaseAdapter {
    String path="/storage/sdcard1/DCIM/Facebook/";
    File f=new File(path);
    String[] values=f.list();
    @Override
    public int getCount() {
        int num=values.length;
        return num;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    TextView fname;
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflator=LayoutInflater.from(MainActivity.mActivity);
        View v=inflator.inflate(R.layout.customlayout,null);
        ImageView imv=(ImageView)v.findViewById(R.id.imv);
        fname=(TextView)v.findViewById(R.id.fname);
        TextView fsize=(TextView)v.findViewById(R.id.fsize);
        final File new_f=new File(path+values[position]);
        //imv.setImageURI(Uri.fromFile(new_f));
     try {
         FileInputStream fis = new FileInputStream(new_f);
         Bitmap b= BitmapFactory.decodeStream(fis);
         imv.setImageBitmap(b);
         imv.setScaleType(ImageView.ScaleType.CENTER_CROP);
     }catch(Exception e){
         e.printStackTrace();
     }
        fname.setText(values[position]);
        fsize.setText(new_f.length()/1024+" KB");
        Button del=(Button)v.findViewById(R.id.delete);
        Button show=(Button)v.findViewById(R.id.show);
        del.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                new_f.delete();
                MainActivity.mActivity.refresh();
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.mActivity,ShowImage.class);
                i.putExtra("path",path);
                i.putExtra("fname",values[position]);
                MainActivity.mActivity.startActivity(i);

            }
        });



        return v;
    }
}
