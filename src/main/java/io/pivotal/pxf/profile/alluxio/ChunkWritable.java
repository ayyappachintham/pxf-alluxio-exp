package io.pivotal.pxf.profile.alluxio;

import org.apache.hawq.pxf.service.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;

/**
 * Created by ayyappa on 29/12/17.
 */
public class ChunkWritable implements Writable {
    public byte [] box;

    /**
     * Serializes the fields of this object to <code>out</code>.
     *
     * @param out <code>DataOutput</code> to serialize this object into.
     * @throws UnsupportedOperationException this function is not supported
     */

    public void write(DataOutput out)  {
        throw new UnsupportedOperationException("ChunkWritable.write() is not implemented");
    }

    /**
     * Deserializes the fields of this object from <code>in</code>.
     * <p>For efficiency, implementations should attempt to re-use storage in the
     * existing object where possible.</p>
     *
     * @param in <code>DataInput</code> to deserialize this object from.
     * @throws UnsupportedOperationException  this function is not supported
     */

    public void readFields(DataInput in)  {
        throw new UnsupportedOperationException("ChunkWritable.readFields() is not implemented");
    }
}


