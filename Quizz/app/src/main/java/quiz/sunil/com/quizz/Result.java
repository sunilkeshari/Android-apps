package quiz.sunil.com.quizz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        SharedPreferences sp=getSharedPreferences("result", Context.MODE_PRIVATE);
        TextView tv=(TextView)findViewById(R.id.res);
        tv.setText("Your Score is "+sp.getInt("score",0)+" out of 10");
    }
    public  void showans(View v){
        Intent i=new Intent(Result.this,Answers.class);
        startActivity(i);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK)
        {
                    SharedPreferences sp=getSharedPreferences("result",Context.MODE_PRIVATE);
                    SharedPreferences.Editor spe=sp.edit();
                    spe.putInt("score",0);
                    spe.commit();
                    Intent i=new Intent(getBaseContext(),MainActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);

        }
        return super.onKeyDown(keyCode, event);
    }


}
