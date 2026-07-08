package com.sirp.incident.kafka.producer;

import com.sirp.common.events.IncidentAssignedEvent;
import com.sirp.common.events.IncidentClosedEvent;
import com.sirp.common.events.IncidentCreatedEvent;
import com.sirp.common.events.IncidentResolvedEvent;

public interface IncidentEventProducer {

    void publishCreated(IncidentCreatedEvent event);

    void publishAssigned(IncidentAssignedEvent event);

    void publishResolved(IncidentResolvedEvent event);

    void publishClosed(IncidentClosedEvent event);

}