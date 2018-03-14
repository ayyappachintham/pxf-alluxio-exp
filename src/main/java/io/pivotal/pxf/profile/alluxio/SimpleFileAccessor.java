package io.pivotal.pxf.profile.alluxio;

import alluxio.AlluxioURI;
import alluxio.client.file.FileInStream;
//import alluxio.client.file.FileSystem;
import org.apache.hawq.pxf.api.OneRow;
import org.apache.hawq.pxf.api.ReadAccessor;
import org.apache.hawq.pxf.api.utilities.InputData;
import org.apache.hawq.pxf.api.utilities.Plugin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

/**
 * Created by ayyappa on 27/12/17.
 */
public class SimpleFileAccessor extends Plugin implements ReadAccessor {
    private LogAyy LOG;
    private Parameters params;
    FileInStream in;
    InputStreamReader bf;
    BufferedReader rd;
    OneRow oneRow = new OneRow();
    public SimpleFileAccessor(InputData input) {
        super(input);
       // LOG = new LogAyy("/tmp/SimpleFileAccessor.log");
       // LOG.logit("Construct Input:  "+input.toString());
        params = new Parameters(input);
       // LOG.logit(param);
    }

    public boolean openForRead()  {
       try {
        //    LOG.logit("Entered for Read:");
            alluxio.client.file.FileSystem fs= alluxio.client.file.FileSystem.Factory.get();
        //   LOG.logit("Filename :  " + params.getFilename());
            AlluxioURI path = new AlluxioURI(params.getFilename());
        //    LOG.logit("Path " + path);
            // FileReader file = new FileReader(param.filename);
            //rd = new BufferedReader(file);
            in = fs.openFile(path);
            bf = new InputStreamReader(in); // new for performance
            rd = new BufferedReader(bf);  // new for performance

          //  LOG.logit("Filename:  " + path);

        }
        catch (Throwable a) {
            LOG.logit("Error:"+a);

        }

        return true;

    }

    public OneRow readNextObject() throws Exception {
        String line="";
        boolean exit=false;
     //   while (true){
     //       rd.readLine();
     //       int temp =  in.read();
     //       if (temp == -1 ) { exit = true; break;}
     //       if (temp == 10 ){ break;}
     //       line = line + (char) temp;
     //   }
     //   if (exit) { return null;}
     //   else {
     //       oneRow.setKey(1);
     //       oneRow.setData(line);
     //       //LOG.logit(line);
     //       return oneRow;
     //   }
        while (true){           // new for performance
            line = rd.readLine();  // new for performance
            if (line == null) {return null;}
            oneRow.setKey(1);
            oneRow.setData(line);
            return oneRow;
        }


       // if (line!=null){
       //     oneRow.setKey(1);
       //     oneRow.setData(line);
       //     LOG.logit(oneRow);
       //     return oneRow;
       // } else
       // {
       //     return null;
       // }


    }

    public void closeForRead() throws Exception {
        in.close();
    }
}

