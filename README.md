# 📝 BBT Blog Platform

A modern full-stack blog platform.

Frontend: **Next.js (App Router)**  
Backend: **Spring Boot + JWT + PostgreSQL**  
Deployment: **Vercel + Railway**

---

## 🚀 Live Demo

Frontend: https://bbt-blog.vercel.app  
Backend API: https://bbt-blog-project-production.up.railway.app

---

## 📌 Features

### 👤 Authentication & Users
- JWT based authentication
- Register & Login
- Role based authorization (USER / ADMIN)
- Session management with LocalStorage

### 📰 Blog System
- Blog listing
- Blog detail page
- Create blog post (ADMIN only)
- Delete blog post (ADMIN only)
- Highlight latest published post

### 🛡️ Security
- Spring Security
- JWT authentication filter
- Role based access control
- CORS configuration
- Password hashing with BCrypt

### 📱 UI / UX
- Fully responsive design (mobile & desktop)
- Tailwind CSS styling
- shadcn/ui components
- Modern card layouts
- Mobile navigation menu (Sheet)
- Avatar & dropdown menu
- Separator components

---

## 🧰 Tech Stack

### Frontend
- Next.js 14 (App Router)
- React
- Axios
- Tailwind CSS
- shadcn/ui
- Moment.js
- React Icons

### Backend
- Java Spring Boot
- Spring Security
- JWT Authentication
- Hibernate / JPA
- PostgreSQL
- Maven

### DevOps / Deployment
- Docker (local development)
- Railway (backend + database hosting)
- Vercel (frontend hosting)
- Git & GitHub

---

## 🗂️ Project Architecture

### Backend Layers
- Controller (REST API)
- Service
- Repository
- Entity
- DTO
- Security (JWT Filter, SecurityConfig)

### Frontend Structure
- Next.js App Router
- Services (API layer)
- Context API (UserContext)
- UI Components
- Protected routes

---

## 🔐 Role System

| Role  | Permissions |
|-------|-------------|
| USER  | View blog posts |
| ADMIN | Create, delete and manage blog posts |

---

## ⚙️ Local Setup

### Backend

```bash
cd backend
mvn clean install
mvn spring-boot:run
