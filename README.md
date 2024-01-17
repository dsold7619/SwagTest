SwagTest
===============================
**Task:** Create framework for UI testing the Sauce Labs demo account at https://www.saucedemo.com/.

**Tools:** Java 19, Selenium 3.x, Junit 5.x

**One thead execution:**
* execute all tests `mvn clean test`
* execute tests with tags `mvn test -Dgroups="Cart, Login"`
* execute tests and get report `mvn surefire-report:report` 
* execute tests with overriding application properties `mvn test "-Dtype.browser=firefox"`

**Tags:**
* "ProductItems"
* "SideBar"
* "ProductItems"
* "Cart"
* "HeaderPanel"
* "Login"


