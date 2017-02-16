package cameragallery.sunil.com.cameragallery;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView iview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iview=(ImageView)findViewById(R.id.iview);
    }

    public void camera(View v){
        Intent i=new Intent("android.media.action.IMAGE_CAPTURE");
        startActivityForResult(i,123);
    }
    public void gallery(View v){
        Intent i=new Intent();
        i.setAction(Intent.ACTION_GET_CONTENT);
        i.setType("image/*");
        startActivityForResult(i,124);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==123){
            Bitmap bmp=(Bitmap)data.getExtras().get("data");
            iview.setImageBitmap(bmp);
        }
        if(requestCode==124){
            Uri u=data.getData();
            iview.setImageURI(u);
        }

    }
}
