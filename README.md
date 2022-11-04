## Playwright Test Automation Framework

### Tech stack used for this project:

```zsh
Programming language => Java 11
```

```zsh
UI Automation library => Playwright-Java 1.26.0
```

```zsh
Testing library => TestNG 7.4.0
```


```zsh
Build tool => Gradle 7.3
```

```zsh
Development IDE => IntelliJ Ultimate 2021.2.3
```

### Browsers supported:

```zsh
Chrome
```

```zsh
Chromium
```

```zsh
Microsoft Edge
```

```zsh
Firefox
```

```zsh
Safari
```

## Cloning & Importing the Project

1. Clone the project from

```zsh
git clone https://github.com/krishanuc1001/PlaywrightGradleFW.git
```

2. Import the project (ecommerce-ui-automation) in IntelliJ

```zsh
File -> Open... -> Browse to the cloned Project repo -> Import the project by selecting build.gradle file
```

## Running the tests

Run command =>

```zsh
./gradlew clean test --info
```

## Check Dependencies

To check the owasp dependency report, run

```zsh
./gradlew dependencyCheckAnalyze --stacktrace
```

Path:

```
build/reports/dependency-check-report.html
```

To check the latest version for dependencies, run

```zsh
./gradlew dependencyUpdates --info
```

Path:

```
build/reports/dependencyUpdates/report.html
```

## Output

After the execution is completed, an `Extent report` is generated that opens automatically in the machines default
browser.