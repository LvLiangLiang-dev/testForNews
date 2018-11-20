package test2;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import entiey.Student;
import org.junit.Before;
import org.junit.Test;
import util.GsonUtil;

//import java.lang.reflect.Type;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author lvliangliang
 * @create 2018-11-20 下午7:42
 */
public class GsonTest {
    Student student = new Student();

    @Before
    public void init(){
        student.setName("王小二");
        student.setAge(25.2);
        student.setBirthday("1990-01-01");
        student.setSchool("藍翔");
        student.setMajor(new String[]{"理发", "挖掘机"});
        student.setHas_girlfriend(false);
        student.setCar(null);
        student.setHouse(null);
        student.setComment("这是一个注释");
    }
    @Test
    public void t1(){
        String toJson = GsonUtil.toJson(student);
        System.out.println(toJson);
        String[] age = GsonUtil.fromJson(toJson, Student.class).getMajor();
        System.out.println(Arrays.toString(age));
    }

    @Test
    public void t2(){
        List<Student> list=new ArrayList<>();
        list.add(student);
        list.add(student);
        String string=GsonUtil.toJson(list);
        System.out.println(string);
        System.out.println("`````````");


        Gson gson =new Gson();
        List<Student> list1 = gson.fromJson(string, new TypeToken<List<Student>>() {
        }.getType());
        System.out.println(list1);

        System.out.println("`````````");
        GsonUtil.fromJson(string, new TypeToken<List<Student>>() {}.getType());
        System.out.println("list2:"+GsonUtil.fromJson(string, new TypeToken<List<Student>>() {}.getType()));

    }

    @Test
    public void t3(){
        Gson gson = new GsonBuilder() // json宽松
                .enableComplexMapKeySerialization() // 支持Map的key为复杂对象的形式
                .serializeNulls() // 智能null
                .setPrettyPrinting() // 调教格式
                .disableHtmlEscaping() // 默认是GSON把HTML 转义的
                .create();

        Gson gson2 = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation() //不导出实体中没有用@Expose注解的属性
                .enableComplexMapKeySerialization() //支持Map的key为复杂对象的形式
                .serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss:SSS")//时间转化为特定格式
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)//会把字段首字母大写,注:对于实体上使用了@SerializedName注解的不会生效.
                .setPrettyPrinting() //对json结果格式化.
                .setVersion(1.0)    //有的字段不是一开始就有的,会随着版本的升级添加进来,那么在进行序列化和返序列化的时候就会根据版本号来选择是否要序列化.
                //@Since(版本号)能完美地实现这个功能.还的字段可能,随着版本的升级而删除,那么
                //@Until(版本号)也能实现这个功能,GsonBuilder.setVersion(double)方法需要调用.
                .create();

        List<Student> list=new ArrayList<>();
        list.add(student);
        list.add(student);
        List<Student> list1= gson2.fromJson(GsonUtil.toJson(list), new TypeToken<List<Student>>() {
        }.getType());
        System.out.println(list1);
    }
}
