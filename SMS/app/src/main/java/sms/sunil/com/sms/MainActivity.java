package sms.sunil.com.sms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText to,msg;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        to=(EditText)findViewById(R.id.to);
        msg=(EditText)findViewById(R.id.message);
        send=(Button)findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                SmsManager smsManager=SmsManager.getDefault();
                smsManager.sendTextMessage(to.getText().toString(),null,msg.getText().toString(),null,null);
                Toast.makeText(MainActivity.this,"Message sent",Toast.LENGTH_LONG).show();
            }
        });
    }
}
