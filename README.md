**Sports Performance Monitoring and Event Management Platform**

This project is designed to streamline sports management by integrating performance monitoring, user role management, and event organization into a unified platform. It provides functionalities tailored for athletes, coaches, and administrators, enabling them to manage their respective responsibilities efficiently.

**Project Overview**

**Purpose**

The platform is built to cater to the unique needs of sports teams and organizations, providing tools to:

1. **Monitor Athlete Performance:** Track key metrics like height, weight, category, and coach assignments.
2. **Event Management:** Organize, schedule, and oversee sports events and training sessions.
3. **User Management:** Role-based access for athletes, coaches, and administrators to ensure secure and seamless operations.

**Technologies Used**

**Backend**

- **Spring Boot Framework:** Simplifies application development with built-in configurations.
- **MySQL Database:** Efficiently stores user and performance data.
- **Spring Security & JWT:** Ensures secure authentication and authorization.

**Frontend**

- **HTML, CSS, and JavaScript:** Creates a responsive and user-friendly interface.
- **Bootstrap**: Utilizes its grid system and ready-made components for faster development and responsive layouts.

**Testing Tools**

- **Postman:** Used for API testing and ensuring endpoints work as expected.

**Features**

1. **Role-Based Access Control:**
    - **Athletes:** View and update performance metrics.
    - **Coaches:** Manage athlete data and schedules.
    - **Administrators:** Oversee user roles and organize events.
2. **Database Automation:**
    - The database is auto-configured when the application runs, eliminating manual setup.
3. **User Authentication:**
    - Login and registration endpoints validate users and assign roles securely.
4. **Frontend Navigation:**
    - A browser-based interface for ease of use.
5. **Event Scheduling:**
    - Administrators can create, modify, and delete sports events.

**Restricting Admin Registration**

To ensure that only one admin account exists, follow these steps:

1. After registering an admin through the application, open the register.html file located in the frontend directory.
2. Locate the dropdown section in the HTML code where user roles are listed.
3. Comment out the option for "Admin" by modifying the dropdown code as shown below:

&lt;select id="role" name="role"&gt;

&lt;option value="ATHLETE"&gt;Athlete&lt;/option&gt;

&lt;option value="COACH"&gt;Coach&lt;/option&gt;

&lt;!-- <option value="ADMIN"&gt;Admin&lt;/option&gt; -->

&lt;/select&gt;

1. Save the changes. This will prevent any additional users from registering as an admin

**Usage Scenarios**

1. **For Athletes:**
    - Log in to view your personal profile.
    - Check metrics like training progress, assigned coach, and event participation.
2. **For Coaches:**
    - Manage athlete training schedules and performance data.
    - Organize team practice sessions.
3. **For Administrators:**
    - Monitor system-wide performance.
    - Manage user accounts, including coaches and athletes.
    - Oversee the creation and execution of sports events.

**Getting Started**

Follow the steps below to download, set up, and run the project for the first time. This guide includes frontend and backend setup along with API testing instructions.

**Prerequisites**

Ensure the following tools are installed on your system:

