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
import android.widget.Toast;

import org.w3c.dom.Text;

public class Home extends AppCompatActivity implements View.OnClickListener {

    TextView qno,question,heading;
    Button o1,o2,o3,o4;
    int looper,position,noofques;
    SharedPreferences sp;
    SharedPreferences.Editor spe;
    String[] ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        looper=0;
        String type=getIntent().getStringExtra("type");
        heading=(TextView) findViewById(R.id.type);
        qno=(TextView)findViewById(R.id.qno);
        question=(TextView)findViewById(R.id.question);
        sp=getSharedPreferences("result", Context.MODE_PRIVATE);
        spe=sp.edit();
        spe.putInt("score",0);
        if(type.equals("1"))
        {
            spe.putInt("type",1);
            spe.commit();
            heading.setText("CRICKET");
            ans=getResources().getStringArray(R.array.cric_ans);
            processCricket(0);
        }
        if(type.equals("2"))
        {

        }

    }

    public void processCricket(int pos){
        String [] questions=getResources().getStringArray(R.array.cricket_question);
        noofques=questions.length;
        showCricket(pos);

    }
    public void showCricket(int pos){
        String [] questions=getResources().getStringArray(R.array.cricket_question);
        noofques=questions.length;
        String ques=questions[pos];
        o1=(Button)findViewById(R.id.option1);
        o2=(Button)findViewById(R.id.option2);
        o3=(Button)findViewById(R.id.option3);
        o4=(Button)findViewById(R.id.option4);
        qno.setText("Question "+(pos+1));
        question.setText(ques);
        String[] options=getResources().getStringArray(R.array.cric_options);
        o1.setText(options[looper++]);
        o2.setText(options[looper++]);
        o3.setText(options[looper++]);
        o4.setText(options[looper++]);
        position=pos;
        o1.setOnClickListener(this);
        o2.setOnClickListener(this);
        o3.setOnClickListener(this);
        o4.setOnClickListener(this);

    }
    public void onClick(View v){
        Button opt=(Button)findViewById(v.getId());
     //   Toast.makeText(this,"Clicked"+opt.getText(),Toast.LENGTH_LONG).show();
        if(opt.getText().equals(ans[position])){
            int score=sp.getInt("score",0);
            spe.putInt("score",++score);
            spe.commit();
        }
        if(position<noofques-1)
            showCricket(++position);
        else{
            startActivity(new Intent(this,Result.class));
            finish();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK)
        {
            AlertDialog.Builder mbuilder=new AlertDialog.Builder(Home.this);
            View v=getLayoutInflater().inflate(R.layout.quizdialog,null);
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
                    spe.putInt("score",0);
                    spe.commit();
                    finish();

                }
            });
        }
        return super.onKeyDown(keyCode, event);
    }
}
