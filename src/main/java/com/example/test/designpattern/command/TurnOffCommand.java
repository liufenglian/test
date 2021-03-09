package com.example.test.designpattern.command;

public class TurnOffCommand implements Command {
    private Receiver receiver;

    public TurnOffCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    /**
     * 执行命令
     */
    @Override
    public void execute() {
        receiver.turnOff();
    }


}
