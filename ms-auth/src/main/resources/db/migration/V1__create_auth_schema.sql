-- ============================
-- TABELA: usuario
-- ============================
CREATE TABLE IF NOT EXISTS usuario (
                                       id          BIGSERIAL PRIMARY KEY,
                                       nome        VARCHAR(255) NOT NULL,
    email       VARCHAR(255) NOT NULL,
    senha       VARCHAR(255) NOT NULL,
    status      BOOLEAN      NOT NULL,
    salt        VARCHAR(255),
    created_at  TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at  TIMESTAMP WITHOUT TIME ZONE
    );

-- opcional, mas recomendado
CREATE UNIQUE INDEX IF NOT EXISTS ux_usuario_email ON usuario (email);


-- ============================
-- TABELA: tipo_usuario
-- ============================
CREATE TABLE IF NOT EXISTS tipo_usuario (
                                            id          BIGSERIAL PRIMARY KEY,
                                            role        VARCHAR(50) NOT NULL,
    created_at  TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at  TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT tipo_usuario_role_check
    CHECK (role IN ('Admin', 'Professor'))
    );

CREATE UNIQUE INDEX IF NOT EXISTS ux_tipo_usuario_role ON tipo_usuario (role);


-- ============================
-- TABELA: usuario_tipo_usuario
-- (join table do @OneToMany)
-- ============================
CREATE TABLE IF NOT EXISTS usuario_tipo_usuario (
                                                    usuario_id      BIGINT NOT NULL,
                                                    tipo_usuario_id BIGINT NOT NULL,

                                                    CONSTRAINT pk_usuario_tipo_usuario
                                                    PRIMARY KEY (usuario_id, tipo_usuario_id),

    CONSTRAINT fk_usuario_tipo_usuario_usuario
    FOREIGN KEY (usuario_id)
    REFERENCES usuario (id)
    ON DELETE CASCADE,

    CONSTRAINT fk_usuario_tipo_usuario_tipo_usuario
    FOREIGN KEY (tipo_usuario_id)
    REFERENCES tipo_usuario (id)
    ON DELETE CASCADE
    );


-- ============================
-- INSERT dos tipos de usuário
-- ============================
INSERT INTO tipo_usuario (role, created_at, updated_at)
VALUES
    ('Admin',     NOW(), NOW()),
    ('Professor', NOW(), NOW())
    ON CONFLICT (role) DO NOTHING;
