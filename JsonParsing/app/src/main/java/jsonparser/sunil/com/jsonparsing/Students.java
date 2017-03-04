package jsonparser.sunil.com.jsonparsing;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Sonu on 3/1/2017.
 */

public class Students {
    @SerializedName("Students")
    private ArrayList<Student> list;

    public ArrayList<Student> getList() {
        return list;
    }

    public void setList(ArrayList<Student> list) {
        this.list = list;
    }
}
