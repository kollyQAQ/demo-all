package com.kolly.learning.util.apche.common.lang3;


import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * @Author kolly.li
 * @Date 2018/6/27
 * Modified Logs:
 * Created by kolly.li on 2018/6/27.
 */
public class ObjectUtilTest {

    public static void main(String[] args) {

        String str = null;

        Integer integer = NumberUtils.toInt(ObjectUtils.defaultIfNull(str, "-1"), -1);

        System.out.println(SystemUtils.FILE_ENCODING);
        System.out.println(SystemUtils.FILE_SEPARATOR);
        System.out.println(SystemUtils.JAVA_HOME);

    }
}
