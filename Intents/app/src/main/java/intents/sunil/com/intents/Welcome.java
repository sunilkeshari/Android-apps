package intents.sunil.com.intents;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

public class Welcome extends AppCompatActivity {

    EditText fname,lname;
    String first,last;
    ArrayAdapter<String> adapter;
    AutoCompleteTextView country;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Button button=(Button)findViewById(R.id.button);
        country=(AutoCompleteTextView)findViewById(R.id.country);
        String[] values=getResources().getStringArray(R.array.countries);
        adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,values);
        country.setAdapter(adapter);
        country.setThreshold(1);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
               fname=(EditText)findViewById(R.id.fname);
               lname=(EditText)findViewById(R.id.lname);
                //  String[] values={"America","Australia","Antarctica","Brazil","Brussels","India","Iran","Indonesia"};
                first=fname.getText().toString();
                last=lname.getText().toString();
                Intent i=new Intent();
                i.setComponent(new ComponentName(getApplicationContext(),ShowDetails.class));
                i.putExtra("fname",first);
                i.putExtra("lname",last);
                i.putExtra("country",country.getText().toString());
                startActivity(i);
            }
        });
    }
}
