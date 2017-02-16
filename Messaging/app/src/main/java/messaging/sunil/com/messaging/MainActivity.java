package messaging.sunil.com.messaging;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v4.content.ContentResolverCompat;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     }

    public void inbox(View v){
        ContentResolver resolver=getContentResolver();
        Uri uri = Uri.parse("content://sms/inbox");
        Cursor c=resolver.query(uri,null,null,null,null);
        SimpleCursorAdapter adapter=new SimpleCursorAdapter(this,R.layout.indiview,c,new String[]{"address","body",},new int[]{R.id.tv1,R.id.tv2});
        ListView lv=(ListView)findViewById(R.id.lv);
        lv.setAdapter(adapter);
    }
    public void sent(View v){

        ContentResolver resolver=getContentResolver();
        Uri uri = Uri.parse("content://sms/sent");
        Cursor c=resolver.query(uri,null,null,null,null);
        SimpleCursorAdapter adapter=new SimpleCursorAdapter(this,R.layout.indiview,c,new String[]{"address","body",},new int[]{R.id.tv1,R.id.tv2});
        ListView lv=(ListView)findViewById(R.id.lv);
        lv.setAdapter(adapter);
    }
    public void draft(View v){
        ContentResolver resolver=getContentResolver();
        Uri uri = Uri.parse("content://sms/draft");
        Cursor c=resolver.query(uri,null,null,null,null);
        SimpleCursorAdapter adapter=new SimpleCursorAdapter(this,R.layout.indiview,c,new String[]{"address","body",},new int[]{R.id.tv1,R.id.tv2});
        ListView lv=(ListView)findViewById(R.id.lv);
        lv.setAdapter(adapter);
    }

    public void send(View v){
        Intent i=new Intent(this,Contacts.class);
        startActivity(i);
    }
}
