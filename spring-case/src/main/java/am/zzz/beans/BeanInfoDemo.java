package am.zzz.beans;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import sun.misc.Launcher;

import java.beans.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Stream;

/**
 * 使用 BeanInfo 描述 Person BeanDefinitionDemo
 */
public class BeanInfoDemo {
    public static void main(String[] args) throws Exception {
//        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
//        Stream.of(beanInfo.getPropertyDescriptors()).forEach(item -> {
//            System.out.println(item);
//        });
        System.out.println("开始输入");
        Properties properties = System.getProperties();
        System.out.println(JSON.toJSONString(properties));

        Properties prop = new Properties();
        prop.setProperty("name", "xiaoming");
        String name = prop.getProperty("name");
        String age = prop.getProperty("age", "18");
        Set<String> strings = prop.stringPropertyNames();
        System.out.println(JSON.toJSONString(strings));
        System.out.println(String.format("name %s age %s", name, age));

//        Class<BeanInfoDemo> beanInfoDemoClass = BeanInfoDemo.class;
//        Class<? extends BeanInfoDemo> aClass = new BeanInfoDemo().getClass();
//        Class<?> beanInfoDemo = Class.forName("BeanInfoDemo");
//        BeanInfoDemo.class.getClassLoader();
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println("==========");
        String[] split = System.getProperty("java.class.path").split(":");
        Arrays.stream(split).forEach(item -> System.out.println(item));
        System.out.println("==========");
        InputStream resourceAsStream = BeanInfoDemo.class.getClassLoader().getResourceAsStream("META-INF/bean-definition-context.xml");
        System.out.println(IOUtils.toString(new InputStreamReader(resourceAsStream)));

        ResourceBundle bundle = ResourceBundle.getBundle("my", new Locale("zh", "CN"));
        String cancel = bundle.getString("name");
        System.out.println(cancel);
    }

    static class StringToIntegerPropertyEditor extends PropertyEditorSupport {

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            Integer value = Integer.valueOf(text);
            setValue(value);
        }
    }
}
