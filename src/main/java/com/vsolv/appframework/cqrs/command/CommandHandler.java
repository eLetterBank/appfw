package com.vsolv.appframework.cqrs.command;

public interface CommandHandler<Q extends Command, R extends CommandResult> {
    public R execute(Q query);
}
