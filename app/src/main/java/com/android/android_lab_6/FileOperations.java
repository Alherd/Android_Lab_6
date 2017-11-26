package com.android.android_lab_6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import android.os.Environment;
import android.util.Log;

public class FileOperations {
    public FileOperations() {

    }

    public Boolean write(String fileName, String lname, String group, String faculty) {
        try {
            File sdPath = Environment.getExternalStorageDirectory();
            sdPath = new File(sdPath.getAbsolutePath()); // dir
            File file = new File(sdPath, fileName + ".txt");
            //   String fpath = "/sdcard/" + fileName + ".txt";
            // File file = new File(fpath);
            // If file does not exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw =
                    new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(lname + " || " + group + " || " + faculty);
            bw.close();
            Log.d("Success", "Success");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String read(String fname) {

        BufferedReader br = null;
        String response = null;
        try {
            StringBuffer output = new StringBuffer();
            String fpath = "/sdcard/" + fname + ".txt";
            br = new BufferedReader(new FileReader(fpath));
            String line = "";
            while ((line = br.readLine()) != null) {
                output.append(line + "");
            }
            response = output.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return response;
    }
}
