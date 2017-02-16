package quiz.sunil.com.quizz;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Sonu on 2/10/2017.
 */

public class Adapter extends BaseAdapter {
    SharedPreferences sp;
    SharedPreferences.Editor spe;
    String[] ques;
    @Override
    public int getCount() {
      //  Toast.makeText(Answers.answers,"tttttt",Toast.LENGTH_LONG).show();
        sp=Answers.answers.getSharedPreferences("result", Context.MODE_PRIVATE);
        int type=sp.getInt("type",0);
        if(type==1){
            ques=Answers.answers.getResources().getStringArray(R.array.cricket_question);
            return ques.length;
        }
        else if(type==2){

        }
        else{

        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(Answers.answers);
        View v=inflater.inflate(R.layout.indilayout,null);
        TextView quest=(TextView)v.findViewById(R.id.ques);
        TextView ans=(TextView)v.findViewById(R.id.ans);
        String[] answer=Answers.answers.getResources().getStringArray(R.array.cric_ans);
        quest.setText((position+1)+") "+ques[position]);
        ans.setText(answer[position]);
        return v;
    }
}
