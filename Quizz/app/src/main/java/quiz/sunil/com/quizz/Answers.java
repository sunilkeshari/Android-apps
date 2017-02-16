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
import android.widget.ListView;

public class Answers extends AppCompatActivity {

    static Answers answers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers);
        answers=this;
        ListView lv=(ListView)findViewById(R.id.lv);
        lv.setAdapter(new Adapter());

    }

}
