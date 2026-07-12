CREATE TABLE audit_event (
    id              UUID PRIMARY KEY,
    event_id        UUID NOT NULL,
    aggregate_id    UUID NOT NULL,
    aggregate_type  VARCHAR(255) NOT NULL,
    event_type      VARCHAR(255) NOT NULL,
    service_name    VARCHAR(100) NOT NULL,
    performed_by    UUID,
    occurred_at     TIMESTAMP(6) WITH TIME ZONE NOT NULL,
    payload         TEXT NOT NULL,

    CONSTRAINT uk_audit_event_event_id UNIQUE (event_id)
);

CREATE INDEX idx_audit_event_type ON audit_event (event_type);
CREATE INDEX idx_audit_aggregate ON audit_event (aggregate_id);
CREATE INDEX idx_performed_by ON audit_event (performed_by);
CREATE INDEX idx_occurred_at ON audit_event (occurred_at);
