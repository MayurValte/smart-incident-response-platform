CREATE TABLE refresh_tokens (
    id           UUID PRIMARY KEY,
    user_id      UUID NOT NULL,
    token        VARCHAR(255) NOT NULL,
    expiry_date  TIMESTAMP(6) WITH TIME ZONE NOT NULL,
    revoked      BOOLEAN NOT NULL,

    CONSTRAINT uk_refresh_tokens_token UNIQUE (token)
);

CREATE INDEX idx_refresh_tokens_user_id ON refresh_tokens (user_id);
