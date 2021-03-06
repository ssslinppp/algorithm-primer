package algorithm.foroffer;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-03 21:36
 *
 * 面试题46：求 1+2+...+n
 *
 * 题目：
 *      求 1+2+...+n。要求不能使用乘除法、for、while、if、else、switch、case等关键字
 *      及条件判断语句。
 *
 * 考查点：
 *      1. 发散思维，使用对象数组初始化实现求和功能
 *
 * 思路：
 *      1. 不能使用公式法(*,/)，不能使用循环(for/while)、不能使用递归(if)
 *
 */

class Add{
    static int sum = 0;
    static int n = 0;
    public Add(){
        System.out.println("---");
        n ++;
        sum += n;
    }

    public static int sum(int n){
        // n = 0;
        // sum = 0;
        // 创建对象数组，仅仅是分配内存空间，不调用构造函数
        Add[] adds = new Add[n];
        return sum;
    }
}

public class Test46 {

    @Test
    public void test(){
        // int sum = Add.sum(5);
        // System.out.println(sum);
    }

    /**
     * 不用 if 判断递归终止条件的递归
     * @param n 参数
     * @return 和
     */
    public int sum(int n){
        int sum = n;
        boolean bool = (n > 0) && ((sum +=sum(n-1)) > 0);
        return sum;
    }

    @Test
    public void test2(){
        System.out.println(sum(5));
    }

}
