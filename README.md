# Backend (Spring Boot API) - Restaurant Management System
This repository contains the backend API for the Restaurant Management System, developed with Spring Boot. It handles all the core functionalities of the system, including managing restaurant data, orders, promotions, and user accounts. The API serves both the mobile app (for clients and servers) and the web app (for restaurant owners).

## Front Links : 
  #### Front Website (for Owners) : [Restaurant Frontend Web](https://github.com/AkramLok/restaurant-frontend-web-pfa)
  #### Mobile application (for Clients) : [Restaurant Mobile APP](https://github.com/AkramLok/restaurant-mobile-pfa) - [Restaurant Mobile APP2](https://github.com/oussama-krittel/pfa-client-mobile-app )
  #### Mobile application for login test only (waiter login need some id): [Restaurant Moble Test APP](https://github.com/AkramLok/resstaurant-mobile-test-pfa)

## Key Features
- User Management: Manage user accounts for admins, servers, and clients.
- Order Management: Handle order creation, updates, and tracking for customers.
- Loyalty System: Implement a points-based loyalty system where customers can earn and redeem rewards.
- Promotions & Offers: Allow admins to create and manage special promotions for loyal customers.
- Menu Management: Add, update, and delete menu items.
- Security: Role-based access control (RBAC) using Spring Security to secure endpoints for different actors (Admin, Server, Client).
## Technologies Used
- Spring Boot: For building a RESTful API.
- MySQL: For the database (configurable based on setup).
- Spring Security: For authentication and authorization.
- JPA/Hibernate: For database interactions and object-relational mapping.
## Installation & Setup
1. Clone this repository:
```
git clone https://github.com/AkramLok/restaurant-backend-pfa.git
```
2. Navigate to the project directory:
```
cd restaurant-backend-pfa
```
3. Configure your database in the src/main/resources/application.properties file:
```
//properties
spring.datasource.url=jdbc:mysql://localhost:3306/pfa
spring.datasource.username=your_username
spring.datasource.password=your_password
```
4. Build and run the application:
```
mvn spring-boot:run
```
5. The API will be available at:
```
http://localhost:8080/
```
## API Endpoints
1. User Management:
```
POST /api/users: Create a new user.
GET /api/users: Get a list of users.
```
2. Order Management:
```
POST /api/orders: Create a new order.
GET /api/orders: Get all orders.
```
3. Menu Management:
```
POST /api/menu: Add a new menu item.
GET /api/menu: Get all menu items.
PUT /api/menu/{id}: Update a menu item.
DELETE /api/menu/{id}: Delete a menu item.
```
4. Offers:
```
POST /api/offers: Create a new promotion.
GET /api/offers: Get all promotions.
```
## Security
This API uses JWT tokens for authentication. Use the /auth/login endpoint to receive a token, and include it in the Authorization header for protected routes:
```
Authorization: Bearer <token>
```
## License
This project is licensed under the MIT License.
