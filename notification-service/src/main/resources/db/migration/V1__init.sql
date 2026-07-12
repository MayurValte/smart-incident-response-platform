CREATE TABLE notifications (
    id               UUID PRIMARY KEY,
    event_id         UUID NOT NULL,
    incident_id      UUID NOT NULL,
    recipient_id     UUID NOT NULL,
    recipient_email  VARCHAR(255),
    channel          VARCHAR(255) NOT NULL,
    type             VARCHAR(255) NOT NULL,
    status           VARCHAR(255) NOT NULL,
    subject          VARCHAR(255),
    message          TEXT NOT NULL,
    failure_reason   VARCHAR(1000),
    created_at       TIMESTAMP(6) WITH TIME ZONE NOT NULL,
    sent_at          TIMESTAMP(6) WITH TIME ZONE,
    recipient_phone  VARCHAR(30)
);

CREATE INDEX idx_notification_event_id ON notifications (event_id);
CREATE INDEX idx_notification_incident_id ON notifications (incident_id);
CREATE INDEX idx_notification_recipient_id ON notifications (recipient_id);
CREATE INDEX idx_notification_status ON notifications (status);
CREATE INDEX idx_notification_channel ON notifications (channel);
