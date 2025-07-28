
# NavigateNow

## Description

The objective of this project is to develop a web application tailored for the tourism industry, assisting tourists worldwide in accessing information about Sydney's attractions. Diverging from traditional tourism models, users can plan their trips directly via our application instead of relying on travel agencies or other third-party platforms. This approach ensures that the information presented is transparent, concise, and easily comprehensible, allowing for better expenses and checklist planning. 

## Technologies Used

* **Spring Boot:** Provides the framework for the backend application.
* **Java:** The primary programming language that is used for the server-side development.
* **MySQL:** The relational database for storing the user data, tourism places, feedback, checklists and all other information.
* **Javascript:** Used for client-side functionality and interactivity.
* **HTML/CSS:** Frontend development to create the user interface.

## Installation

Before you begin, ensure you have the following software and tools installed on your machine:

- Java Development Kit (JDK) 17
- IntelliJ IDEA
- XAMPP
- MySQL Database Server

## Usage

1. **Database Setup:**
* Start XAMPP and launch the Apache and MySQL services.
* Open the XAMPP Control Panel(Windows) and click on "Admin" for MySQL or http://localhost/phpmyadmin (Mac) to access phpMyAdmin.

2. **Database Configuration:**
* Create a new MySQL database for the project. You can do this through phpMyAdmin or by running SQL scripts.
* Update the database connection properties in **"src/main/resources/application.yaml"** to match your MySQL server configuration.

&emsp;&emsp;&emsp;&emsp;`spring:` \
&emsp;&emsp;&emsp;&emsp;&emsp;`datasource:` \
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;`driver-class-name: com.mysql.cj.jdbc.Driver` \
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;`username: "your_username"` \
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;`url: jdbc:mysql://localhost:3306/navigatenow-db` \
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;`password: "your_password"`

3. **Import the Project into IntelliJ IDEA:**

* Open IntelliJ IDEA and select "File" > "Open" and navigate to the project folder.
* Choose the **pom.xml** file to import the project as a Maven project.

4. **Run the Application:**

* Locate the *NavigateNowApplication* class in the project.
* Right-click on the class and select "Run *NavigateNowApplication*."

5. **Access the Website:**

* Open a web browser and go to http://localhost:8080 to access the NavigateNow Website.

6. **Use the Application:**

* You can now register, log in, and start exploring the features of the NavigateNow Website.

## Functionalities

* User Login/Logout and Registration
* Add/Edit/Remove Expences Calculator
* Add/Edit/Remove Checklists
* Add/Edit/Remove Tourist Plans
* User Feedback 
* Create and Edit Profile
* Create/Remove/Edit Groups and Show group trip specifications
* Search for Groups
* Show Touristy Places

## Tests

The following testing have been implemented in the project:

* **Spike Testing**: Evaluating how a system handles sudden, extreme increases in load or traffic.
* **Load Testing**: Assessing a system's performance under expected or peak load conditions.
* **Unit Testing**: Testing individual components or functions of software to ensure they work correctly.
* **Class Validation**: Validating the correctness and integrity of object-oriented programming classes.
* **Stress Testing**: Testing a system's resilience by subjecting it to extreme conditions beyond normal operation to identify its breaking point.


## Additional Notes

* Make sure you have a reliable internet connection while setting up the project, as Maven will download project dependencies.
* Be sure to customize the database configuration, such as the database name, username, and password, according to your specific environment.
Now you have successfully set up the Navigate Now Website on your local machine. Enjoy exploring its features and functionalities! If you encounter any issues during installation, please refer to the project's documentation or seek assistance from the project maintainers.

## Contact

For questions or assistance, contact the NavigateNow Team: navigate.now0@gmail.com





