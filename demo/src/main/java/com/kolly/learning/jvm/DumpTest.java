package com.kolly.learning.jvm;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author kolly.li
 * @Date 2018/7/10
 * Modified Logs:
 * Created by kolly.li on 2018/7/10.
 */
public class DumpTest {

    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        while (true) {
            Thread.sleep(50);
            list.add(RandomStringUtils.random(1000, true, true));
        }
    }
}
