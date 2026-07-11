package com.sirp.workflow.kafka.producer;

import com.sirp.common.events.workflow.WorkflowAssignedEvent;
import com.sirp.common.events.workflow.WorkflowClosedEvent;
import com.sirp.common.events.workflow.WorkflowCreatedEvent;
import com.sirp.common.events.workflow.WorkflowEscalatedEvent;
import com.sirp.common.events.workflow.WorkflowResolvedEvent;

public interface WorkflowEventProducer {

    void publishWorkflowCreated(WorkflowCreatedEvent event);

    void publishWorkflowAssigned(WorkflowAssignedEvent event);

    void publishWorkflowEscalated(WorkflowEscalatedEvent event);

    void publishWorkflowResolved(WorkflowResolvedEvent event);

    void publishWorkflowClosed(WorkflowClosedEvent event);

}