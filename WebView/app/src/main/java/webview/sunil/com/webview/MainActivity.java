package webview.sunil.com.webview;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    WebView wview;
    AutoCompleteTextView url;
   Boolean flag=false;
    ProgressBar pg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] values={"www.facebook.com","www.google.com"};
        url=(AutoCompleteTextView)findViewById(R.id.url);
        Button search=(Button)findViewById(R.id.search);
        pg=(ProgressBar)findViewById(R.id.pgbar);
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,values);
        url.setAdapter(adapter);
        wview=(WebView)findViewById(R.id.web);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        wview.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                pg.setVisibility(View.VISIBLE);
                wview.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this,"Page is Loading",Toast.LENGTH_SHORT).show();
            }


            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
               //Toast.makeText(MainActivity.this,url,Toast.LENGTH_SHORT).show();
                return super.shouldOverrideUrlLoading(view, url);

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                pg.setVisibility(View.GONE);
                wview.setVisibility(View.VISIBLE);
                //Toast.makeText(MainActivity.this,"Page Loaded",Toast.LENGTH_SHORT).show();
                flag=true;
            }
        });
        wview.getSettings().setJavaScriptEnabled(true);
        wview.getSettings().setBuiltInZoomControls(true);
        wview.loadUrl("http://google.com");
        wview.addJavascriptInterface(MainActivity.this,"login_interface");
    }



    @JavascriptInterface
    public void display(String uname,String pass){

        Toast.makeText(MainActivity.this,uname+"  "+pass,Toast.LENGTH_LONG).show();

    }
    public void process(View v)
    {
       switch(v.getId()){
           case R.id.search:
                   wview.loadUrl("http://"+url.getText().toString());
               break;
           case R.id.facebook:
               url.setText("");
               wview.loadUrl("http://www.facebook.com");
               break;
           case R.id.google:
               url.setText("");
               wview.loadUrl("http://www.google.com");
               break;
           case R.id.youtube:
               url.setText("");
               wview.loadUrl("http://www.youtube.com");
               break;
           case R.id.html:
               wview.loadUrl("file:///android_asset/index.html");
               break;
       }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode==KeyEvent.KEYCODE_BACK) && wview.canGoBack()){
            wview.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);

    }
}
