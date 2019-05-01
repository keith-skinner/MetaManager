import android.os.Environment;
import android.util.Log;

import java.io.File;

public class ReadWriteFile{

    public void writeFile(String fileName, String buffer){

        File file = new File(Environment.getExternalStorageDirectory()+"/Builds", fileName);

        if (!file.exists()) {
            if (!file.mkdirs()) {
                Log.d("fileRW","Failed to create file");
            }else {
                Log.d("fileRW","Created file");
            }
        }else {
            Log.d("fileRW","File exists");
        }

    }


}
