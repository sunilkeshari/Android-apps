package jsonparser.sunil.com.jsonparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    EditText id,name,dept;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id=(EditText)findViewById(R.id.id);
        name=(EditText)findViewById(R.id.name);
        dept=(EditText)findViewById(R.id.dept);
    }

    public void write(View v)
    {
        Student s=new Student();
        s.setId(id.getText().toString());
        s.setName(name.getText().toString());
        s.setDept(dept.getText().toString());
        ArrayList<Student > list=new ArrayList<>();
        list.add(s);
        Students students=new Students();
        students.setList(list);
        Gson gson=new Gson();
        String json=gson.toJson(students);
       try {
           FileWriter writer = new FileWriter("/storage/sdcard0/file.json");
           writer.write(json);
           writer.flush();
           writer.close();
       }catch (Exception e){
           e.printStackTrace();
       }


    }
    public void read(View v)
    {
    try {
        FileReader reader = new FileReader("/storage//sdcard0/file.json");
        Gson gson = new Gson();
        Students stu = new Students();
        stu = gson.fromJson(reader, Students.class);
        ListIterator iterator=stu.getList().listIterator();
        while(iterator.hasNext()){
            Student s=(Student) iterator.next();
            Toast.makeText(this,s.getId()+"\n"+s.getName()+"\n"+s.getDept(),Toast.LENGTH_LONG).show();
        }
    }catch (Exception e){
        e.printStackTrace();
    }
    }

    public void writejson(View v){
        JSONObject object,student;
        JSONArray array;
        try {
            String path="/storage/sdcard0/jsonfile.json";
            File f=new File(path);
            if(f.exists()){
                FileReader reader=new FileReader(path);
                String msg="";
                int i=reader.read();
                while(i!=-1){
                    msg+=(char)i;
                    i=reader.read();
                }
                 object=new JSONObject(msg);
                  array=object.getJSONArray("students");
            }
            else{
                 object = new JSONObject();
                 array = new JSONArray();
            }
            student = new JSONObject();
            student.put("id", id.getText().toString());
            student.put("name", name.getText().toString());
            student.put("dept", dept.getText().toString());
            array.put(student);
            object.put("students",array);
            FileWriter writer=new FileWriter("/storage/sdcard0/jsonfile.json");
            writer.write(object.toString());
            writer.flush();
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void readjson(View v){
      try {
          FileReader reader = new FileReader("/storage/sdcard0/jsonfile.json");
          String msg="";
          int i=reader.read();
          while(i!=-1){
              msg+=(char)i;
              i=reader.read();
          }
          JSONObject object=new JSONObject(msg);
          JSONArray array=object.getJSONArray("students");
          for(int j=0;j<array.length();j++){
              JSONObject student=array.getJSONObject(j);
              String id=student.getString("id");
              String name=student.getString("name");
              String dept=student.getString("dept");
              Toast.makeText(this,id+"\n"+name+"\n"+dept,Toast.LENGTH_SHORT).show();
          }
      }catch(Exception e){

      }
    }
}
