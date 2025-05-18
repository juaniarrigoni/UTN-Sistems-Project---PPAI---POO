-- Crear tabla de eventos sísmicos
DROP TABLE IF EXISTS evento_sismico;

CREATE TABLE evento_sismico (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    fecha TEXT NOT NULL,
    estado TEXT NOT NULL,
    magnitud REAL,
    clasificacion TEXT,
    origen TEXT
);

-- Insertar algunos registros de prueba
INSERT INTO evento_sismico (fecha, estado, magnitud, clasificacion, origen)
VALUES
('2024-06-01 08:34:21', 'PENDIENTE', 5.2, 'Tectónico', 'San Juan'),
('2024-06-01 10:15:00', 'PENDIENTE', 3.8, 'Volcánico', 'Neuquén'),
('2024-06-01 12:00:00', 'REVISADO', 4.5, 'Indeterminado', 'Jujuy');
