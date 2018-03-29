package com.ccs1hnue.config.redis;

public interface MessagePublisher {
    void publish(final String message);
}
