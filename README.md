
Selenium Automation Framework (AutomationPractice + DemoWebShop)

---- Overview--------

This project is part of my Selenium automation learning journey.
I automated critical e-commerce functionalities from two public test websites:

🔹 AutomationPractice
🔹 DemoWebShop

The goal of this project is to build a real Selenium Test Automation framework using industry-standard practices like Page Object Model, TestNG, and utility classes.

----------Features Automated----------

🔵 AutomationPractice
Register
Login
Search

🔵 DemoWebShop
Login
Add to Cart
Checkout

Note: This is an ongoing learning project, and I plan to continue adding more scenarios.

---------------Framework Design--------------------------------

This project follows a Page Object Model (POM) structure with a clean separation of concerns.

✔ Page Object Model
✔ Page Factory
✔ Base Test
✔ Driver Manager
✔ Config Reader
✔ Utilities
✔ TestNG Listeners
✔ Screenshot on Failure

------ Tech Stack-------
 
Category                              	Tools
----------------------------------------------------
Language	                              Java
UI Automation	                          Selenium WebDriver
Test Execution	                        TestNG
Build Tool	                            Maven
Design Pattern	                        POM
Browser	                                ChromeDriver
Reporting	                              TestNG default reports
Others	                                Listeners, Screenshot utility

--------------- Project Folder Structure--------------------
src
 ├── main
 │    ├── java
 │    │   ├── base
 │    │   ├── pages
 │    │   ├── utilities
 │    │   └── listeners
 │
 └── test
      ├── java
      │    ├── tests
      │
screenshots
pom.xml
testng.xml
README.md

-------------How to Run Tests-------------------
Option 1 — Run from TestNG XML

Right-click → Run testng.xml

Option 2 — Run single test class

Right-click on class → Run TestNG

------------------Screenshot on Failure--------------

Automatically captured for failed tests
Stored in screenshots folder
Implemented using TestNG Listener + Utility class

------------------ Future Enhancements--------------------

Extent Reports
Data-driven tests (Excel / JSON)
Headless execution
Page load waits
Jenkins CI integration
More negative test cases
Automate more pages completely

-------------Learning Outcome------------

Through this project, I gained practical hands-on experience with:

✔ Selenium WebDriver
✔ TestNG
✔ Automation framework designing
✔ POM
✔ Handling web elements
✔ Assertions
✔ Waits
✔ Screenshots
✔ Maven
✔ Listeners
✔ Reporting

-------------------Websites Used------------------

🔗 AutomationPractice
http://automationpractice.pl/

🔗 DemoWebShop
https://demowebshop.tricentis.com/

 Author
Mamqueen Mamachan
Selenium Automation Learner | Manual + Automation Tester
