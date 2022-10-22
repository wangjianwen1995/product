package com.sxdl.cf.util;

import lombok.Data;

@Data
public class Node {

    private String data; // 用于保存数据

    private Node next; // 用于保存下一个节点

    // 每一个Node类对象都必须保存有响应的数据



    public Node(String data) {

        this.data = data;

    }




    // 实现节点的添加

    // 第一次调用（Link）：this代表Link.root

    // 第二次调用（Node）：this代表Link.root.next

    // 第三次调用（Node）：this代表Link.root.next.next

    public void addNode(Node newNode) {

        if (this.next == null) { // 如果只有一个节点

            this.next = newNode; // 保存新节点

        } else { // 当前节点后面还有节点

            // 当前节点的下一个节点继续保存

            this.next.addNode(newNode);



        }

    }



// 第一次调用（Link）：this代表Link.root

    // 第二次调用（Node）：this代表Link.root.next

    // 第三次调用（Node）：this代表Link.root.next.next

    public void printNode() {

        System.out.println(this.data);// 输出当前数据

        if (this.next != null) {// 如果还有下一个节点

            this.next.printNode();// 输出下一节点

        }

    }

}

 class LinkDemo {



    public static void main(String[] args) {

        Link link = new Link() ;

        link.add("hello");   //存放数据

        link.add("world");

        link.add("wwww");

        link.print();     //展示数据



    }



}

//负责数据的设置和输出

 class Link {

    private Node root; //根节点

//增加数据

    public void add (String data){

        //为了设置数据的先后关系，所以将data包装在一个Node类对象

        Node newNode = new Node(data);

        if(this.root == null ){  //一个链表只有一个根节点

            this.root = newNode;  //将新的节点设置为根节点

        }else{

            //从root节点后找到合适的位置

            this.root.addNode(newNode);

        }

    }

//输出数据

    public void print(){

        if( this.root != null ){

            this.root.printNode();

        }

    }
}
