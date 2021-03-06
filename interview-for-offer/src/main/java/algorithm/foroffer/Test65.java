package algorithm.foroffer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-19 20:53 // 2017-8-21 10:46:30
 *
 * 面试题65：滑动窗口的最大值
 *
 * 题目：
 *      给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。
 *      例如，如果输入数组 {2, 3, 4, 2, 6, 2, 5, 1}及滑动窗口的大小 3，
 *      那么移动存在 6 个滑动窗口，它们的最大值分别为 {4, 4, 6, 6, 6, 5}。
 *
 * 考查点：
 *      1. 双端队列的应用
 *
 * 思路：
 *      1. 新的元素比队列中的任何元素都大，则清空队列，并将其添加到队尾
 *      2. 新的元素比队尾中的元素小，则将其添加到队尾
 *      3. 新的元素比队尾元素大，但是比队首元素小，则将比其小的元素移出队列，然后将其添加到队尾。（从队尾删除元素）
 *
 *      怎么控制窗口的大小呢？
 *          队列里面存放的是下标，
 *          插入元素之前，先判断尾首下标之差是否等于 n-1，如果是，则将队首元素移出队列
 *
 *
 * Deque的12种方法总结如下：
 * 	                   First Element (Head)	                      Last Element (Tail)
 *              Throws exception	Special value	        Throws exception	Special value
 *  Insert	      addFirst(e)	     offerFirst(e)	            addLast(e)	     offerLast(e)
 *  Remove	      removeFirst()      pollFirst()     	        removeLast()	 pollLast()
 *  Examine	      getFirst()	     peekFirst()	            getLast()	     peekLast()
 *
 */
public class Test65 {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num == null || num.length == 0 || size < 1) return result;

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < num.length; i ++){
            // 保证添加新的元素之前，窗口中首尾元素下标之差最大是size
            if (i > 0 && !deque.isEmpty()){
                int firstIdx = deque.peekFirst();
                int diff = i - firstIdx;
                if (diff == size)
                    deque.pollFirst();
            }
            /*
            if (!deque.isEmpty() && num[i] > deque.peekFirst()){
                deque.clear();
            }else{
                while(!deque.isEmpty() && num[i] >= deque.peekLast())
                    deque.pollLast();
            }
            */

            // 同一个窗口中的元素如果小于新元素，则被删除
            // 由于前面的元素总是大于后面的元素，所以从后面开始删除
            while(!deque.isEmpty() && num[i] >= num[deque.peekLast()])
                deque.pollLast();

            // 新元素总是会被添加到双端队列的末尾
            deque.offerLast(i);

            // 双端队列的队头存放的是一个窗口的最大值
            if (i >= size-1)
                result.add(num[deque.peekFirst()]);
        }
        return result;
    }
}


