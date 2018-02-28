package io.pivotal.pxf.profile.alluxio;

/**
 * Created by ayyappa on 27/12/17.
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogAyy {
    private static String filename;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();

    public FileWriter fileWriter;
    public PrintWriter printWriter;
    public void writeLog(Object s)  {
        try {
            fileWriter = new FileWriter(filename,true);
        }
        catch (IOException a){
        }
        printWriter = new PrintWriter(fileWriter);
        s=dateFormat.format(date)+":   "+s;
        printWriter.print(s+"\n");
        printWriter.close();
    }


    public  void logit(Object s) {
        writeLog(s);
    }

    public LogAyy(String s){
        filename=s;
    }

}