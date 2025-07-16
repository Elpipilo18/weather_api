-- Crear al usuario 'grails_user' si no existe
CREATE USER IF NOT EXISTS 'grails_user'@'%' IDENTIFIED BY 'grails_password';

-- Otorgar permisos a 'grails_user' para las bases de datos nuevas y existentes
GRANT ALL PRIVILEGES ON weather_app.* TO 'grails_user'@'%';

-- Aplicar los privilegios
FLUSH PRIVILEGES;