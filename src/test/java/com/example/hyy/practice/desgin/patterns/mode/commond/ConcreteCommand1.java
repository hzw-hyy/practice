package com.example.hyy.practice.desgin.patterns.mode.commond;

/**
 * @ClassName ConcreteCommand1
 * @Author 18845
 * @Date 2021/9/14 11:01
 * @Description ConcreteCommand1
 * @Version 1.0
 */
public class ConcreteCommand1 extends Command {

    private Receiver receiver;

    public ConcreteCommand1(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        this.receiver.doSomething();
    }
}
