CREATE TABLE incident (
    id               UUID PRIMARY KEY,
    incident_number  VARCHAR(255) NOT NULL,
    title            VARCHAR(255) NOT NULL,
    description      TEXT,
    status           VARCHAR(255) NOT NULL,
    severity         VARCHAR(255) NOT NULL,
    priority         VARCHAR(255) NOT NULL,
    created_by       UUID,
    assigned_to      UUID,
    team_id          UUID,
    created_at       TIMESTAMP(6) WITH TIME ZONE,
    updated_at       TIMESTAMP(6) WITH TIME ZONE,
    resolved_at      TIMESTAMP(6) WITH TIME ZONE,
    closed_at        TIMESTAMP(6) WITH TIME ZONE,
    version          BIGINT NOT NULL,

    CONSTRAINT uk_incident_number UNIQUE (incident_number)
);

CREATE INDEX idx_incident_status ON incident (status);
CREATE INDEX idx_incident_priority ON incident (priority);
CREATE INDEX idx_incident_assigned ON incident (assigned_to);
CREATE INDEX idx_incident_created ON incident (created_at);

CREATE TABLE incident_assignment (
    id           UUID PRIMARY KEY,
    incident_id  UUID,
    assigned_to  UUID,
    assigned_by  UUID,
    assigned_at  TIMESTAMP(6) WITH TIME ZONE
);

CREATE TABLE incident_attachment (
    id            UUID PRIMARY KEY,
    incident_id   UUID,
    file_name     VARCHAR(255),
    content_type  VARCHAR(255),
    file_size     BIGINT,
    storage_url   VARCHAR(255),
    uploaded_by   UUID,
    uploaded_at   TIMESTAMP(6) WITH TIME ZONE
);

CREATE TABLE incident_comment (
    id           UUID PRIMARY KEY,
    incident_id  UUID NOT NULL,
    message      TEXT NOT NULL,
    created_by   UUID,
    created_at   TIMESTAMP(6) WITH TIME ZONE,

    CONSTRAINT fk_incident_comment_incident FOREIGN KEY (incident_id) REFERENCES incident (id)
);

CREATE TABLE incident_history (
    id           UUID PRIMARY KEY,
    incident_id  UUID,
    old_status   VARCHAR(255),
    new_status   VARCHAR(255),
    changed_by   UUID,
    changed_at   TIMESTAMP(6) WITH TIME ZONE,

    CONSTRAINT fk_incident_history_incident FOREIGN KEY (incident_id) REFERENCES incident (id)
);

CREATE TABLE incident_sla (
    id                      UUID PRIMARY KEY,
    incident_id             UUID,
    target_resolution_time  TIMESTAMP(6) WITH TIME ZONE,
    breached                BOOLEAN,
    breached_at             TIMESTAMP(6) WITH TIME ZONE
);

CREATE INDEX idx_incident_assignment_incident_id ON incident_assignment (incident_id);
CREATE INDEX idx_incident_attachment_incident_id ON incident_attachment (incident_id);
CREATE INDEX idx_incident_comment_incident_id ON incident_comment (incident_id);
CREATE INDEX idx_incident_history_incident_id ON incident_history (incident_id);
CREATE INDEX idx_incident_sla_incident_id ON incident_sla (incident_id);
