package com.example.hyy.practice.leetcode;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 合并n个有序链表
 */
public class MergeTwoOrderedLinkedLists {

    public static void main(String[] args) {
        MergeTwoOrderedLinkedLists merge = new MergeTwoOrderedLinkedLists();
        Queue<Node> nodes = merge.init();
        Node node = nodes.poll();
        node = merge.mergeNLink(node, nodes);
        merge.sout(node);
    }

    /**
     * 输出链表中的数据
     *
     * @param node 链表
     */
    public void sout(Node node) {
        System.out.println("---------------------------------------------");
        while (null != node) {
            System.out.println("node.value = " + node.value);
            node = node.next;
        }
    }

    /**
     * 初始化链表队列
     * <p>
     * 队列中每条记录存储一个链表
     * <p>
     * 每个链表存储升序节点例如:
     * <p>
     * 0->1->2->3->4
     * <p>
     * 5->6->7->8->9
     *
     * @return 初始化后的队列
     */
    public Queue<Node> init() {
        Queue<Node> nodes = new ArrayBlockingQueue<>(5);
        int count = 0;
        for (int i = 0; i < 5; i++) {
            Node head = new Node(count);
            Node e = head;
            count += 1;
            for (int j = count; j < count + 4; j++) {
                e.next = new Node(j);
                e = e.next;
            }
            count += 4;
            sout(head);
            nodes.add(head);
        }
        return nodes;
    }

    /**
     * 合并n个链表
     * <p>
     * 思路：
     * <p>
     * 取出队列首位，通过mergeTwoLink方法返回合并后的链表
     * <p>
     * 递归此方法继续与队列中的链表进行合并
     *
     * @param merge 合并前的链表
     * @param queue 存储链表的队列
     * @return 合并后的链表的首节点
     */
    public Node mergeNLink(Node merge, Queue<Node> queue) {
        Node node = queue.poll();
        if (null == node) {
            return merge;
        }
        merge = mergeTwoLink(merge, node);
        merge = mergeNLink(merge, queue);
        return merge;
    }

    /**
     * 合并两个有序链表
     * <p>
     * 思路：
     * <p>
     * 比较n1与n2的值
     * <p>
     * 当n1值小于n2值时，n1.next有两个选择，∵两条链表都为升序，∴第一是原链表的n1.next，第二是n2
     * <p>
     * 通过递归此方法返回实际排序的n1.next
     * <p>
     * 当n1值大于n2值时同理
     * <p>
     * 当n1为null时，返回n2
     * <p>
     * 当n2为null时同理
     *
     * @param n1 链表1
     * @param n2 链表2
     * @return 合并后的链表的首结点
     */
    public Node mergeTwoLink(Node n1, Node n2) {
        if (null == n1) {
            return n2;
        }
        if (null == n2) {
            return n1;
        }
        if (n1.value < n2.value) {
            n1.next = mergeTwoLink(n1.next, n2);
            return n1;
        } else {
            n2.next = mergeTwoLink(n2.next, n1);
            return n2;
        }
    }

    public class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }


    }
}
