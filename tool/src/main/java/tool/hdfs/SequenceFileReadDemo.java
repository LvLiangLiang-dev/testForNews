package tool.hdfs;

import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.util.ReflectionUtils;

import lombok.extern.slf4j.Slf4j;
import tool.Action;
import tool.PropertyUtils;

@Slf4j
public class SequenceFileReadDemo implements Action {
    @Override
    public void action() {
        SequenceFile.Reader reader = null;
        try {
            String pathvalue = PropertyUtils.getStringValue("SequenceFileWriteDemo.file", "");
            Configuration conf = new Configuration();
            FileSystem fs = FileSystem.get(URI.create(pathvalue), conf);
            Path path = new Path(pathvalue);
            reader = new SequenceFile.Reader(fs, path, conf);
            Writable key = (Writable)
                    ReflectionUtils.newInstance(reader.getKeyClass(), conf);
            Writable value = (Writable)
                    ReflectionUtils.newInstance(reader.getValueClass(), conf);
            long position = reader.getPosition();
            while (reader.next(key, value)) {
                //同步记录的边界
                String syncSeen = reader.syncSeen() ? "*" : "";
                System.out.printf("[%s%s]\t%s\t%s\n", position, syncSeen, key, value);
                position = reader.getPosition(); // beginning of next record
            }
        } catch (Exception e) {
            log.info("xxx:{}", e);
        } finally {
            IOUtils.closeStream(reader);
        }
    }
}