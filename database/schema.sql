-- =========================================================
-- TFG - Sistema de transporte escolar
-- Script de creación
-- PostgreSQL / pgAdmin
-- =========================================================

-- borrar lo creado hasta el momento:
DROP TABLE IF EXISTS notificaciones CASCADE;
DROP TABLE IF EXISTS ubicaciones_bus CASCADE;
DROP TABLE IF EXISTS eventos CASCADE;
DROP TABLE IF EXISTS trayectos CASCADE;
DROP TABLE IF EXISTS menores CASCADE;
DROP TABLE IF EXISTS paradas CASCADE;
DROP TABLE IF EXISTS rutas CASCADE;
DROP TABLE IF EXISTS usuarios CASCADE;

-- =========================================================
-- 1. Tabla de usuarios
-- =========================================================
CREATE TABLE usuarios (
    id_usuario          SERIAL PRIMARY KEY,
    nombre              VARCHAR(100) NOT NULL,
    apellidos           VARCHAR(150),
    email               VARCHAR(150) NOT NULL UNIQUE,
    telefono            VARCHAR(20),
    password_hash       VARCHAR(255) NOT NULL,
    rol                 VARCHAR(20) NOT NULL,
    fecha_creacion      TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    activo              BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT chk_rol_usuario
        CHECK (rol IN ('familia', 'cuidador', 'admin'))
);

-- =========================================================
-- 2. Tabla de rutas
-- =========================================================
CREATE TABLE rutas (
    id_ruta             SERIAL PRIMARY KEY,
    nombre              VARCHAR(100) NOT NULL,
    descripcion         TEXT,
    centro_educativo    VARCHAR(150),
    activa              BOOLEAN NOT NULL DEFAULT TRUE
);

-- =========================================================
-- 3. Tabla de paradas
-- =========================================================
CREATE TABLE paradas (
    id_parada           SERIAL PRIMARY KEY,
    id_ruta             INT NOT NULL,
    nombre              VARCHAR(120) NOT NULL,
    direccion           VARCHAR(255),
    orden_parada        INT NOT NULL,
    latitud             NUMERIC(9,6),
    longitud            NUMERIC(9,6),
    hora_estimada       TIME,
    CONSTRAINT fk_paradas_ruta
        FOREIGN KEY (id_ruta) REFERENCES rutas(id_ruta)
        ON DELETE CASCADE,
    CONSTRAINT uq_parada_orden_ruta
        UNIQUE (id_ruta, orden_parada)
);

-- =========================================================
-- 4. Tabla de menores
-- =========================================================
CREATE TABLE menores (
    id_menor            SERIAL PRIMARY KEY,
    nombre              VARCHAR(100) NOT NULL,
    apellidos           VARCHAR(150),
    fecha_nacimiento    DATE,
    id_familia          INT NOT NULL,
    id_ruta             INT NOT NULL,
    id_parada_subida    INT,
    id_parada_bajada    INT,
    observaciones       TEXT,
    activo              BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT fk_menores_familia
        FOREIGN KEY (id_familia) REFERENCES usuarios(id_usuario)
        ON DELETE RESTRICT,
    CONSTRAINT fk_menores_ruta
        FOREIGN KEY (id_ruta) REFERENCES rutas(id_ruta)
        ON DELETE RESTRICT,
    CONSTRAINT fk_menores_parada_subida
        FOREIGN KEY (id_parada_subida) REFERENCES paradas(id_parada)
        ON DELETE SET NULL,
    CONSTRAINT fk_menores_parada_bajada
        FOREIGN KEY (id_parada_bajada) REFERENCES paradas(id_parada)
        ON DELETE SET NULL
);

-- =========================================================
-- 5. Tabla de trayectos
-- Cada trayecto es una ejecución concreta de una ruta
-- =========================================================
CREATE TABLE trayectos (
    id_trayecto         SERIAL PRIMARY KEY,
    id_ruta             INT NOT NULL,
    id_cuidador         INT NOT NULL,
    fecha               DATE NOT NULL,
    hora_inicio         TIMESTAMP,
    hora_fin            TIMESTAMP,
    estado              VARCHAR(20) NOT NULL DEFAULT 'programado',
    observaciones       TEXT,
    CONSTRAINT fk_trayectos_ruta
        FOREIGN KEY (id_ruta) REFERENCES rutas(id_ruta)
        ON DELETE RESTRICT,
    CONSTRAINT fk_trayectos_cuidador
        FOREIGN KEY (id_cuidador) REFERENCES usuarios(id_usuario)
        ON DELETE RESTRICT,
    CONSTRAINT chk_estado_trayecto
        CHECK (estado IN ('programado', 'en_ruta', 'finalizado', 'cancelado'))
);

