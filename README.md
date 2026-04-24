# 🚀 Microservices-Based Order Management System

## 📌 Overview

This project is a **Spring Boot Microservices Architecture** implementing an **Order Management System** with secure communication using **JWT Authentication**.

It demonstrates real-world backend concepts like:

* Microservices architecture
* Inter-service communication (Feign Client)
* Authentication & Authorization (JWT)
* REST APIs
* Docker (deployment ready)

---

## 🏗️ Architecture

```
Client (Postman / Curl / Frontend)
        ↓
Auth Service (JWT Authentication)
        ↓
Order Service (Secured APIs)
        ↓
Product Service (Data Provider)
```

---

## 🛠️ Tech Stack

* **Java 17**
* **Spring Boot**
* **Spring Security**
* **Spring Cloud OpenFeign**
* **JWT (JSON Web Token)**
* **Maven**
* **Docker** (optional / upcoming)

---

## 📦 Microservices

### 🟦 Product Service

* Port: **8081**
* Provides product data
* Endpoint:

  ```
  GET /products
  ```

---

### 🟩 Order Service

* Port: **8082**
* Secured using JWT
* Communicates with Product Service via Feign Client

#### Endpoint:

```
GET /orders/products-from-product-service
```

---

### 🟨 Auth Service

* Port: **8083**
* Handles authentication and token generation

#### Endpoint:

```
POST /auth/login
```

#### Request Body:

```json
{
  "username": "admin",
  "password": "admin"
}
```

#### Response:

```json
{
  "token": "JWT_TOKEN"
}
```

---

## 🔐 Authentication Flow

1. User logs in via **Auth Service**
2. JWT Token is generated
3. Token is passed in header to Order Service
4. Order Service validates token
5. If valid → request proceeds

---

## ▶️ How to Run

### 1️⃣ Build all services

```bash
cd product-service && mvn clean package
cd ../order-service && mvn clean package
cd ../auth-service && mvn clean package
```

---

### 2️⃣ Run services

```bash
# Product Service
cd product-service
java -jar target/*.jar

# Order Service
cd ../order-service
java -jar target/*.jar

# Auth Service
cd ../auth-service
java -jar target/*.jar
```

---

## 🧪 Testing APIs

### 🔑 Step 1: Get Token

```bash
curl -X POST http://localhost:8083/auth/login \
-H "Content-Type: application/json" \
-d '{"username":"admin","password":"admin"}'
```

---

### 🔒 Step 2: Call Secured API

```bash
curl http://localhost:8082/orders/products-from-product-service \
-H "Authorization: Bearer YOUR_TOKEN"
```

---

## 🐳 Docker (Next Step)

You can containerize all services using Docker and run them using:

```bash
docker-compose up --build
```

---

## 🎯 Key Features

* ✅ Microservices architecture
* ✅ JWT-based authentication
* ✅ Secure REST APIs
* ✅ Feign client for service communication
* ✅ Production-ready structure

---

## 📌 Future Enhancements

* API Gateway (Spring Cloud Gateway)
* Service Discovery (Eureka)
* Database integration (MySQL/PostgreSQL)
* Kubernetes deployment

---

## 👨‍💻 Author

**Prabal Gupta**

---

## ⭐ If you like this project

Give it a ⭐ on GitHub!
