package com.example.hyy.practice.desgin.patterns.mode.commond;

/**
 * @ClassName Client
 * @Author 18845
 * @Date 2021/9/14 11:04
 * @Description Client
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        Receiver receiver = new ConcreteReceiver1();
        Command command = new ConcreteCommand1(receiver);
        invoker.setCommand(command);
        invoker.call();
    }
}
