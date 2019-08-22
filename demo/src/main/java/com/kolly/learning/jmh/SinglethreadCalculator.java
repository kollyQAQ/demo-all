package jmh;

/**
 * @Author kolly.li
 * @Date 2018/5/23
 * Modified Logs:
 * Created by kolly.li on 2018/5/23.
 */
public class SinglethreadCalculator implements Calculator {

    @Override
    public long sum(int[] numbers) {
        long total = 0L;
        for (int i : numbers) {
            total += i;
        }
        return total;
    }

    @Override
    public void shutdown() {

    }
}