1. **Git:**
    - Git is required to clone the project repository.
    - Download Git from [Git Official Site](https://git-scm.com/).
2. **Java Development Kit (JDK):**
    - Required to run the backend code.
    - Version: 8 or above.
    - Download JDK from [Oracle JDK Downloads](https://www.oracle.com/java/technologies/javase-downloads.html).
3. **IntelliJ IDEA:**
    - Used to manage and run the project.
    - Download IntelliJ IDEA from [JetBrains IntelliJ IDEA Download](https://www.jetbrains.com/idea/download/).
4. **MySQL Community Server and MySQL Workbench:**
    - Required to manage the database.
    - Version: 8.0 or above.
    - Download MySQL from [MySQL Downloads](https://dev.mysql.com/downloads/).
5. **Node.js:**
    - Required for frontend functionality.
    - Version: 14 or above.
    - Download Node.js from [Node.js Official Site](https://nodejs.org/).
6. **Postman:**
    - Used to test backend APIs.
    - Download Postman from [Postman Downloads](https://www.postman.com/downloads/).

**Step-by-Step Setup**

**Step 1: Clone the Project Repository Using IntelliJ IDEA**

1. Open IntelliJ IDEA.
2. From the **Welcome Screen**, select **Get from VCS**.
3. In the dialog box:
    - Paste the Git repository URL into the URL field:  
        &lt;repository-url&gt;
    - Choose the directory where the project will be cloned.
4. Click **Clone**.
5. IntelliJ IDEA will download the repository and open the project automatically.
6. **Important**: After the project is opened, click **Load Maven** to ensure all dependencies are properly downloaded.
7. Exclude the folder from **Microsoft Defender** (located at the bottom right) to avoid any interference with the project files.

**Step 2: Configure the Backend**

1. Navigate to the application.properties file in the backend directory.
2. Verify the database configuration:
3. spring.datasource.url=jdbc:mysql://localhost:3306/auth
4. spring.datasource.username=&lt;your-username&gt;
5. spring.datasource.password=&lt;your-password&gt;
6. spring.jpa.hibernate.ddl-auto=update

Replace &lt;your-username&gt; and &lt;your-password&gt; with your MySQL credentials.

1. Ensure all required dependencies, like Spring Web, Spring Security, Spring Data JPA, and MySQL Driver, are present in the pom.xml.

**Step 3: Run the Backend Server**

1. In IntelliJ IDEA, click on the **Run** button or press **Shift + F10**.
2. The server will start running on <http://localhost:8083>.
3. Check the console logs in IntelliJ IDEA to ensure the **auth** database is automatically created and all tables are initialized.

- Open MySQL Workbench and connect to your database.
- Execute the following SQL query to insert the roles into the roles table:

INSERT INTO roles (id, name) VALUES

(1, 'ADMIN'),

(2, 'COACH'),

(3, 'ATHLETE');

1. Click **Apply** and then **Finish** to save the changes.

**Step 4: View the Frontend Pages**

1. Open the frontend directory in IntelliJ IDEA.
2. Locate the welcome.html or the starting file of the frontend.
3. Right-click on the file and select **Open in Browser**.
4. Choose your preferred browser (e.g., Chrome, Edge, or Firefox).
5. Explore the frontend interface and features.

**Step 5: Test the API Endpoints Using Postman**

**Login API**

- **Request Type:** POST
- **Endpoint URL:** <http://localhost:8083/api/auth/login>
- **Body:** select JSON

{

"email": "testemail",

"password": "testpassword"

}

- **Response:** A success message and a JWT token.

**Registration API**

- **Request Type:** POST
- **Endpoint URL:** <http://localhost:8083/api/auth/register>
- **Body:** select JSON

{

"name": "your name",

"email": "user email",

"password": "newpassword",

"role": "select role"

}

- **Response:** A success message confirming user registration.

**Note:** Use the token from the Login API for authenticated requests by including it in the Authorization header:

Authorization: Bearer &lt;JWT_TOKEN&gt;

**Navigating the Project**

- **Backend Directory:** Contains Spring Boot application files.
- **Frontend Directory:** Contains the React files.
- **SQL Scripts Directory:** Contains additional scripts for database management.
- **Postman Collection Directory:** Includes pre-configured API requests for testing.

**Troubleshooting Common Issues**

1. **Backend Server Fails to Start**
    - Verify database credentials in application.properties.
    - Ensure MySQL Server is running.
2. **Frontend Pages Not Loading**
    - Verify Node.js installation.
    - Ensure the backend server is running.
3. **API Calls Failing in Postman**
    - Check if the backend server is running at <http://localhost:8083>.
    - Verify that the JWT token is included in the Authorization header for protected endpoints.

**Contributing**

1. Fork the repository.
2. Create a new branch:
3. git checkout -b feature/&lt;feature-name&gt;
4. Commit and push your changes.
5. Submit a pull request for review.
