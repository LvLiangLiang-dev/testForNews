import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {

    public static String toJson(Object obj) {
        Gson gson = new GsonBuilder() // json宽松
                .enableComplexMapKeySerialization() // 支持Map的key为复杂对象的形式
                .serializeNulls() // 智能null
                .setPrettyPrinting() // 调教格式
                .disableHtmlEscaping() // 默认是GSON把HTML 转义的
                .create();

        return gson.toJson(obj);
    }

    public static <T> T fromJson(String jsonStr, Class<T> clazz) {

        Gson gson = new GsonBuilder() // json宽松
                .enableComplexMapKeySerialization() // 支持Map的key为复杂对象的形式
                .serializeNulls() // 智能null
                .setPrettyPrinting() // 调教格式
                .disableHtmlEscaping() // 默认是GSON把HTML 转义的
                .create();

        return gson.fromJson(jsonStr, clazz);

    }

}
