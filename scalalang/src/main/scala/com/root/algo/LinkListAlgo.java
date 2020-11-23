package com.root.algo;/**
 * CreateBy zxmao on  2020/11/3 0003 14:21
 */

import java.util.HashMap;

/**
 * Copyright (C) zhongda
 *
 * @author zx
 * @date 2020/11/3 0003 14:21
 * @description:
 */
public class LinkListAlgo {


    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(int data) {
            this.data = data;
        }

        public Node() {
        }
    }

    private Node head;

    public void insertNode(Node node) {
        if (head == null) head = node;
        Node p = head;
        while (p != null && p.next != null) {
            p = p.next;
        }

        node.next = p.next;
        p.next = node;

    }

    public Node findNode(int value) {
        Node p = head;
        while (p != null && p.data != value) {
            p = p.next;
        }
        return p;
    }

    public int findNodeIndex(int value) {
        Node p = head;
        int pos = 0;
        while (p != null && p.data != value) {
            p = p.next;
            ++pos;
        }
        if (p == null) pos = -1;
        return pos;
    }

    public void delNode(int value) {
        if (head == null) return;
        if (head.data == value) {
            head = null;
            return;
        }

        Node p = head;
        while (p.next != null && p.next.data != value) {
            p = p.next;
        }
        if (p == null) return;
        p.next = p.next.next;
    }

    public boolean huiwenshu(String s) {
        if (s == null) return false;
        if (s.length() <= 1) return true;

        //1.先找中间位置
        int slow = -1;
        int quick = -1;
        while (quick + 1 < s.length()) {
            quick += 2;
            slow += 1;
        }
        //2.从中间向两侧遍历，看是否相等。如果全部相等，则为回文数
        int left = 0;
        int right = 0;
        if (quick >= s.length()) {
            //此时为字符串为奇数长度,中间位置就是slow指针位置
            left = slow - 1;
        } else {
            left = slow;
        }
        right = slow + 1;

        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) return false;
            --left;
            ++right;
        }

        return true;

    }

    /**
     * 单向链表反转
     *
     * @param list
     * @return
     */
    public Node reversLinkList(Node list) {
        Node pre = null;
        Node cur = list;
        Node next = list.next;
        while (next != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        cur.next = pre;
        return cur;
    }

    public boolean checkCircle(Node head) {
        HashMap<Node, Boolean> map = new HashMap();

        Node p = head;
        while (p.next != null) {
            if (map.get(p)) return true;
            map.put(p, true);
        }
        return false;
    }

    /**
     * 检查环
     *
     * @param head
     * @return
     */
    public boolean checkCircle2(Node head) {
        if (head == null) return false;
        Node slow = head;
        Node quick = head.next;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;

            if (slow == quick) {
                return true;
            }
        }
        return false;
    }

    /**
     * 合并两个有序链表
     *
     * @param n1
     * @param n2
     * @return
     */
    public Node mergeTwoOrderedLinkNode(Node n1, Node n2) {
        Node head = new Node();
        Node cur = head;
        while (n1 != null && n2 != null) {
            if (n1.data < n2.data) {
                cur.next = n1;
                n1 = n1.next;
            } else {
                cur.next = n2;
                n2 = n2.next;
            }
            cur = cur.next;
        }

        //将剩余节点添加
        if (n2 != null) {
            cur.next = n2;
        } else {
            cur.next = n1;
        }

        return head.next;

    }

    /**
     * 删除倒数第N个节点
     *
     * @param head
     * @return 思路：快指针先走n步，然后快慢指针一起走，当快指针走到最后一个节点null时，慢指针刚好停留在要删除的节点上。
     */
    public Node deleteBackN(Node head, int n) {
        Node slow = new Node(-1);
        Node quick = slow;
        slow.next = head;
        int i = 0;
        while (quick != null && i < n) {
            quick = quick.next;
            ++i;
        }
        //删除的节点不存在
        if (quick == null || i <= 0) return head;


        //找到要删除的节点
        Node pre = null;
        while (quick != null) {
            pre = slow;
            quick = quick.next;
            slow = slow.next;
        }

        if (pre.data == -1) {
            head = head.next;
        } else {
            pre.next = slow.next;
        }

        return head;
    }

    /**
     * 删除倒数第N个节点 TODO
     *
     * @param list
     * @param n
     * @return
     */
    public Node deleteBackN2(Node list, int n) {
        //1.将快指针先移动到第n个节点
        Node fast = list;
        int i = 1;
        while (fast != null && i < n) {
            fast = fast.next;
        }

        //边界条件：n可能是0，负数，超过list长度的数 。Node可能为空.
        if (fast == null || n <= 0) return list;

        //2.快慢指针同步移动，直到快指针到达最后一个元素。此时慢指针就在要删除的节点上。
        Node slow = list;
        Node pre = null;
        while (fast.next != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }

        if (pre == null) {
            //此时说明第2步未移动元素，slow已经在要删除的节点上（head）,说明删除的头节点。
            head = head.next;
        } else {
            //删除的是中间某个节点
            pre.next = pre.next.next;
        }

        return head;
    }

    /**
     * 寻找中间节点
     *
     * @param list
     * @return
     */
    public Node findMiddle(Node list) {
        if (list == null) return null;

        Node slow = list;
        Node quick = list;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }

    public void printNodeList(Node head) {
        Node n = head;
        while (n != null) {
            System.out.println(n.data);
            n = n.next;
        }

    }


    public static void main(String[] args) {
        LinkListAlgo algo = new LinkListAlgo();
        algo.huiwenshu("121");

        Node n = new Node(1);
        Node n1 = new Node(2, n);
        Node n2 = new Node(3, n1);
        Node n3 = new Node(4, n2);
        Node n4 = new Node(5, n3);

        algo.printNodeList(n4);
        algo.reversLinkList(n4);
        algo.printNodeList(n);

        //有序链表1
        Node nn = new Node(5);
        Node n11 = new Node(3, nn);
        Node n22 = new Node(1, n11);
        //有序列表2
        Node nn1 = new Node(8);
        Node n112 = new Node(4, nn1);
        Node n222 = new Node(2, n112);

        Node re = algo.mergeTwoOrderedLinkNode(n22, n222);
        algo.printNodeList(re);

        System.out.println("===========");
        //删除倒数第N个节点
        //1.空节点
        Node dre1 = algo.deleteBackN(null, 1);//null
        Node dre2 = algo.deleteBackN(null, 2);//null

        //2.只有一个头节点
        Node nOn = new Node(11);
        Node dre3 = algo.deleteBackN(nOn, 0); //11
        Node dre4 = algo.deleteBackN(nOn, 1);//null
        Node dre5 = algo.deleteBackN(nOn, 2);//11
        //3.删除倒数第0,1,2，Integer.MaxValue
        Node dre6 = algo.deleteBackN(n22, 0);//1.2.3.4.5.8
        Node dre7 = algo.deleteBackN(n22, 1);//1.3
        Node dre8 = algo.deleteBackN(n22, 100);//1.3.5

        HashMap<ListNode, Boolean> map = new HashMap();
        ListNode listNode = new ListNode(1);

        boolean boo = map.containsKey(listNode);
        if (boo) {
            System.out.println("");
        }else{
            System.out.println("false");
        }

    }



}
