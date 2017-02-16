package fragments.sunil.com.fragments;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Communicator {

    android.app.FragmentManager fmanager;
    FragmentTransaction tx;
    static MainActivity mainActivity;
    static String uname,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivity=this;
        fmanager=getFragmentManager();
        tx=fmanager.beginTransaction();
        tx.add(R.id.flayout,new Fragment1());
        tx.commit();
    }
    public void process(View v){
        if(v.getId()==R.id.b1)
        {
            tx=fmanager.beginTransaction();
            tx.replace(R.id.flayout,new Fragment1());
            tx.commit();
        }
        else if(v.getId()==R.id.b2)
        {
            tx=fmanager.beginTransaction();
            tx.replace(R.id.flayout,new Fragment3());
            tx.commit();
        }
        else if(v.getId()==R.id.b3)
        {
           Intent i=new Intent(MainActivity.this,singlepagefragments.class);
            startActivity(i);

        }
    }

    @Override
    public void respond(String uname,String pass) {
        android.app.FragmentManager manager=getFragmentManager();
        this.uname=uname;
        this.pass=pass;
      //  Toast.makeText(this,uname+"\n"+pass,Toast.LENGTH_LONG).show();

        FragmentTransaction tx=manager.beginTransaction();
        Fragment2 f2=new Fragment2();
        tx.add(R.id.flayout,f2);
        tx.commit();

        }

}
