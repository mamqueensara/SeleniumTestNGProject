#  Selenium Automation Framework (AutomationPractice + DemoWebShop)

##  Overview  

This project is part of my Selenium automation learning journey.  
I automated key e-commerce functionalities using two public test websites:  

- **AutomationPractice**
- **DemoWebShop**

The goal of this project is to build a **real-world Selenium Test Automation framework** using industry-standard practices such as **Page Object Model (POM), TestNG, Maven, WebDriver utilities, Listeners, and Screenshots**.

---

##  Features Automated

###  AutomationPractice
- Register
- Login
- Search

###  DemoWebShop
- Login
- Add to Cart
- Checkout

> This is an ongoing learning project, and I will continue adding more scenarios.

---

##  Framework Design

This project follows a clean Page Object Model (POM) structure with separation of concerns:

✔ Page Object Model  
✔ Page Factory  
✔ Base Test  
✔ Driver Manager  
✔ Config Reader  
✔ Utilities  
✔ TestNG Listeners  
✔ Screenshot on Failure  

---

## Tech Stack  

| Category | Tools |
|---|---|
| Language | Java |
| UI Automation | Selenium WebDriver |
| Test Execution | TestNG |
| Build Tool | Maven |
| Design Pattern | Page Object Model |
| Browser | ChromeDriver |
| Reporting | TestNG Default Reports |
| Utilities | Listeners, Screenshot Utility |

---

##  Project Folder Structure  

```
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
```

---

##  How to Run Tests  

### Option 1 — Run using TestNG XML  
Right-click → **Run testng.xml**

### Option 2 — Run a single test class  
Right-click on class → **Run TestNG**

---

##  Screenshot on Failure  

- Automatically captured for failed tests  
- Stored inside `/screenshots` folder  
- Implemented using TestNG Listener + Utility class  

---

##  Future Enhancements  

- Extent Reports
- Data-driven tests (Excel / JSON)
- Headless execution
- Page load waits
- Jenkins CI integration
- More negative test cases
- Automate additional features

---

## Learning Outcome  

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

---

##  Websites Used  

🔗 AutomationPractice  
http://automationpractice.pl/

🔗 DemoWebShop  
https://demowebshop.tricentis.com/

---

## Author  

**Mamqueen Mamachan**  
Selenium Automation Learner | Manual + Automation Tester  


