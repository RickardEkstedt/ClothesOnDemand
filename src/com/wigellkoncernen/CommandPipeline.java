package com.wigellkoncernen;

import java.util.LinkedList;
import java.util.Queue;

public class CommandPipeline {
    private Queue<ClothingCommand> commandQueue = new LinkedList<>();

    public CommandPipeline addCommand(ClothingCommand command) {
        commandQueue.offer(command);
        return this;
    }

    public void executeAll() {
        while (!commandQueue.isEmpty()) {
            ClothingCommand command = commandQueue.poll();
            command.execute();
        }
    }
}