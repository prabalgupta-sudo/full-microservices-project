# 🚀 Microservices-Based Order Management System (with API Gateway & AI Agent)

## 📌 Overview

This project is a **production-ready microservices architecture** built using **Spring Boot, Kubernetes, and AI integration**.

It demonstrates how to design scalable backend systems with:

* 🧩 **Microservices architecture**
* 🔐 **JWT Authentication & Authorization**
* 🔗 **Inter-service communication (Feign Client)**
* 🌐 **API Gateway (Spring Cloud Gateway)**
* ☸️ **Kubernetes Deployment (Minikube)**
* 🤖 **Agentic AI Integration (Gemini LLM)**

---

## 🏗️ Architecture

```
Client (Postman / Curl)
        ↓
API Gateway (Spring Cloud Gateway)
        ↓
 ┌───────────────┬───────────────┬───────────────┐
 │               │               │               │
 ▼               ▼               ▼               ▼
Auth Service   Order Service   Product Service   AI Agent Service
 (JWT)          (Business)      (Data)            (LLM + Logic)
```

---

## 🔁 System Flow

1. 🔐 User logs in via **Auth Service**
2. 🎫 JWT token is generated
3. 🌐 Requests go through **API Gateway**
4. 📦 Order Service fetches data from Product Service
5. 🤖 AI Agent processes natural language queries
6. 📩 Intelligent response returned to user

---

## 🧱 Tech Stack

| Layer            | Technology            |
| ---------------- | --------------------- |
| Backend          | Spring Boot (Java 17) |
| Security         | Spring Security + JWT |
| API Gateway      | Spring Cloud Gateway  |
| Communication    | OpenFeign             |
| AI Integration   | Gemini API            |
| Containerization | Docker                |
| Orchestration    | Kubernetes (Minikube) |
| Build Tool       | Maven                 |

---

## 📦 Microservices

### 🟨 Auth Service

* Port: **8083**
* Handles authentication & JWT generation

**Endpoint:**

```
POST /auth/login
```

---

### 🟩 Order Service

* Port: **8082**
* Secured service
* Calls Product Service via Feign

**Endpoint:**

```
GET /orders/products-from-product-service
```

---

### 🟦 Product Service

* Port: **8081**
* Provides product data

**Endpoint:**

```
GET /products
```

---

### 🤖 AI Agent Service

* Port: **8084**
* Uses Gemini LLM for intelligent responses
* Calls Product Service for context

**Endpoints:**

```
GET /agent/recommend
GET /agent/chat?query=...
```

---

### 🌐 API Gateway

* Port: **30000 (NodePort - Kubernetes)**
* Routes all external traffic to services

---

## 🔐 Authentication Flow

```
User → Auth Service → JWT Token
        ↓
Gateway → Order Service → Validate Token
        ↓
Access Granted / Denied
```

---

## ▶️ Local Setup

### 1️⃣ Build Services

```bash
cd product-service && mvn clean package
cd ../order-service && mvn clean package
cd ../auth-service && mvn clean package
cd ../api-gateway && mvn clean package
cd ../ai-agent-service && mvn clean package
```

---

### 2️⃣ Run Services

```bash
java -jar target/*.jar
```

---

## ☸️ Kubernetes Deployment

### Start Minikube

```bash
minikube start
```

---

### Use Minikube Docker

```bash
eval $(minikube docker-env)
```

---

### Build Images

```bash
docker build -t product-service ./product-service
docker build -t order-service ./order-service
docker build -t auth-service ./auth-service
docker build -t api-gateway ./api-gateway
docker build -t ai-agent-service ./ai-agent-service
```

---

### Apply K8s Config

```bash
kubectl apply -f k8s/
```

---

### Verify

```bash
kubectl get pods
kubectl get services
```

---

## 🧪 API Testing

### 🔑 Login

```bash
curl -X POST http://$(minikube ip):30000/auth/login \
-H "Content-Type: application/json" \
-d '{"username":"admin","password":"admin"}'
```

---

### 🔒 Call Secured API

```bash
curl http://$(minikube ip):30000/orders/products-from-product-service \
-H "Authorization: Bearer YOUR_TOKEN"
```

---

### 🤖 AI Query

```bash
curl --get --data-urlencode "query=Suggest a cheap phone" \
http://$(minikube ip):30000/agent/chat
```

---

## 🎯 Key Features

* ✅ Microservices architecture
* ✅ JWT-based authentication
* ✅ API Gateway routing
* ✅ Kubernetes deployment
* ✅ AI-powered service (Gemini LLM)
* ✅ Real-world production setup

---

## 🚀 Future Enhancements

* 🔍 Service Discovery (Eureka)
* 📊 Observability (Prometheus + Grafana)
* 🗄️ Database integration (PostgreSQL/MySQL)
* 🔄 CI/CD pipeline (GitHub Actions)
* 🧠 Multi-agent AI workflows

---

## 💼 Resume Impact

> Built a scalable microservices system using Spring Boot, Kubernetes, API Gateway, and integrated a Gemini-powered AI agent for intelligent service orchestration.

---

## 👨‍💻 Author

**Prabal Gupta**
AI Engineer | Cloud | Kubernetes | GenAI

---

## ⭐ Support

If you like this project, give it a ⭐ on GitHub!
