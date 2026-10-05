![License](https://img.shields.io/badge/license-MIT-green)
![Status](https://img.shields.io/badge/status-completado-success)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.5-brightgreen)
![Java](https://img.shields.io/badge/Java-17-orange)
![Maven](https://img.shields.io/badge/Maven-3.8%2B-blue)
![Architecture](https://img.shields.io/badge/Architecture-Hexagonal-purple)
![Database](https://img.shields.io/badge/Database-H2-blue)
![Build](https://img.shields.io/badge/build-passing-brightgreen)
![Tests](https://img.shields.io/badge/tests-skipped-yellow)
![PRs](https://img.shields.io/badge/PRs-welcome-brightgreen)

---

# 🚀 Customer Microservice - Arquitectura Hexagonal

Microservicio REST para la gestión de clientes (Customers) construido con **Spring Boot 3.3.5** y **Arquitectura Hexagonal** (Ports & Adapters).

Este proyecto forma parte del **Reto 3** del curso *Desarrollo Web Frameworks 5*.

---

## 📋 Tabla de Contenidos

- [Descripción](#-descripción)
- [Arquitectura Hexagonal](#️-arquitectura-hexagonal)
- [Tecnologías](#️-tecnologías)
- [Requisitos Previos](#-requisitos-previos)
- [Instalación y Ejecución](#-instalación-y-ejecución)
- [Endpoints](#-endpoints)
- [Base de Datos H2](#️-base-de-datos-h2)
- [Estructura del Proyecto](#-estructura-del-proyecto)
- [Pruebas](#-pruebas)
- [Capturas de Pantalla](#-capturas-de-pantalla)
- [Principios Aplicados](#-principios-de-la-arquitectura-hexagonal-aplicados)
- [Autor](#-autor)
- [Licencia](#-licencia)

---

## 📋 Descripción

Este microservicio permite:

- ✅ **Crear** nuevos clientes (`POST /api/customers`)
- ✅ **Listar** todos los clientes (`GET /api/customers`)

Diseñado siguiendo los principios de la **Arquitectura Hexagonal** (Ports & Adapters), lo que garantiza:

- 🔌 **Desacoplamiento** entre la lógica de negocio y la infraestructura
- 📈 **Escalabilidad** para añadir nuevos adaptadores sin tocar el dominio
- 🧪 **Testabilidad** al poder probar el dominio sin frameworks
- 🧹 **Mantenibilidad** con responsabilidades claras por capa

```

## 🏗️ Arquitectura Hexagonal
┌─────────────────────────────────────────────────┐
│ INFRAESTRUCTURA │
│ ┌───────────────────────────────────────────┐ │
│ │ APLICACIÓN (Casos de Uso) │ │
│ │ ┌─────────────────────────────────────┐ │ │
│ │ │ DOMINIO │ │ │
│ │ │ - Customer (Modelo) │ │ │
│ │ │ - CustomerRepositoryPort (Puerto) │ │ │
│ │ │ - CustomerService (Servicio) │ │ │
│ │ └─────────────────────────────────────┘ │ │
│ └───────────────────────────────────────────┘ │
│ │
│ Adaptadores: │
│ - IN: CustomerController (REST) │
│ - OUT: CustomerPersistenceAdapter (JPA) │
└─────────────────────────────────────────────────┘

text

### Capas

| Capa | Responsabilidad | Dependencias |
|------|-----------------|--------------|
| 🟡 **Dominio** | Reglas de negocio puras | Ninguna (solo Java) |
| 🟢 **Aplicación** | Casos de uso | Solo dominio |
| 🔵 **Infraestructura** | Adaptadores (REST, JPA, Config) | Dominio + Frameworks |

---

## 🛠️ Tecnologías

| Tecnología | Versión | Propósito |
|------------|---------|-----------|
| ☕ Java | 17 | Lenguaje |
| 🍃 Spring Boot | 3.3.5 | Framework principal |
| 🌐 Spring Web | - | REST API |
| 💾 Spring Data JPA | - | Persistencia |
| 🗄️ H2 Database | - | Base de datos en memoria |
| 🦋 Lombok | - | Reducción de boilerplate |
| 📦 Maven | 3.8+ | Gestión de dependencias |

---

## ⚙️ Requisitos Previos

- **JDK 17** o superior
- **Maven 3.8+** (o usar el wrapper `mvnw` incluido)
- **Postman** o **Thunder Client** (opcional, para pruebas)

---

## 🚀 Instalación y Ejecución

### 1. Clonar el repositorio

```bash
git clone https://github.com/everest9957/Reto3_Constr_Microserv_Funcional.git
cd Reto3_Constr_Microserv_Funcional/customer-microservice
2. Compilar el proyecto
bash
mvn clean compile
3. Ejecutar la aplicación
bash
mvn spring-boot:run
O bien, empaquetar y ejecutar el JAR:

bash
mvn clean package
java -jar target/customer-microservice-0.0.1-SNAPSHOT.jar
4. Acceder
El servicio estará disponible en:

text
http://localhost:8080
📡 Endpoints
1. Crear Cliente
http
POST /api/customers
Content-Type: application/json
Body:

json
{
  "nombre": "Juan Pérez",
  "email": "juan.perez@example.com"
}
Respuesta (201 Created):

json
{
  "id": 1,
  "nombre": "Juan Pérez",
  "email": "juan.perez@example.com"
}
2. Listar Clientes
http
GET /api/customers
Respuesta (200 OK):

json
[
  {
    "id": 1,
    "nombre": "Juan Pérez",
    "email": "juan.perez@example.com"
  }
]
🗄️ Base de Datos H2
Accede a la consola web de H2 en:

text
http://localhost:8080/h2-console
Configuración de conexión:

Campo	Valor
JDBC URL	jdbc:h2:mem:customerdb
User Name	sa
Password	(vacío)
Consulta de ejemplo:

sql
SELECT * FROM CUSTOMERS;
📂 Estructura del Proyecto
text
customer-microservice/
├── src/main/java/com/curso/customer/
│   ├── CustomerMicroserviceApplication.java   # Clase principal
│   │
│   ├── domain/                                # 🟡 Núcleo del negocio
│   │   ├── model/
│   │   │   └── Customer.java                  # Entidad de dominio
│   │   ├── repository/
│   │   │   └── CustomerRepositoryPort.java    # Puerto de salida
│   │   └── service/
│   │       └── CustomerService.java           # Servicio de dominio
│   │
│   ├── application/                           # 🟢 Casos de uso
│   │   └── usecase/
│   │       ├── CreateCustomerUseCase.java
│   │       └── GetAllCustomersUseCase.java
│   │
│   └── infrastructure/                        # 🔵 Adaptadores
│       ├── adapter/
│       │   ├── in/web/                        # Adaptador REST
│       │   │   ├── CustomerController.java
│       │   │   └── dto/
│       │   │       ├── CustomerRequest.java
│       │   │       └── CustomerResponse.java
│       │   └── out/persistence/               # Adaptador JPA
│       │       ├── CustomerJpaEntity.java
│       │       ├── CustomerJpaRepository.java
│       │       ├── CustomerMapper.java
│       │       └── CustomerPersistenceAdapter.java
│       └── config/
│           └── BeanConfiguration.java         # Configuración de beans
│
└── src/main/resources/
    └── application.properties                  # Configuración
🧪 Pruebas
Con Postman / Thunder Client / Insomnia
1. Crear cliente:

Método: POST

URL: http://localhost:8080/api/customers

Body (raw JSON):

json
{
  "nombre": "Juan Pérez",
  "email": "juan.perez@example.com"
}
2. Listar clientes:

Método: GET

URL: http://localhost:8080/api/customers

Con cURL
bash
# Crear cliente
curl -X POST http://localhost:8080/api/customers \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Juan Pérez","email":"juan.perez@example.com"}'

# Listar clientes
curl http://localhost:8080/api/customers
📸 Capturas de Pantalla
Las capturas del proceso de desarrollo se encuentran en la carpeta capturas/:

#	Captura	Descripción
01	01_spring_initializr.png	Configuración en Spring Initializr
02	02_proyecto_importado.png	Proyecto importado en IntelliJ IDEA
03	03_estructura_hexagonal.png	Estructura de carpetas hexagonal
04	04_entidad_customer.png	Clase Customer.java
05	05_puerto_repositorio.png	Puerto CustomerRepositoryPort.java
06	06_servicio_dominio.png	Servicio CustomerService.java
07	07_casos_uso.png	Casos de uso de la aplicación
08	08_controlador_rest.png	Controlador REST
09	09_adaptador_persistencia.png	Adaptador JPA
10	10_app_ejecutando.png	Aplicación Spring Boot corriendo
11	11_postman_post.png	Petición POST exitosa
12	12_postman_get.png	Petición GET exitosa
13	13_h2_console.png	Consola H2 con datos
14	14_repositorio_github.png	Repositorio en GitHub
🎯 Principios de la Arquitectura Hexagonal aplicados
Inversión de dependencias: El dominio define puertos (CustomerRepositoryPort) que la infraestructura implementa (CustomerPersistenceAdapter).

Separación de responsabilidades: Cada capa tiene una única responsabilidad bien definida.

Independencia de frameworks: El dominio es Java puro, sin dependencias de Spring.

Testabilidad: El dominio y los casos de uso se pueden probar sin levantar la app.

Escalabilidad: Se pueden añadir nuevos adaptadores (gRPC, GraphQL, mensajería) sin modificar el dominio.

👨‍💻 Autor
Judit Giravent

GitHub: @everest9957

Repositorio: Reto3_Constr_Microserv_Funcional

Proyecto desarrollado como parte del Reto 3 del curso Desarrollo Web Frameworks 5.

📄 Licencia
Este proyecto está bajo la licencia MIT. Consulta el archivo LICENSE para más detalles.