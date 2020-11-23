package com.root.algo;/**
 * CreateBy zxmao on  2020/11/5 0005 10:22
 */

import java.util.HashMap;

/**
 * Copyright (C) zhongda
 *
 * @author zx
 * @date 2020/11/5 0005 10:22
 * @description:
 */
public class LinkListExe {

    public ListNode deleteDuplicates(ListNode head) {
        //边界条件：head为null head只有一个节点
        if(head==null) return head;
        //思路：用一个HashMap保存遍历过的节点,如果遇到重复节点，就删除该节点。
        HashMap<Integer,Boolean> map = new HashMap();
        ListNode pre = null;
        ListNode p = head;
        while(p!=null){
            if(map.containsKey(p.val)){
                p = p.next;
                pre.next = pre.next.next;
            }else{
                map.put(p.val,true);
                pre = p;
                p=p.next;
            }
        }


        return head;
    }

    public static void main(String[] args) {
        LinkListExe e = new LinkListExe();
        ListNode head = new ListNode(1);
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        head.next= p1;
        p1.next = p2;


        e.deleteDuplicates(head);

    }

}
