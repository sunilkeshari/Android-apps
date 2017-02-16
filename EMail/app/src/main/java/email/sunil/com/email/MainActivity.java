package email.sunil.com.email;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Uri u;
    EditText to,sub,msg;
    static MainActivity mainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivity=this;
        Button attach,send;
        to=(EditText)findViewById(R.id.to);
        sub=(EditText)findViewById(R.id.subject);
        msg=(EditText)findViewById(R.id.message);
        attach=(Button)findViewById(R.id.attach);
        attach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();
                i.setAction(Intent.ACTION_GET_CONTENT);
                i.setType("*/*");
                startActivityForResult(i,123);
            }
        });
        send=(Button)findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();
                i.setAction(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_EMAIL,new String[]{to.getText().toString()});
                i.putExtra(Intent.EXTRA_SUBJECT,sub.getText().toString());
                i.putExtra(Intent.EXTRA_TEXT,msg.getText().toString());
                i.putExtra(Intent.EXTRA_STREAM,u);
                i.setType("message/rfc822");
                startActivity(i.createChooser(i,"Choose app to send"));
            }
        });

        Button jmail=(Button)findViewById(R.id.jmail);
       /*final String[] mailid=getResources().getStringArray(R.array.mails);
        final String text=getResources().getString(R.string.text);
       */ jmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
         //       for(int i=0;i<mailid.length;i++) {
                    LongOperation task = new LongOperation("", sub.getText().toString(), "");
                    task.execute();
                    /*to.setText("");
                    sub.setText("");
                    msg.setText("");*/
           /*         try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
           */    // }
                Toast.makeText(MainActivity.this,"sent mail from sunilkeshari61@gmail.com",Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        u=data.getData();
    }
}
