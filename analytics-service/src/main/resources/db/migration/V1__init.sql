CREATE TABLE incident_analytics (
    id                  UUID PRIMARY KEY,
    incident_id         UUID NOT NULL,
    incident_number     VARCHAR(50),
    title               VARCHAR(255),
    priority            VARCHAR(20),
    severity            VARCHAR(20) NOT NULL,
    status              VARCHAR(20) NOT NULL,
    created_at          TIMESTAMP(6) WITH TIME ZONE NOT NULL,
    assigned_at         TIMESTAMP(6) WITH TIME ZONE,
    resolved_at         TIMESTAMP(6) WITH TIME ZONE,
    closed_at           TIMESTAMP(6) WITH TIME ZONE,
    resolution_minutes  BIGINT,

    CONSTRAINT uk_incident_analytics_incident_id UNIQUE (incident_id)
);

CREATE INDEX idx_incident_analytics_incident_id ON incident_analytics (incident_id);
CREATE INDEX idx_incident_analytics_created_at ON incident_analytics (created_at);
CREATE INDEX idx_incident_analytics_severity ON incident_analytics (severity);
CREATE INDEX idx_incident_analytics_priority ON incident_analytics (priority);
