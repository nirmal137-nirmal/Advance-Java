# Advance-Java

## JDBC Connection in Java
📌 Overview

This project demonstrates how to establish a JDBC (Java Database Connectivity) connection between a Java application and a MySQL database.

JDBC allows Java applications to connect with databases and perform operations such as:

Insert data
Update data
Delete data
Search data
Retrieve records
Execute SQL queries

-------------------------------------------------------------------------------------------------------------------------

## 🔗 JDBC Connection Steps

## There are mainly 5 steps to connect Java with MySQL:

## 1. Load JDBC Driver
Class.forName("com.mysql.cj.jdbc.Driver");


## 2. Establish Database Connection
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/student_db",
    "root",
    "password"
);

## 3. Create Statement
Statement stmt = con.createStatement();

## 4. Execute SQL Query
ResultSet rs = stmt.executeQuery("SELECT * FROM student");

## S5. Close Connection
con.close();

----------------------------------------------------------------------------------------------------------------------------

## 🎯 CRUD Operations

This project covers the basic CRUD operations:

## Operation	SQL Command	JDBC Method

Create	INSERT	executeUpdate(),

Read	SELECT	executeQuery(),

Update	UPDATE	executeUpdate(),

Delete	DELETE	executeUpdate()
