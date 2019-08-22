package com.kolly.learning.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringExclude;

/**
 * @Author kolly.li
 * @Date 2018/6/27
 * Modified Logs:
 * Created by kolly.li on 2018/6/27.
 */
@Getter
@Setter
@AllArgsConstructor
public class Person2 {

    private String name;

    private Integer age;

    @ToStringExclude
    private String ignore;

}
