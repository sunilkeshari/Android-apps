package sqlite.sunil.com.sqlitetest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase dbase;
    EditText empid,ename,desig,sal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        empid=(EditText)findViewById(R.id.ed1);
        ename=(EditText)findViewById(R.id.ed2);
        desig=(EditText)findViewById(R.id.ed3);
        sal=(EditText)findViewById(R.id.ed4);
        dbase=openOrCreateDatabase("empdb", Context.MODE_PRIVATE,null);
        dbase.execSQL("Create table if not exists emp(eid number,ename varchar(50),desig varchar(50),sal number)");
    }

    public void insert(View v){
        ContentValues values=new ContentValues();
        values.put("eid",empid.getText().toString());
        values.put("ename",ename.getText().toString());
        values.put("desig",desig.getText().toString());
        values.put("sal",sal.getText().toString());
      long count= dbase.insert("emp",null,values);
      if(count>0) {
          Toast.makeText(this, "Inserted", Toast.LENGTH_SHORT).show();
          empid.setText("");
          ename.setText("");
          desig.setText("");
          sal.setText("");
      }
        else{
          Toast.makeText(this,"Failed to insert",Toast.LENGTH_SHORT).show();
      }
    }

    public void read(View v){

       Cursor c= dbase.query("emp",null,null,null,null,null,null);
        while(c.moveToNext()){
            Toast.makeText(this,c.getInt(0)+"\n"+c.getString(1)+"\n"+c.getString(2)+"\n"+c.getInt(3),Toast.LENGTH_LONG).show();
        }

    }

    public void delete(View v){
     int count=dbase.delete("emp","eid=?",new String[]{empid.getText().toString()});
      if(count>0){
          Toast.makeText(this,"Deleted Successfully",Toast.LENGTH_LONG).show();
      }else{
          Toast.makeText(this,"FAILED to delete",Toast.LENGTH_LONG).show();
      }

    }

    public void update(View v){
        ContentValues values=new ContentValues();
        values.put("ename",ename.getText().toString());
        int t=dbase.update("emp",values,"eid=?",new String[]{empid.getText().toString()});
        if(t>0){
            Toast.makeText(this,"Updated Successfully",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"Failed to update",Toast.LENGTH_LONG).show();
        }
    }
}
