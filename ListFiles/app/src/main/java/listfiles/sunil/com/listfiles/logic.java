package listfiles.sunil.com.listfiles;

import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Sonu on 2/10/2017.
 */

public class logic {

    int count=0;
    static int f=0;
    public ArrayList<HashMap<String,String>> getPlayList(String rootPath) {
        ArrayList<HashMap<String,String>> fileList = new ArrayList<>();
        try {
            File rootFolder = new File(rootPath);
            File[] files = rootFolder.listFiles(); //here you will get NPE if directory doesn't contains  any file,handle it like this.
            for (File file : files) {
                if (file.isDirectory() && f!=2 ) {
                    if (getPlayList(file.getAbsolutePath()) != null) {
                        fileList.addAll(getPlayList(file.getAbsolutePath()));
                    } else {
                        break;
                    }
                    f++;
                } else if (file.getName().endsWith(".mp3")) {
                    //Toast.makeText(this,"pppp",Toast.LENGTH_LONG).show();
                    HashMap<String, String> song = new HashMap<>();
                    song.put("file_path", file.getAbsolutePath());
                    song.put("file_name", file.getName());
                    fileList.add(song);
                    count++;
                }
            }
            return fileList;
        } catch (Exception e) {
            return null;
        }
     }

}
