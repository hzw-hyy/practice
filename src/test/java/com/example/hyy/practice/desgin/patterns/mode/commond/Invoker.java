package com.example.hyy.practice.desgin.patterns.mode.commond;

/**
 * @ClassName Invoker
 * @Author 18845
 * @Date 2021/9/14 11:05
 * @Description Invoker
 * @Version 1.0
 */
public class Invoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void call() {
        this.command.execute();
    }
}
