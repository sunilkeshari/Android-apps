package messaging.sunil.com.messaging;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Message extends AppCompatActivity {

    EditText num,msg;
    String number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        number= getIntent().getStringExtra("number");

        num=(EditText)findViewById(R.id.et1);
        msg=(EditText)findViewById(R.id.et2);
        num.setText(number);
    }
    public void send(View v){
        SmsManager smsManager=SmsManager.getDefault();
        smsManager.sendTextMessage(number,null,msg.getText().toString(),null,null);
        Toast.makeText(this,"Message Sent",Toast.LENGTH_LONG).show();
        finish();
    }
}
