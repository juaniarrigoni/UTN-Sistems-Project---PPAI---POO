-- Crear tablas
CREATE TABLE IF NOT EXISTS usuarios (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    legajo TEXT NOT NULL UNIQUE,
    nombre TEXT NOT NULL,
    apellido TEXT NOT NULL,
    rol TEXT NOT NULL,
    activo BOOLEAN NOT NULL DEFAULT true
);

CREATE TABLE IF NOT EXISTS eventos_sismicos (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    fecha_hora TIMESTAMP NOT NULL,
    magnitud REAL NOT NULL,
    profundidad REAL NOT NULL,
    latitud REAL NOT NULL,
    longitud REAL NOT NULL,
    estado TEXT NOT NULL,
    observaciones TEXT
);

CREATE TABLE IF NOT EXISTS cambios_estado (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    evento_id INTEGER NOT NULL,
    usuario_id INTEGER NOT NULL,
    estado_anterior TEXT NOT NULL,
    estado_nuevo TEXT NOT NULL,
    fecha_hora TIMESTAMP NOT NULL,
    observaciones TEXT,
    FOREIGN KEY (evento_id) REFERENCES eventos_sismicos(id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

-- Insertar datos de prueba
INSERT INTO usuarios (legajo, nombre, apellido, rol) VALUES
('12345', 'Juan', 'Pérez', 'ANALISTA'),
('67890', 'María', 'González', 'ANALISTA'),
('11111', 'Carlos', 'Rodríguez', 'SUPERVISOR');

INSERT INTO eventos_sismicos (fecha_hora, magnitud, profundidad, latitud, longitud, estado) VALUES
('2024-03-15 10:30:00', 5.2, 35.5, -34.6037, -58.3816, 'PENDIENTE'),
('2024-03-15 11:15:00', 4.8, 28.3, -34.6037, -58.3816, 'PENDIENTE'),
('2024-03-15 12:00:00', 6.1, 42.1, -34.6037, -58.3816, 'PENDIENTE');