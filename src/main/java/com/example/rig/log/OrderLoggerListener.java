package com.example.rig.log;

import com.example.rig.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

public class OrderLoggerListener {
    private static final Logger logger = LoggerFactory.getLogger(OrderLoggerListener.class);
    @PrePersist
    public void methodInvokedBeforePersist(Order order) {
        logger.info("persisting order with id = " + order.getId());
    }

    @PostPersist
    public void methodInvokedAfterPersist(Order order) {
        logger.info("Persisted order with id = " + order.getId());
    }

    @PreUpdate
    public void methodInvokedBeforeUpdate(Order order) {
        logger.info("Updating order with id = " + order.getId());
    }

    @PostUpdate
    public void methodInvokedAfterUpdate(Order order) {
        logger.info("Updated order with id = " + order.getId());
    }

    @PreRemove
    private void methodInvokedBeforeRemove(Order order) {
        logger.info("Removing order with id = " + order.getId());
    }

    @PostRemove
    public void methodInvokedAfterRemove(Order order) {
        logger.info("Removed order with id = " + order.getId() );
    }
}
