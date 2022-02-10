package com.atguigu.exer;

import jdk.nashorn.api.tree.NewTree;

/**
 *练习：银行有一个账户。有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账单
 *
 */
class Account implements Runnable{

    class Bank{

    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {

        }
    }
}
public class AccountTest {
    public static void main(String[] args) {
        Account a1 = new Account();
        Thread t1 = new Thread(a1);
        Thread t2 = new Thread(a1);

        t1.setName("甲");
        t2.setName("乙");

        t1.start();
        t2.start();
    }
}
