package xmlparser.sunil.com.xmlparser;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;

public class Cities extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities);
        Spinner sp=(Spinner)findViewById(R.id.sp);
        new FetchData().execute();
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                new FetchData().execute();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
         }

    class FetchData extends AsyncTask {
        String res;
        ArrayAdapter adapter;
        ListView lv;
        String country;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Spinner sp=(Spinner)findViewById(R.id.sp);
            country=sp.getSelectedItem().toString();
        }

        @Override
        protected Object doInBackground(Object[] params) {
            SOAPRequest request=new SOAPRequest();
            res=request.getCitiesByCountry(country);
            StringReader reader=new StringReader(res);
           try {
               XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
               XmlPullParser parser=factory.newPullParser();
               parser.setInput(reader);
               int type=parser.getEventType();
               lv=(ListView)findViewById(R.id.lv);
               ArrayList<String> arrayList=new ArrayList<String>();
              Boolean flag=false;
               while(type!=parser.END_DOCUMENT){

                   if(type==parser.TEXT){
                       if(flag){
                           arrayList.add(parser.getText());
                           flag=false;
                       }
                    }
                   if(type==parser.START_TAG){
                       if(parser.getName().equals("City")){
                           flag=true;
                       }
                   }
                   if(type==parser.END_TAG){
                       if(parser.getName().equals("City")){
                           flag=false;
                       }

                   }
                   type=parser.next();
               }

               adapter=new ArrayAdapter(Cities.this,android.R.layout.simple_spinner_dropdown_item,arrayList);

           }catch (Exception e){
               e.printStackTrace();
           }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            System.out.println(res);
            lv.setAdapter(adapter);
            Toast.makeText(Cities.this,"Executed",Toast.LENGTH_SHORT).show();

        }
    }
}
