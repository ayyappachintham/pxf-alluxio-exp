package io.pivotal.pxf.profile.alluxio;

import org.apache.commons.cli.MissingArgumentException;
import org.apache.hawq.pxf.api.utilities.InputData;

/**
 * Created by ayyappa on 27/12/17.
 */
public class Parameters {
    private LogAyy LOG;
    private String filename;
    private InputData inputData;
    public Parameters(InputData inputData) {
        LOG = new LogAyy("/tmp/Parameters.log");
        LOG.logit(inputData.getDataSource());
        LOG.logit(inputData.getDataSource().indexOf("/"));


    }

    public String getFilename(){
        filename = inputData.getDataSource().substring(inputData.getDataSource().indexOf("/"));
        LOG.logit("Entered Filename: "+filename);
        return filename;
    }
}
