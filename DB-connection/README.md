# MySQL Database Connection: JDBC vs. Hibernate

This project demonstrates how to connect to a **MySQL database** (`java_db`) using two standard approaches:
1. **JDBC (Java Database Connectivity)** — Raw SQL, low-level control.
2. **Hibernate (JPA / ORM)** — Object-Relational Mapping with entity annotations, automated queries, and schema synchronization.

---

## 🗄️ Database Configuration

- **Host & Port:** `localhost:3306`
- **Database Name:** `java_db`
- **Username:** `root`
- **Password:** `root`

---

## 📂 Project Structure

```
jdbc-project/
├── pom.xml                                    # Maven configuration (MySQL Connector, Hibernate 6, SLF4J)
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           ├── Main.java              # Unified entry point running both approaches
│   │   │           ├── model/
│   │   │           │   └── Student.java       # JPA Entity mapped to table 'students'
│   │   │           ├── jdbc/
│   │   │           │   └── JdbcStudentDemo.java     # Approach 1: Plain JDBC CRUD
│   │   │           └── hibernate/
│   │   │               ├── HibernateUtil.java       # SessionFactory helper
│   │   │               └── HibernateStudentDemo.java# Approach 2: Hibernate ORM CRUD
│   │   └── resources/
│   │       └── hibernate.cfg.xml              # Hibernate MySQL configuration
```

---

## 🚀 How to Run

Navigate into the project directory:
```powershell
cd c:\Users\ujjva\Desktop\jdbc\jdbc-project
```

### 1. Run Both Approaches (Comparison Demo)
```powershell
mvn exec:java "-Dexec.mainClass=com.example.Main"
```

### 2. Run Only the JDBC Approach
```powershell
mvn exec:java "-Dexec.mainClass=com.example.jdbc.JdbcStudentDemo"
```

### 3. Run Only the Hibernate Approach
```powershell
mvn exec:java "-Dexec.mainClass=com.example.hibernate.HibernateStudentDemo"
```

---

## ⚖️ Key Comparison: JDBC vs. Hibernate

| Feature | JDBC Approach | Hibernate (ORM) Approach |
| :--- | :--- | :--- |
| **Paradigm** | Direct SQL execution | Object-Relational Mapping (ORM) |
| **Table Management** | Manual `CREATE TABLE` / `ALTER TABLE` | Automatic DDL (`hbm2ddl.auto = update`) |
| **Insert / Save** | `PreparedStatement.executeUpdate()` | `session.persist(entity)` |
| **Fetch / Query** | `ResultSet` iteration and mapping | `session.get()` or HQL (`FROM Student`) |
| **Update** | Manual `UPDATE` statement | Managed state mutation & dirty checking |
| **Delete** | Manual `DELETE` statement | `session.remove(entity)` |
| **Boilerplate** | High (Connections, Statements, ResultSets) | Low (Handled by Hibernate `Session`) |
