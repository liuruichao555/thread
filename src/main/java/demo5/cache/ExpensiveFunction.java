package demo5.cache;

import java.math.BigInteger;

/**
 * ExpensiveFunction
 *
 * @author liuruichao
 * @date 15/7/17 下午3:25
 */
public class ExpensiveFunction implements Computable<String, BigInteger> {
    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        // 经过长时间的计算后
        return new BigInteger(arg);
    }
}
