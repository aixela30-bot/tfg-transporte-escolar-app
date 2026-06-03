-- =========================================================
-- TFG - Sistema de transporte escolar
-- Script de carga de datos
-- PostgreSQL / pgAdmin
-- =========================================================

-- Limpieza  de datos
TRUNCATE TABLE notificaciones RESTART IDENTITY CASCADE;
TRUNCATE TABLE ubicaciones_bus RESTART IDENTITY CASCADE;
TRUNCATE TABLE eventos RESTART IDENTITY CASCADE;
TRUNCATE TABLE trayectos RESTART IDENTITY CASCADE;
TRUNCATE TABLE menores RESTART IDENTITY CASCADE;
TRUNCATE TABLE paradas RESTART IDENTITY CASCADE;
TRUNCATE TABLE rutas RESTART IDENTITY CASCADE;
TRUNCATE TABLE usuarios RESTART IDENTITY CASCADE;

-- =========================================================
-- 1. USUARIOS
-- =========================================================
INSERT INTO usuarios (nombre, apellidos, email, telefono, password_hash, rol)
VALUES
('María', 'López García', 'maria.lopez@email.com', '600111111', 'hash_demo_familia_1', 'familia'),
('Javier', 'Martín Ruiz', 'javier.martin@email.com', '600222222', 'hash_demo_familia_2', 'familia'),
('Laura', 'Sánchez Pérez', 'laura.sanchez@email.com', '600333333', 'hash_demo_familia_3', 'familia'),
('Carlos', 'Pérez Gómez', 'carlos.cuidador@email.com', '600444444', 'hash_demo_cuidador_1', 'cuidador'),
('Ana', 'Romero Díaz', 'ana.admin@email.com', '600555555', 'hash_demo_admin_1', 'admin');

-- =========================================================
-- 2. RUTAS
-- =========================================================
INSERT INTO rutas (nombre, descripcion, centro_educativo, activa)
VALUES
('Ruta 1 - Mañana', 'Ruta principal de entrada al centro', 'Ikastola Mungia', TRUE),
('Ruta 2 - Tarde', 'Ruta de salida del centro', 'Ikastola Mungia', TRUE);

-- =========================================================
-- 3. PARADAS
-- =========================================================
INSERT INTO paradas (id_ruta, nombre, direccion, orden_parada, latitud, longitud, hora_estimada)
VALUES
(1, 'Parada Centro', 'Av. Andalucía 10', 1, 37.389000, -5.984000, '08:00'),
(1, 'Parada Norte', 'Calle Mayor 22', 2, 37.392500, -5.990000, '08:10'),
(1, 'Parada Este', 'Plaza del Sol 5', 3, 37.395500, -5.996000, '08:18'),
(1, 'Colegio', 'Ikastola Mungia', 4, 37.398000, -6.002000, '08:25'),

(2, 'Colegio', 'Ikastola Mungia', 1, 37.398000, -6.002000, '14:00'),
(2, 'Parada Este', 'Plaza del Sol 5', 2, 37.395500, -5.996000, '14:08'),
(2, 'Parada Norte', 'Calle Mayor 22', 3, 37.392500, -5.990000, '14:15'),
(2, 'Parada Centro', 'Av. Andalucía 10', 4, 37.389000, -5.984000, '14:25');

-- =========================================================
-- 4. MENORES
-- id_familia -> usuarios con rol familia
-- id_ruta -> ruta asignada
-- id_parada_subida / bajada -> paradas
-- =========================================================
INSERT INTO menores (
    nombre,
    apellidos,
    fecha_nacimiento,
    id_familia,
    id_ruta,
    id_parada_subida,
    id_parada_bajada,
    observaciones,
    activo
)
VALUES
('Lucía', 'López García', '2016-05-10', 1, 1, 1, 4, 'Sin observaciones', TRUE),
('Diego', 'López García', '2018-02-17', 1, 1, 2, 4, 'Requiere acompañamiento al bajar', TRUE),
('Sofía', 'Martín Ruiz', '2015-11-03', 2, 1, 2, 4, 'Alergia alimentaria', TRUE),
('Hugo', 'Sánchez Pérez', '2017-09-21', 3, 1, 3, 4, 'Sin observaciones', TRUE);

