💰 ClearSpend – Personal Expense Tracker

🚀 ClearSpend is a personal finance management application that helps users track income, manage expenses, and analyze monthly spending patterns.

The system allows users to record financial transactions, categorize expenses, and generate summaries to improve financial awareness and budgeting.

💻 Built using Java, Spring Boot, Maven, and REST APIs with a clean layered architecture.


✨ Features

✔️ Add income and expense transactions

✔️ Categorize expenses

✔️ Retrieve transactions by date

✔️ Monthly expense summary

✔️ Transaction statistics

✔️ RESTful API architecture

✔️ Clean backend structure



🛠️ Tech Stack

Backend : :-

    ☕ Java

    🌱 Spring Boot

    🗄️ Spring Data JPA

    🔗 Hibernate

    🌐 REST APIs

Database : :-

    🐬 MySQL / H2


Tools : :-

    🖥️ Eclipse IDE

    📬 Postman

    🔧 Maven

    🐙 Git & GitHub

    🚀 Apache Tomcat


📁 Project Structure : :-

    ClearSpend
      │
      ├── src/main/java/com/clearspend
      │   ├── controller
      │   │      ExpenseController.java
      │   │      CategoryController.java
      │   │      UserController.java
      │   │
      │   ├── service
      │   │      ExpenseService.java
      │   │
      │   ├── repository
      │   │      ExpenseRepository.java
      │   │
      │   ├── entity
      │   │      Expense.java
      │   │      Category.java
      │   │      User.java
      │   │
      │   ├── dto
      │   │      MonthlySummaryDto.java
      │   │
      │   └── exception
      │
      ├── src/main/resources
      │   └── application.properties
      │
      └── pom.xml


⚙️ How the Application Works : :-

    1️⃣ User adds income or expense transactions
    2️⃣ Data is stored in the database through the repository layer
    3️⃣ The service layer processes business logic
    4️⃣ Controllers expose REST APIs
    5️⃣ Users can view transactions and monthly summaries


⚡ Installation & Setup : :-

1️⃣ Clone the repository

    git clone https://github.com/your-username/ClearSpend.git

2️⃣ Open the project

Import the project into Eclipse / IntelliJ as a Maven Project

3️⃣ Configure database

Update application.properties

    spring.datasource.url=jdbc:mysql://localhost:3306/clearspend
    spring.datasource.username=root
    spring.datasource.password=yourpassword
    spring.jpa.hibernate.ddl-auto=update

4️⃣ Run the application

Start the Spring Boot application
    
    http://localhost:8080

🚀 Future Improvements : :-

  📊 Dashboard for analytics
    
  🔐 User authentication (Login / Signup)
    
  📱 Frontend UI integration
    
  📑 Export reports
    
  💡 Budget planning system

    
