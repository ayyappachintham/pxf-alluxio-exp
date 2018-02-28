package io.pivotal.pxf.profile.alluxio;

import org.apache.commons.cli.MissingArgumentException;
import org.apache.hawq.pxf.api.utilities.InputData;

/**
 * Created by ayyappa on 27/12/17.
 */
public class Parameters {
    private LogAyy LOG;
    private String filename;
    private InputData metaData;
    public Parameters(InputData inputData) {
        LOG = new LogAyy("/tmp/Parameters.log");
        metaData=inputData;
        //LOG.logit(inputData.getDataSource());
        //LOG.logit(inputData.getDataSource().indexOf("/"));


    }

    public String getFilename(){

        filename = metaData.getDataSource().substring(metaData.getDataSource().indexOf("/"));
        //LOG.logit("Entered Filename: "+filename);
        return filename;
    }

    public String getHostIP(){
        return metaData.getDataSource().substring(0,metaData.getDataSource().indexOf(":"));

    }


}