-- =========================================================
-- 6. Tabla de eventos
-- Registra subida/bajada de menores
-- =========================================================
CREATE TABLE eventos (
    id_evento           SERIAL PRIMARY KEY,
    id_trayecto         INT NOT NULL,
    id_menor            INT NOT NULL,
    tipo_evento         VARCHAR(20) NOT NULL,
    fecha_hora          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    id_parada           INT,
    registrado_por      INT NOT NULL,
    observaciones       TEXT,
    CONSTRAINT fk_eventos_trayecto
        FOREIGN KEY (id_trayecto) REFERENCES trayectos(id_trayecto)
        ON DELETE CASCADE,
    CONSTRAINT fk_eventos_menor
        FOREIGN KEY (id_menor) REFERENCES menores(id_menor)
        ON DELETE RESTRICT,
    CONSTRAINT fk_eventos_parada
        FOREIGN KEY (id_parada) REFERENCES paradas(id_parada)
        ON DELETE SET NULL,
    CONSTRAINT fk_eventos_usuario
        FOREIGN KEY (registrado_por) REFERENCES usuarios(id_usuario)
        ON DELETE RESTRICT,
    CONSTRAINT chk_tipo_evento
        CHECK (tipo_evento IN ('subida', 'bajada', 'incidencia'))
);

-- =========================================================
-- 7. Tabla de ubicaciones del autobús
-- Guarda posiciones GPS durante el trayecto
-- =========================================================
CREATE TABLE ubicaciones_bus (
    id_ubicacion        SERIAL PRIMARY KEY,
    id_trayecto         INT NOT NULL,
    fecha_hora          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    latitud             NUMERIC(9,6) NOT NULL,
    longitud            NUMERIC(9,6) NOT NULL,
    velocidad           NUMERIC(6,2),
    precision_metros    NUMERIC(6,2),
    CONSTRAINT fk_ubicaciones_trayecto
        FOREIGN KEY (id_trayecto) REFERENCES trayectos(id_trayecto)
        ON DELETE CASCADE
);

-- =========================================================
-- 8. Tabla de notificaciones
-- =========================================================
CREATE TABLE notificaciones (
    id_notificacion     SERIAL PRIMARY KEY,
    id_usuario          INT NOT NULL,
    id_trayecto         INT,
    titulo              VARCHAR(150) NOT NULL,
    mensaje             TEXT NOT NULL,
    tipo_notificacion   VARCHAR(30) NOT NULL,
    fecha_envio         TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    leida               BOOLEAN NOT NULL DEFAULT FALSE,
    CONSTRAINT fk_notificaciones_usuario
        FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
        ON DELETE CASCADE,
    CONSTRAINT fk_notificaciones_trayecto
        FOREIGN KEY (id_trayecto) REFERENCES trayectos(id_trayecto)
        ON DELETE SET NULL,
    CONSTRAINT chk_tipo_notificacion
        CHECK (tipo_notificacion IN ('inicio_ruta', 'proxima_parada', 'fin_ruta', 'alerta', 'incidencia'))
);

-- =========================================================
-- Índices recomendados
-- =========================================================
CREATE INDEX idx_menores_familia ON menores(id_familia);
CREATE INDEX idx_menores_ruta ON menores(id_ruta);
CREATE INDEX idx_paradas_ruta ON paradas(id_ruta);
CREATE INDEX idx_trayectos_ruta ON trayectos(id_ruta);
CREATE INDEX idx_trayectos_cuidador ON trayectos(id_cuidador);
CREATE INDEX idx_eventos_trayecto ON eventos(id_trayecto);
CREATE INDEX idx_eventos_menor ON eventos(id_menor);
CREATE INDEX idx_ubicaciones_trayecto ON ubicaciones_bus(id_trayecto);
CREATE INDEX idx_notificaciones_usuario ON notificaciones(id_usuario);
