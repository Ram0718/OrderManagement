# 🚀 Customer Order & Service Management Application

## 📌 Project Overview

This is a **Spring Boot-based REST API project** designed to manage **customers, products, and orders** efficiently.

The application allows:

* Managing customer details
* Managing product catalog
* Placing and tracking orders
* Handling service-level operations

The project follows a **layered architecture** (Controller → Service → Model).

---

## 🛠️ Tech Stack

* Java
* Spring Boot
* Spring Web
* REST APIs
* Maven
* HTML, CSS, JavaScript

---

## 📂 Project Structure

```text
com.example.demo
│
├── controllers
│     ├── CustomerController.java
│     ├── ProductController.java
│     └── OrderController.java
│
├── service
│     ├── CustomerService.java
│     ├── ProductService.java
│     └── OrderService.java
│
├── model
│     ├── Customer.java
│     ├── Product.java
│     ├── Order.java
│     └── OrderItem.java
│
└── DemoApplication.java
```

---

## 🧱 Entity Classes

### 👤 Customer

* id
* name
* email
* phone

### 📦 Product

* id
* name
* price
* quantity

### 🛒 Order

* id
* customerId
* orderDate

### 📄 OrderItem

* id
* productId
* quantity
* price

---

## 🔥 Features

✅ Customer Management (CRUD)
✅ Product Management (CRUD)
✅ Order Placement & Tracking
✅ Service Layer Implementation
✅ RESTful API Design
✅ Clean layered architecture

---

## 🌐 API Endpoints

### 👤 Customer APIs

**POST** `/customers` → Add Customer
**GET** `/customers` → Get All Customers
**GET** `/customers/{id}` → Get Customer by ID
**PUT** `/customers/{id}` → Update Customer
**DELETE** `/customers/{id}` → Delete Customer

---

### 📦 Product APIs

**POST** `/products` → Add Product
**GET** `/products` → Get All Products
**GET** `/products/{id}` → Get Product by ID
**PUT** `/products/{id}` → Update Product
**DELETE** `/products/{id}` → Delete Product

---

### 🛒 Order APIs

**POST** `/orders` → Place Order
**GET** `/orders` → Get All Orders

---

## ▶️ How to Run the Project

### 1️⃣ Clone Repository

```bash
git clone <your-repo-url>
```

### 2️⃣ Open in IDE

* Eclipse / IntelliJ

### 3️⃣ Run Application

```bash
DemoApplication.java
```

### 4️⃣ Access API

```bash
http://localhost:8080
```

---

## 🧪 Testing

Use:

* Postman
* Thunder Client

---

## 💡 Key Concepts Used

* Spring Boot REST APIs
* Dependency Injection (`@Autowired`)
* Service Layer Architecture
* CRUD Operations
* JSON Handling
* Multi-entity design

---

## 🚀 Future Enhancements

* ✅ Add database (MySQL + JPA)
* ✅ Global Exception Handling
* ✅ Validation (`@Valid`)
* ✅ Swagger API Documentation
* ✅ Authentication (Spring Security)

---

## 🙌 Author

**Rambabu Darnasi**
Java Developer

---
