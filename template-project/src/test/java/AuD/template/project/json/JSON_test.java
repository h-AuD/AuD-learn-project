package AuD.template.project.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author AuD/胡钊
 * @date 2021/1/13 11:34
 * @Version 1.0
 */
public class JSON_test {

    String json1 = "{\n" +
            "\"num\":1,\n" +
            "\"desc\":\"desc\",\n" +
            "\"flag\":true\n" +
            "}";
    String json2 = "{\n" +
            "\"map\":{\n" +
            "\t\t\"key1\":\"value\",\n" +
            "\t\t\"key2\":2,\n" +
            "\t\t\"key3\":false\n" +
            "\t},\n" +
            "\"strList\":[\"str1\",\"str2\",\"str3\"],\n" +
            "\"simpleRef\":{\n" +
            "\t\t\"num\":0,\n" +
            "\t\t\"desc\":\"desc-ref\"\n" +
            "\t}\n" +
            "}";

    /**
     * 简单对象,用于构建JSON数据
     * - 数字、字符、布尔
     */
    @Data
    class SimpleObj {
        private Integer num;
        private String desc;
        private Boolean flag;

        @Override
        public String toString() {
            return "SimpleObj{" +
                    "num=" + num +
                    ", desc='" + desc + '\'' +
                    ", flag=" + flag +
                    '}';
        }
    }

    /**
     * 复杂对象,用于构建JSON数据
     * - Map、List、ObjectRef、Array
     */
    @Data
    class ComplexObj {
        private Map<String,Object> map;
        private List<String> strList;
        private SimpleObj simpleRef;
        private Object[] obs;

        @Override
        public String toString() {
            return "ComplexObj{" +
                    "map=" + map +
                    ", strList=" + strList +
                    ", simpleRef=" + simpleRef +
                    ", obs=" + Arrays.toString(obs) +
                    '}';
        }
    }

    /**
     * 测试json转换为对象
     * {@link JSON#parseObject(String, Class)}
     */
    @Test
    public void testParseObject(){
        SimpleObj simple = JSONObject.parseObject(json1, SimpleObj.class);
        System.out.println(simple);
        Map<String,Object> map1 = JSONObject.parseObject(json1, Map.class);
        Map<String,Object> map2 = JSONObject.parseObject(json2, Map.class);
        System.out.println(map1+"\n"+map2);
        ComplexObj complex = JSONObject.parseObject(json2, ComplexObj.class);
        System.out.println(complex);
    }


}






