package fragments.sunil.com.fragments;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class singlepagefragments extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singlepagefragments);
        getFragmentManager().beginTransaction().add(R.id.f1,new FirstFragment()).commit();
    }
}
