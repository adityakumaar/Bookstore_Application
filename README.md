# Bookstore Application
OOPS Bookstore Application project
---
Developed by:
<ul>
    <li>Aditya Kumar (202212046)</li>
    <li>Harsh Mangroliya (202212084)</li>
    <li>Gaurav Bardia (202212069)</li>
    <li>Denish Vaghasia (202212028)</li>
</ul>

---
### Table of Contents
1. Introduction
2. Project Architecture
3. Libraries
4. Use of HashMap
5. Use of ArrayList

---
### Introduction
<h4>The aim of this project is to develop a Bookstore Application in Java Programming language using the OOPS concepts.</h4>

---
### Project Architecture
<h4>All the functionalities are divided and defined in separate classes</h4>
1. Main.java contains the main menu <br>
2. Book.java returns all the information about the books. <br>
   1. Book ID <br>
   2. Title <br>
   3. Price <br>
   4. Quantity <br>
3. BookStore.java stores all the information about the books in an ArrayList. <br>
   <br>Methods implemented in this file:<br>
   1. addBook() <br>
   2. sellBook() <br>
   3. displayBooks() <br>
4. PurchaseDetails.java stores and prints all the information that needs to be displayed after the transaction is made. <br>
   <br>Methods implemented in this file: <br>
   1. printRecord() <br>
5. User.java stores the username, password, fullname, balance of the user<br>
6. UserOperations.java handles all the user activities<br>
   1. register() <br>
   2. login() <br>
   3. purchase() <br>
   4. resetPassword <br>
   5. logout() <br>

---
### Libraries
<h4> The following libraries are used to develop this program </h4> <br>
<h4> Inbuilt libraries </h4>

1. java.util.ArrayList <br>
2. import java.util.* <br>
3. import java.io.Console <br>

<h4> Custom library </h4>

1. BookPack <br>
   1. Book.java <br>
   2. BookStore.java <br>
   3. PurchaseDetails.java <br>
   4. User.java <br>
   5. UserOperations.java <br>

---
### Use of HashMap
<h4> The HashMap is used for storing the user details with username as the key and User object as the value </h4>

---
### Use of ArrayList
<h4> The ArrayList is used for storing the Books and creating a Purchase Data Base </h4>




