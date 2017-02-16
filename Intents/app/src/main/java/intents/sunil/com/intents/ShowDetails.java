package intents.sunil.com.intents;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Sonu on 1/27/2017.
 */

public class ShowDetails extends android.app.Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formdetails);
        String fname=getIntent().getStringExtra("fname");
        String lname=getIntent().getStringExtra("lname");
        String country=getIntent().getStringExtra("country");
        TextView tv1=(TextView)findViewById(R.id.fname);
        TextView tv2=(TextView)findViewById(R.id.lname);
        TextView tv3=(TextView)findViewById(R.id.country);
        tv1.setText("First Name- "+fname);
        tv2.setText("Last Name- "+lname);
        tv3.setText("Country- "+country);

    }
}
