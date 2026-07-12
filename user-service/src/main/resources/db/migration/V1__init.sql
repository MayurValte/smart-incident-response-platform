CREATE TABLE teams (
    id         UUID PRIMARY KEY,
    team_name  VARCHAR(255)
);

CREATE TABLE users (
    id        UUID PRIMARY KEY,
    username  VARCHAR(255) NOT NULL,
    email     VARCHAR(255) NOT NULL,
    password  VARCHAR(255) NOT NULL,
    enabled   BOOLEAN NOT NULL,
    role      VARCHAR(255),
    team_id   UUID,

    CONSTRAINT uk_users_email UNIQUE (email),
    CONSTRAINT fk_users_team FOREIGN KEY (team_id) REFERENCES teams (id)
);