-- =========================================================
-- 5. TRAYECTOS
-- id_cuidador -> usuario con rol cuidador
-- =========================================================
INSERT INTO trayectos (
    id_ruta,
    id_cuidador,
    fecha,
    hora_inicio,
    hora_fin,
    estado,
    observaciones
)
VALUES
(1, 4, CURRENT_DATE, CURRENT_TIMESTAMP - INTERVAL '35 minutes', NULL, 'en_ruta', 'Trayecto de mañana en curso'),
(2, 4, CURRENT_DATE, NULL, NULL, 'programado', 'Trayecto de tarde pendiente de inicio');

-- =========================================================
-- 6. EVENTOS
-- subida / bajada / incidencia
-- =========================================================
INSERT INTO eventos (
    id_trayecto,
    id_menor,
    tipo_evento,
    fecha_hora,
    id_parada,
    registrado_por,
    observaciones
)
VALUES
(1, 1, 'subida', CURRENT_TIMESTAMP - INTERVAL '30 minutes', 1, 4, 'Subida correcta'),
(1, 2, 'subida', CURRENT_TIMESTAMP - INTERVAL '24 minutes', 2, 4, 'Subida correcta'),
(1, 3, 'subida', CURRENT_TIMESTAMP - INTERVAL '20 minutes', 2, 4, 'Subida correcta'),
(1, 4, 'subida', CURRENT_TIMESTAMP - INTERVAL '15 minutes', 3, 4, 'Subida correcta'),

(1, 1, 'bajada', CURRENT_TIMESTAMP - INTERVAL '2 minutes', 4, 4, 'Bajada correcta'),
(1, 2, 'bajada', CURRENT_TIMESTAMP - INTERVAL '1 minute', 4, 4, 'Bajada con acompañamiento');

-- =========================================================
-- 7. UBICACIONES DEL AUTOBÚS
-- =========================================================
INSERT INTO ubicaciones_bus (
    id_trayecto,
    fecha_hora,
    latitud,
    longitud,
    velocidad,
    precision_metros
)
VALUES
(1, CURRENT_TIMESTAMP - INTERVAL '25 minutes', 37.389500, -5.984500, 28.50, 5.00),
(1, CURRENT_TIMESTAMP - INTERVAL '18 minutes', 37.392800, -5.990500, 31.20, 4.50),
(1, CURRENT_TIMESTAMP - INTERVAL '12 minutes', 37.395900, -5.996500, 26.80, 5.20),
(1, CURRENT_TIMESTAMP - INTERVAL '5 minutes', 37.397600, -6.000800, 18.40, 4.90),
(1, CURRENT_TIMESTAMP - INTERVAL '1 minute', 37.398000, -6.002000, 0.00, 3.80);

-- =========================================================
-- 8. NOTIFICACIONES
-- =========================================================
INSERT INTO notificaciones (
    id_usuario,
    id_trayecto,
    titulo,
    mensaje,
    tipo_notificacion,
    fecha_envio,
    leida
)
VALUES
(1, 1, 'Ruta iniciada', 'El autobús ha iniciado la ruta correctamente.', 'inicio_ruta', CURRENT_TIMESTAMP - INTERVAL '30 minutes', TRUE),
(2, 1, 'Ruta iniciada', 'El autobús ha iniciado la ruta correctamente.', 'inicio_ruta', CURRENT_TIMESTAMP - INTERVAL '30 minutes', TRUE),
(3, 1, 'Ruta iniciada', 'El autobús ha iniciado la ruta correctamente.', 'inicio_ruta', CURRENT_TIMESTAMP - INTERVAL '30 minutes', TRUE),

(1, 1, 'Próxima parada', 'El autobús está próximo a la parada asignada.', 'proxima_parada', CURRENT_TIMESTAMP - INTERVAL '10 minutes', FALSE),
(2, 1, 'Próxima parada', 'El autobús está próximo a la parada asignada.', 'proxima_parada', CURRENT_TIMESTAMP - INTERVAL '10 minutes', FALSE),

(1, 1, 'Llegada al centro', 'El menor ha llegado correctamente al centro escolar.', 'fin_ruta', CURRENT_TIMESTAMP - INTERVAL '1 minute', FALSE);

-- =========================================================
-- Consultas de comprobación 
-- =========================================================
-- SELECT * FROM usuarios;
-- SELECT * FROM rutas;
-- SELECT * FROM paradas;
-- SELECT * FROM menores;
-- SELECT * FROM trayectos;
-- SELECT * FROM eventos;
-- SELECT * FROM ubicaciones_bus;
-- SELECT * FROM notificaciones;
