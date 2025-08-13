# 💵 App de Tipo de Cambio
¡Bienvenido a la aplicación de Tipo de Cambio! Este proyecto es una API RESTful que proporciona información sobre el tipo de cambio del día y gestiona un límite de peticiones por usuario.

## 🚀 Tecnologías Utilizadas
Este proyecto está construido con un stack moderno y eficiente, ideal para microservicios:

Quarkus: El framework nativo de Kubernetes para Java, optimizado para ser ligero y rápido.

* Java 21: La última versión de Java con características y mejoras recientes.

* Jakarta RESTful Web Services: Para la creación de los endpoints REST.

* Jakarta JSON: Para el manejo de datos JSON.

* Jakarta REST Client: Para consumir servicios externos de tipo de cambio.

* PostgreSQL: Base de datos relacional robusta para el almacenamiento de datos.

* Panache: Un ORM de Quarkus que simplifica enormemente la persistencia de datos.

## ⚙️ Funcionalidades Principales
La API ofrece las siguientes funcionalidades clave:

* Consulta de Tipo de Cambio: Proporciona el valor de compra y venta del tipo de cambio del día.

* Registro de Peticiones: Cada consulta realizada por un usuario (identificado por su DNI) se registra en la base de datos.

* Control de Límite: Restringe a cada usuario a un máximo de 10 peticiones por día. Si se supera este límite, la API rechaza la solicitud.

## 🔧 Requisitos Previos
Para ejecutar este proyecto, asegúrate de tener instalado lo siguiente:

* JDK 21 o superior.

* Maven 3.8.1 o superior.

* Docker (opcional, pero recomendado para PostgreSQL).

## 🛠️ Configuración y Ejecución
1. Clonar el repositorio
```
git clone https://github.com/yensxD/api-tipo-cambio.git
cd nombre-del-repo
```

2. Configurar la base de datos
   Se recomienda usar Docker para levantar una instancia de PostgreSQL. Crea un archivo docker-compose.yml en la raíz del proyecto con el siguiente contenido:

```
version: "3.8"

services:

  postgres:
    image: postgres
    restart: always
    environment:
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: 12345
      POSTGRES_DB: db_tipocambio
    ports: 
      - 5432:5432
    volumes:
      - postgres_data:/data

volumes:
  postgres_data:

```

Luego, inicia el contenedor de la base de datos:
```
docker-compose up -d
```

3. Configurar la aplicación
   Abre el archivo ```src/main/resources/application.properties``` y configura los parámetros de conexión a tu base de datos:
```
quarkus.datasource.db-kind=postgresql
quarkus.datasource.username=user
quarkus.datasource.password=password
quarkus.datasource.jdbc.url=jdbc:postgresql://localhost:5432/db_tipocambio
quarkus.hibernate-orm.database.generation=update
```
# Límite de peticiones por usuario por día
app.request.limit=10

4. Ejecutar la aplicación
   Ejecuta la aplicación en modo desarrollo con el siguiente comando:
```
./mvnw quarkus:dev
```

## 🌐 Endpoints de la API
La API principal para la consulta del tipo de cambio es:

```
GET /exchange-rate/{dni}
```
Este endpoint devuelve la información del tipo de cambio del día, junto con la fecha de la consulta.

Ejemplo de Petición:
```
GET http://localhost:9096/exchange-rate/12345678
```
Ejemplo de Petición con fecha:
```
GET http://localhost:9096/exchange-rate/12345678?date=2025-08-12
```
Ejemplo de Respuesta exitosa:
```
{
  "fecha": "2025-08-12",
  "compra": 3.527,
  "venta": 3.535
}
```


Ejemplo de Respuesta con límite excedido:
```
{
  "error": "Too many requests",
  "type": "MAX_DAILY_QUERIES",
  "message": "Tu petición superó el límite máximo de 10 consultas por día. Por favor, inténtalo de nuevo mañana."
}
```
## 👤 Autor
Desarrollado por Yens
