package com.kolly.learning.util.apche.common.lang3;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Author kolly.li
 * @Date 2018/6/27
 * Modified Logs:
 * Created by kolly.li on 2018/6/27.
 */
public class ToStringBuilderTest {

    public static void main(String[] args) {

        System.out.println(ToStringBuilder.reflectionToString(new Person("kolly", 12)));

        System.out.println(ToStringBuilder.reflectionToString(new Person("kolly", 12),
                ToStringStyle.SIMPLE_STYLE));

        System.out.println(ToStringBuilder.reflectionToString(new Person("kolly", 12),
                ToStringStyle.JSON_STYLE));

        System.out.println(ToStringBuilder.reflectionToString(new Person("kolly", 12),
                ToStringStyle.NO_CLASS_NAME_STYLE));

        System.out.println(ToStringBuilder.reflectionToString(new Person("kolly", 12),
                ToStringStyle.SHORT_PREFIX_STYLE));

        System.out.println(ToStringBuilder.reflectionToString(new Person("kolly", 12),
                ToStringStyle.MULTI_LINE_STYLE));

        System.out.println(ToStringBuilder.reflectionToString(new Person("kolly", 12),
                ToStringStyle.NO_FIELD_NAMES_STYLE));

        System.out.println(ToStringBuilder.reflectionToString(new Person2("kolly", 12, "hahaha")));

    }

    @Data
    @AllArgsConstructor
    private static class Person {

        private String name;

        private Integer age;

    }

    @Data
    @AllArgsConstructor
    private static class Person2 {

        private String name;

        private Integer age;

        @ToStringExclude
        private String ignore;

    }
}
