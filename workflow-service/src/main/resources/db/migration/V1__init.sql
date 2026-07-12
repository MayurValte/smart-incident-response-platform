CREATE TABLE workflow (
    id                    UUID PRIMARY KEY,
    incident_id           UUID NOT NULL,
    assigned_to           UUID,
    assigned_team         UUID,
    workflow_status       VARCHAR(30) NOT NULL,
    severity              VARCHAR(20) NOT NULL,
    escalation_level      INTEGER NOT NULL,
    sla_deadline          TIMESTAMP(6) WITH TIME ZONE NOT NULL,
    next_escalation_time  TIMESTAMP(6) WITH TIME ZONE,
    resolved_at           TIMESTAMP(6) WITH TIME ZONE,
    closed_at             TIMESTAMP(6) WITH TIME ZONE,
    remarks               VARCHAR(1000),
    created_at            TIMESTAMP(6) WITH TIME ZONE NOT NULL,
    updated_at            TIMESTAMP(6) WITH TIME ZONE NOT NULL,

    CONSTRAINT uk_workflow_incident_id UNIQUE (incident_id)
);

CREATE INDEX idx_workflow_incident_id ON workflow (incident_id);
CREATE INDEX idx_workflow_status ON workflow (workflow_status);
CREATE INDEX idx_workflow_assigned_to ON workflow (assigned_to);
CREATE INDEX idx_workflow_next_escalation ON workflow (next_escalation_time);
