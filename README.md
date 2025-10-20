# Tablero Interactivo



##  Descripción

Tablero Interactivo es una aplicación web colaborativa que permite a múltiples usuarios dibujar simultáneamente en un lienzo compartido en tiempo real. Cada usuario puede dibujar con un color distintivo y los cambios son visibles para todos los participantes de forma instantánea. El proyecto también incluye una funcionalidad de borrado sincronizado.

La aplicación utiliza:
- **Frontend**: ReactJS para la interfaz de usuario y P5.js para las funcionalidades de dibujo
- **Backend**: Spring Boot para gestionar la comunicación en tiempo real entre los usuarios

## Requisitos previos

Para ejecutar este proyecto necesitarás:

- Java JDK 11 o superior
- Maven 3.6+
- Node.js 16+ y npm
- Navegador web moderno (Chrome, Firefox, Edge, Safari)
- Git (opcional, para clonar el repositorio)

##  Instalación y ejecución

### Backend (Spring Boot)

1. Clona el repositorio:
   ```bash
   git clone https://github.com/Juan-cely-l/Tablero.git
   cd Tablero/backend
   ```

2. Compila e inicia el servidor con Maven:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

3. El servidor estará disponible en `http://localhost:8080`

### Frontend (ReactJS + P5.js)

1. Navega a la carpeta del frontend:
   ```bash
   cd ../frontend
   ```

2. Instala las dependencias:
   ```bash
   npm install
   ```

3. Inicia la aplicación:
   ```bash
   npm start
   ```

4. La aplicación estará disponible en `http://localhost:3000`

##  Ejemplo de uso

1. Abre la aplicación en el navegador accediendo a `http://localhost:3000`

2. Al cargar la aplicación, se te asignará automáticamente un color único para dibujar

3. Haz clic y arrastra el ratón para dibujar en el tablero

4. Otros usuarios conectados verán tus trazos en tiempo real con tu color asignado

5. Utiliza el botón "Borrar todo" para limpiar el tablero (esta acción afectará a todos los usuarios conectados)

6. Puedes ver cuántos usuarios están conectados en tiempo real en el contador de la esquina superior derecha

##  Arquitectura del sistema

<img width="990" height="677" alt="image" src="https://github.com/user-attachments/assets/5df1fb0c-6b71-4078-b2a7-6fc9dc65b419" />


##  Flujo de trabajo

1. Los usuarios se conectan a la aplicación a través de sus navegadores
2. El servidor asigna un color único a cada usuario
3. Cuando un usuario dibuja en su lienzo local:
   - P5.js captura los movimientos del ratón
   - Los datos de dibujo (coordenadas, color, grosor) se envían al servidor via WebSockets
   - El servidor distribuye estos datos a todos los demás usuarios conectados
   - Los clientes reciben los datos y los representan en sus lienzos respectivos
4. El botón de borrado envía un comando de limpieza al servidor, que lo retransmite a todos los usuarios

