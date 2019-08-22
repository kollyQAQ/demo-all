package jmh;

/**
 * @Author kolly.li
 * @Date 2018/5/23
 * Modified Logs:
 * Created by kolly.li on 2018/5/23.
 */
public interface Calculator {

    /**
     * calculate sum of an integer array
     *
     * @param numbers
     * @return
     */
    public long sum(int[] numbers);

    /**
     * shutdown pool or reclaim any related resources
     */
    public void shutdown();

}
