package jsonparser.sunil.com.jsonparsing;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Sonu on 3/1/2017.
 */

public class Student {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @SerializedName("dept")

    private String dept;
}
