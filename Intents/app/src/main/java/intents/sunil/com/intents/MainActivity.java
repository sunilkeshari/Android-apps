package intents.sunil.com.intents;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1=(Button)findViewById(R.id.b1);
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et=(EditText)findViewById(R.id.et1);
                Intent i=new Intent();
                i.setData(Uri.parse("tel:"+et.getText().toString()));
                i.setAction(Intent.ACTION_DIAL);
                startActivity(i);
            }
        };
        b1.setOnClickListener(listener);
;
        Button b3=(Button)findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i=new Intent();
                i.setAction(Intent.ACTION_GET_CONTENT);
                i.setType("image/*");
                startActivity(i);
            }
        });
        Button b4=(Button)findViewById(R.id.b4);
        b4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i=new Intent();
                i.setAction(Intent.ACTION_GET_CONTENT);
                i.setType("audio/*");
                startActivity(i);
            }
        });
        Button b5=(Button)findViewById(R.id.b5);
        b5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i=new Intent();
                i.setAction(Intent.ACTION_GET_CONTENT);
                i.setType("video/*");
                startActivity(i);
            }
        });
        Button b6=(Button)findViewById(R.id.b6);
        b6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i=new Intent();
                i.setAction(Intent.ACTION_GET_CONTENT);
                i.setType("*/*");
                startActivity(i);
            }
        });
        Button b7=(Button)findViewById(R.id.b7);
        b7.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i=new Intent(getApplicationContext(),Welcome.class);
                startActivity(i);
            }
        });
        Button b8=(Button)findViewById(R.id.b8);
        b8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i=getPackageManager().getLaunchIntentForPackage("com.whatsapp");
                if(i.resolveActivity(getPackageManager())!=null)
                startActivity(i);
            }
        });
        Button b9=(Button)findViewById(R.id.b9);
        b9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
               // Intent i=getPackageManager().getLaunchIntentForPackage("com.google.anroid.apps.maps");
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("geo:17.3850,78.4867"));
                if(i.resolveActivity(getPackageManager())!=null)
                   startActivity(i);

            }
        });
        Button b10=(Button)findViewById(R.id.b10);
        b10.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent chooser=null;
                Intent i=new Intent(Intent.ACTION_VIEW);
                chooser=Intent.createChooser(i,"Market");
                i.setData(Uri.parse("market://details?id=com.facebook.katana&hl=en"));
                startActivity(chooser);
            }
        });
        Button call=(Button)findViewById(R.id.call);
        call.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText et=(EditText)findViewById(R.id.et1);
                Intent i=new Intent();
                i.setAction(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:"+et.getText().toString()));
                startActivity(i);
            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation==Configuration.ORIENTATION_PORTRAIT)
            setContentView(R.layout.activity_main);
        else if(newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE)
            setContentView(R.layout.activity_main);
    }
}
