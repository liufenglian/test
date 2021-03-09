package com.example.test.designpattern.command;

public class TurnOnCommand implements Command {

    private Receiver receiver;

    public TurnOnCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    /**
     * 执行命令
     */
    @Override
    public void execute() {
        receiver.turnOn();
    }
}
