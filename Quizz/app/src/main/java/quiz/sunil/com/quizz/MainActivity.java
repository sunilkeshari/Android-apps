package quiz.sunil.com.quizz;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
             final AlertDialog.Builder mbuilder=new AlertDialog.Builder(MainActivity.this);
            View v=getLayoutInflater().inflate(R.layout.dialog,null);
            Button no=(Button)v.findViewById(R.id.no);
            Button yes=(Button)v.findViewById(R.id.yes);
            mbuilder.setView(v);
            final AlertDialog dialog=mbuilder.create();
            dialog.show();
            no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

        }
        return super.onKeyDown(keyCode, event);
    }

    public void cricket(View v){
        i=new Intent(this,Home.class);
        i.putExtra("type","1");
        startActivity(i);
    }

    public void politics(View v){
      /*  i=new Intent(this,Home.class);
        i.putExtra("type","2");
        startActivity(i);*/
        Toast.makeText(this,"Coming soon",Toast.LENGTH_LONG).show();

    }

    public void gk(View v){
        Toast.makeText(this,"Coming soon",Toast.LENGTH_LONG).show();

    }
}
