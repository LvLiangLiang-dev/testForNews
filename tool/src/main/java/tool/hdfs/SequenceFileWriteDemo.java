package tool.hdfs;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;

import javax.imageio.stream.FileImageInputStream;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;

import tool.Action;
import tool.PropertyUtils;

public class SequenceFileWriteDemo implements Action {
    private final String[] DATA = {
            "One, two, buckle my shoe",
            "Three, four, shut the door",
            "Five, six, pick up sticks",
            "Seven, eight, lay them straight",
            "Nine, ten, a big fat hen"
    };
    private String pathName = PropertyUtils.getStringValue("SequenceFileWriteDemo.file", "");
    private int len = PropertyUtils.getStringValueAsInt("SequenceFileWriteDemo.len", "");
    private String jpgPpathName = PropertyUtils.getStringValue("SequenceFileWriteDemo.path", "");

    public static void main(String[] args) {
        PropertyUtils propertyUtils = new PropertyUtils();
        SequenceFileWriteDemo sequenceFileWriteDemo = new SequenceFileWriteDemo();
        sequenceFileWriteDemo.action2();
    }

    public void action2() {
        IntWritable key = new IntWritable();
        SequenceFile.Writer writer = null;
        try {
            Configuration conf = new Configuration();
            FileSystem fs = FileSystem.get(URI.create(pathName), conf);
            Path path1 = new Path(pathName);

            Text value = new Text();

            writer = SequenceFile.createWriter(fs, conf, path1,
                    key.getClass(), value.getClass());

            for (int i = 0; i < len; i++) {
                key.set(100 - i);
                value.set(DATA[i % DATA.length]);
                writer.append(key, value);
            }

        } catch (Exception e) {
            System.out.println("error"+e);
        } finally {
            IOUtils.closeStream(writer);
        }
    }

    public void action() {
        BytesWritable key = new BytesWritable();
        SequenceFile.Writer writer = null;
        try {
            Configuration conf = new Configuration();
            FileSystem fs = FileSystem.get(URI.create(pathName), conf);
            Path path1 = new Path(pathName);

            BytesWritable value = new BytesWritable();

            writer = SequenceFile.createWriter(fs, conf, path1,
                    key.getClass(), value.getClass());

            for (int i = 0; i < len; i++) {
                key.set(new BytesWritable(String.valueOf(100 - i).getBytes()));
                BytesWritable bytesWritable = new BytesWritable(image2byte(jpgPpathName));
                value.set(bytesWritable);
                writer.append(key, value);
            }

        } catch (Exception e) {
            System.out.println("error");
        } finally {
            IOUtils.closeStream(writer);
        }
    }

    public byte[] image2byte(String path) {
        byte[] data = null;
        FileImageInputStream input = null;
        try {
            input = new FileImageInputStream(new File(path));
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int numBytesRead = 0;
            while ((numBytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, numBytesRead);
            }
            data = output.toByteArray();
            output.close();
            input.close();
        } catch (FileNotFoundException ex1) {
            ex1.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        return data;
    }
}