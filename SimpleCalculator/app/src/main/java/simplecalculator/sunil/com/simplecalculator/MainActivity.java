package simplecalculator.sunil.com.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText first,second;
    double res,num1=0,num2=0;
    TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        first=(EditText)findViewById(R.id.first);
        second=(EditText)findViewById(R.id.second);
        output=(TextView)findViewById(R.id.res);
       }
    public int setNum(){
       try {
           num1 = Double.parseDouble(first.getText().toString().trim());
       }catch (NumberFormatException e)
       {
           output.setText("="+"Please specify a Number");
           return 0;
       }
        try {
            num2 = Double.parseDouble(second.getText().toString().trim());
        }catch (NumberFormatException e) {
            output.setText("="+"Please specify a Number");
            return 0;
        }
        return 1;
    }

    public void add(View v)
    {
        if(setNum()==1) {
            res = num1 + num2;
            output.setText("=" + String.valueOf(res));
        }
    }

    public void subtract(View v)
    {
        if(setNum()==1) {
            res = num1 - num2;
            output.setText("=" + String.valueOf(res));
        }
    }
    public void multiply(View v)
    {
        if(setNum()==1) {
            res = num1 * num2;
            output.setText("=" + String.valueOf(res));
        }
    }
    public void divide(View v)
    {
        if(setNum()==1) {
            if (num1 == 0) {
                res = 0;
                output.setText("=" + String.valueOf(res));

            } else if (num2 == 0)
                output.setText("=" + "Undefined");
            else {
                res = num1 / num2;
                output.setText("=" + String.valueOf(res));
            }
        }
    }
}
