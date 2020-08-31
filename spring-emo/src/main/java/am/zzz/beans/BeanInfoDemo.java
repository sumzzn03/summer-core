package am.zzz.beans;

import java.beans.*;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * 使用 BeanInfo 描述 Person Bean
 */
public class BeanInfoDemo {
    public static void main(String[] args) throws Exception {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
        Stream.of(beanInfo.getPropertyDescriptors()).forEach(item -> {
            System.out.println(item);
        });
    }

    static class StringToIntegerPropertyEditor extends PropertyEditorSupport {

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            Integer value = Integer.valueOf(text);
            setValue(value);
        }
    }
}
