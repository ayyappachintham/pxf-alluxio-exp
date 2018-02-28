package io.pivotal.pxf.profile.alluxio;

import org.apache.commons.cli.MissingArgumentException;
import org.apache.hawq.pxf.api.Fragment;
import org.apache.hawq.pxf.api.Fragmenter;
import org.apache.hawq.pxf.api.utilities.InputData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayyappa on 25/12/17.
 */


public class SimpleFileFragmenter extends Fragmenter {
    private LogAyy LOG;
    private Parameters params;

    public SimpleFileFragmenter(InputData metaData) throws MissingArgumentException {
        super(metaData);
        //LOG = new LogAyy("/tmp/SimpleFileFragmenter.log");
        //LOG.logit("MetaData:  "+metaData.getDataSource());
        params = new Parameters(metaData);
        //LOG.logit("Entered after param init");
    }


    public List<Fragment> getFragments() throws Exception {

        List<Fragment> fragments = new ArrayList<Fragment>();
    //    LOG.logit("Fragment First Step:"+ params.getFilename());


        fragments.add(new Fragment(params.getFilename(), new String[] { params.getHostIP() }, new byte[0]));
        //LOG.logit("Fragments:  "+ fragments.toString());
        //LOG.logit(fragments.iterator().toString());
        return fragments;


    }
}
