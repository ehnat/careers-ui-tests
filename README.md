### Project description
This project contains test which is searching job posts on Akamai website using specified keyword
and location of the office. Test is running in Chrome browser. It could be run on Windows or Mac

### Technical description
- **Used technologies:** Java 8, Maven (preferred v.3.3.9)
- **Used frameworks/libraries:** Selenium Webdriver, TestNG, AssertJ
- **Used patterns:** Page Object Pattern, Page Factory

### Necessary to download/install to run the project
1. install Java 8
2. install Maven
3. install Chrome browser
4. download chromedriver  [here](https://sites.google.com/a/chromium.org/chromedriver/downloads) (preferred v.2.33) and unzip:
 - chromedriver.exe (for Windows)
 - chromedriver (for Mac)

### How to run test
1. clone this repo
2. put downloaded and unziped drivers in the folder **src/test/resources/**
3. enter to the folder **careers-ui-tests** (place where file 'pom.xml' is located)
4. run command from command line:
- for Windows:
  ```sh
    mvn clean test
  ```
    or
   ```sh
   mvn clean test -P win
   ```
- for Mac:
   ```sh
   mvn clean test -P mac
   ```
