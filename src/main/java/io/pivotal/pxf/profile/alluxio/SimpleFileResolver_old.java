package io.pivotal.pxf.profile.alluxio;

import org.apache.hawq.pxf.api.OneField;
import org.apache.hawq.pxf.api.OneRow;
import org.apache.hawq.pxf.api.ReadResolver;
import org.apache.hawq.pxf.api.io.DataType;
import org.apache.hawq.pxf.api.utilities.InputData;
import org.apache.hawq.pxf.api.utilities.Plugin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayyappa on 27/12/17.
 */
public class SimpleFileResolver_old extends Plugin implements ReadResolver {
    private LogAyy LOG;

    private ArrayList<OneField> fields = new ArrayList<OneField>();

    public SimpleFileResolver_old(InputData input) {
        super(input);
        LOG = new LogAyy("/tmp/SimpleFileResolver.log");
       // LOG.logit("Construc INPUT:  "+input);

    }



    public List<OneField> getFields(OneRow paramOneRow) throws Exception {
        fields.clear();

        String data = (String) paramOneRow.getData();
       // for (String s : data.split(",")) {

        //}

       // LOG.info("Columns Count:" + this.inputData.getColumns());
        for (int i = 0; i < this.inputData.getColumns(); i++) {

            DataType columnType = DataType.get(this.inputData.getColumn(i).columnTypeCode());
            //LOG.info("STRUCT: " + struct);
            Object columnValue = data.split("$")[i];
           // LOG.logit("VALUE: " + columnValue);
           // LOG.logit(columnType);
            OneField field = new OneField(columnType.getOID(), toTypedValue(columnType, columnValue));
           // LOG.logit(field);
            fields.add(field);
        }
        //LOG.logit("Entered into return: "+fields);
        return fields;
    }

    private Object toTypedValue(DataType type, Object value) throws IOException {

        if (value == null) {
            return value;
        }

        switch (type) {
            case BIGINT:
                return Long.valueOf(value.toString());
            case BOOLEAN:
                return Boolean.valueOf(value.toString());
            case BPCHAR:

                return value.toString().charAt(0);
            case BYTEA:
                return value.toString().getBytes();
            case FLOAT8:
            case REAL:
                return Double.valueOf(value.toString());
            case INTEGER:
            case SMALLINT:
                return Integer.valueOf(value.toString());
            case TEXT:
            case VARCHAR:
                return value.toString();
            default:
                throw new IOException("Unsupported type " + type);

        }
    }
}
