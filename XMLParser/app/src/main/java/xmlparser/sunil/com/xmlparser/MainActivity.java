package xmlparser.sunil.com.xmlparser;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void parse(View v){
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            InputStream ispr=getAssets().open("employees.xml");
            parser.parse(ispr,new DefaultHandler(){
                String msg="";
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    super.startElement(uri, localName, qName, attributes);
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    super.endElement(uri, localName, qName);
                    if(qName.equalsIgnoreCase("employee")){
                        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
                        msg="";
                    }

                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    super.characters(ch, start, length);
                    msg=msg+new String(ch,start,length)+"\n";
                }
            });

        }catch(Exception e){
            e.printStackTrace();
        }
    }

  public void pullParse(View v){
     String msg="";
      try {
         XmlPullParserFactory factory=XmlPullParserFactory.newInstance();
         XmlPullParser parser=factory.newPullParser();
         InputStream inputStream=getAssets().open("employees.xml");
         parser.setInput(inputStream,null);
         int type=parser.getEventType();
         while(type!=parser.END_DOCUMENT){
             if(type==parser.TEXT){
                 msg=msg+parser.getText()+"\n";
             }
             if(type==parser.END_TAG){
                if(parser.getName().equalsIgnoreCase("employee")) {
                    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
                    msg = "";
                }
             }
            type= parser.next();
         }

      } catch (Exception e) {
          e.printStackTrace();
      }
  }

    public void getCity(View v){
        Intent i=new Intent(this,Cities.class);
        startActivity(i);
    }
}
