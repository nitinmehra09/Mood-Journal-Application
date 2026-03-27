# 📝 Mood Journal Application

[](https://spring.io/projects/spring-boot)
[](https://redislabs.com/)
[](https://www.mongodb.com/)

**Mood Journal** is a high-performance backend ecosystem designed to help users track their emotional journey. By combining **Spring Boot** with **Redis Cloud Caching** and **MongoDB**, this app doesn't just store memories—it contextually enriches them with real-time weather data.

-----

## 🚀 Key Features

  * **🔒 Secure Vault**: Robust user authentication and authorization using Spring Security.
  * **🌤️ Weather-Aware**: Automatically fetches and logs weather data for every entry.
  * **⚡ Blazing Fast Caching**: Utilizes **Redis Cloud** to cache weather API responses, reducing latency from \~500ms to \<10ms.
  * **📊 NoSQL Architecture**: Built on MongoDB for flexible, document-based storage of complex journal entries.
  * **🛠️ RESTful Design**: Clean, intuitive API endpoints for full CRUD operations.

-----

## 🛠️ Tech Stack

  * **Backend:** Java 17, Spring Boot 3.3.5
  * **Security:** Spring Security (Basic Auth)
  * **Database:** MongoDB Atlas (Persistent Storage)
  * **Caching:** Redis Cloud (Performance Layer)
  * **JSON Handling:** Jackson & Lombok

-----

## ⚙️ Installation & Setup

### 1\. Prerequisites

  * Java 17 or higher
  * Maven 3.x
  * A Redis Cloud instance (ap-south-1)

### 2\. Configuration (`application.yml`)

To connect to your Redis Cloud instance securely, ensure your configuration matches this setup (Standard for Redis Cloud Free Tier):

```yaml
spring:
  data:
    redis:
      url: redis://default:your_password@your-redis-host:port
      ssl:
        enabled: false # Standard for free-tier non-SSL records
    mongodb:
      host: localhost
      port: 27017
      database: journalDb
```

### 3\. Run the App

```bash
mvn clean install
mvn spring-boot:run
```

-----

## 🛸 API Navigation Map

The Mood Journal API is divided into public access and secure personal vaults.

### 🔓 Public Gateways

| Endpoint | Method | Description |
| :--- | :--- | :--- |
| `/public/signup` | `POST` | Register a new journal account. |
| `/public/login` | `POST` | Authenticate and receive access. |
| `/public/weather-api` | `GET` | Fetch weather data (Powered by **Redis Cache**). |

### 🔐 Private Vaults (Requires Auth)

| Endpoint | Method | Description |
| :--- | :--- | :--- |
| `/journal` | `GET` | Retrieve all your journal entries. |
| `/journal` | `POST` | Log a new mood and journal entry. |
| `/journal/id/{id}` | `GET` | Fetch a specific memory by ID. |
| `/journal/id/{id}` | `DELETE`| Permanently remove an entry. |
| `/user` | `PUT` | Update your user profile settings. |

-----

## 🏗️ Project Architecture

```text
src/main/java/com/moodjournal/
├── config/        # Redis & Security configurations
├── controller/    # REST API Layer
├── entities/      # MongoDB Document Models
├── repos/         # Data Access Objects (Spring Data)
├── service/       # Business Logic & Weather Integration
└── cache/         # Redis Caching logic
```

-----

## 🛡️ Security Best Practices

This repository uses a `.gitignore` to protect sensitive credentials. If you are contributing:

1.  **Never** push your `application-dev.yml` with real passwords.
2.  Use **Environment Variables** for production secrets.
3.  Ensure your IP is whitelisted in the **Redis Cloud Console** CIDR rules.

-----

## 🤝 Contributing

1.  Fork the Project
2.  Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3.  Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4.  Push to the Branch (`git push origin feature/AmazingFeature`)
5.  Open a Pull Request

-----

**Developed with ❤️ by [Nitin Mehra](https://github.com/nitinmehra09)**
