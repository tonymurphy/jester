package com.dreweaster.jester.application.commandhandler;

import com.dreweaster.jester.domain.AggregateId;
import com.dreweaster.jester.domain.CommandId;

import java.util.UUID;

public class CommandEnvelope<T> {

    public static <T> CommandEnvelope<T> of(AggregateId aggregateId, CommandId id, T payload) {
        return new CommandEnvelope<T>(aggregateId, id, payload) {
            @Override
            public AggregateId aggregateId() {
                return super.aggregateId();
            }

            @Override
            public CommandId id() {
                return super.id();
            }
        };
    }

    public static <T> CommandEnvelope<T> of(AggregateId aggregateId, T payload) {
        return new CommandEnvelope<T>(aggregateId, CommandId.of(UUID.randomUUID().toString()), payload) {
            @Override
            public AggregateId aggregateId() {
                return super.aggregateId();
            }

            @Override
            public CommandId id() {
                return super.id();
            }
        };
    }

    private AggregateId aggregateId;

    private CommandId id;

    private T payload;

    public CommandEnvelope(AggregateId aggregateId, CommandId id, T payload) {
        this.id = id;
        this.aggregateId = aggregateId;
        this.payload = payload;
    }

    public AggregateId aggregateId() {
        return aggregateId;
    }

    public CommandId id() {
        return id;
    }

    public T payload() {
        return payload;
    }

    @Override
    public String toString() {
        return "CommandEnvelope{" +
                "aggregateId=" + aggregateId +
                ", id=" + id +
                ", payload=" + payload +
                '}';
    }
}
