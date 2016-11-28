[![MANGO STORE](screenshot/logo.png)]

"**MANGO STORE**" is the internet shop gadgets and accessories. Here You can buy smartphone, PC, table PC, TV and accessories.

**Used Technologies**: Java SE/EE, Maven, Servlets, Spring Framework (IoC, MVC, Data, Security), JPA / Hibernate, MySQL, JSP / JSTL, Bootstrap, CSS, JS, Junit, Mockito, Jacoco.

Store work can be divided into 4 parts: _for customers_, _for administrator_,  _for managers_, and _for couriers_.

<h4>For Customers</h4>
Customers can only navigate on the unsecured sections of the site, view products, add and delete items from shopping cart, and make orders.

![MANGO STORE](screenshot/main.png)  ![MANGO STORE](screenshot/product.png)

<h4>For Administrator</h4>
Administrator can navigate on all the pages of the site and pages intended for the administrator ([.../admin]).
Administrator can add, edit, and delete information about the products, managers and couriers. All information is stored in the database.

![MANGO STORE](screenshot/admin_products.png) ![MANGO STORE](screenshot/admin_employee.png)

<h4>For Managers</h4>
Managers can navigate on the main pages of the site and the pages intended for managers ([.../managers]).
Managers have the access to edit information about the orders and customers. They can change the order status, and see couriers responsible for every order that is in the delivery phase or already closed.

![MANGO STORE](screenshot/manager_orders.png)  ![MANGO STORE](screenshot/manager_order_view.png)

<h4>For Couriers</h4>
Couriers can navigate on the main pages of the site and the pages intended for couriers ([.../courier]).
Couriers can view all orders with status "in Work", take the desired order and then after delivery order change the status to "Closed"

![MANGO STORE](screenshot/courier_orders.png)]  [![MANGO STORE](screenshot/courier_order_view.png)

To access the pages of administrators, managers and couriers need to be authorized (.../login). Without the authorization of access is denied.

![MANGO STORE](screenshot/login.png) ![MANGO STORE](screenshot/login_access_denied.png)

[_**Diukarev Sergii**_](https://www.linkedin.com/in/diukarevsergii)
