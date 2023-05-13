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
Dockerization => Colima v0.4.6 (For Mac)
```

```zsh
Development IDE => IntelliJ IDEA 2022.2.3 (Ultimate Edition)
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
Webkit (Safari)
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

## Colima Set-up on Mac

Install Colima

```zsh
brew install docker docker-compose colima
```

Command to start Colima

```zsh
colima start --cpu 4 --memory 8
```


## Running the tests

### Pre-requisite

Firstly, make sure that Docker is running locally either via Colima or Docker desktop

Run command =>

```zsh
./gradlew clean test --info
```

## Playwright CodeGen Commands

Command to run Playwright Codegen:

```zsh
npx playwright codegen
```

Command to launch CodeGen with the AUT URL (For example: `https://saucedemo.com`):

```zsh
npx playwright codegen https://saucedemo.com
```

Command to launch CodeGen with desired language, browser (cr, ff, wk) and AUT URL (For example: `https://saucedemo.com`):

```zsh
npx playwright codegen --target java --browser ff https://saucedemo.com
```

Command to emulate devices:

```zsh
npx playwright codegen --device="iPhone 13 Pro"
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

![img_3](https://github.com/krishanuc1001/PlaywrightGradleFW/assets/40739038/33585234-6b69-4894-a595-0be83fffbcfb)

To check the latest version for dependencies, run

```zsh
./gradlew dependencyUpdates --info
```

Path:

```
build/reports/dependencyUpdates/report.html
```

![img_4](https://github.com/krishanuc1001/PlaywrightGradleFW/assets/40739038/34d598d6-332c-4025-8c78-572d5678d346)

## Reporting

After the execution is completed, an `Extent report` is generated that opens automatically in the machines default
browser.

The`Extent report` will also published to the following `GitHub Page`:
```zsh
https://<username>.github.io/PlaywrightGradleFW/extent-report/
```

![img](https://github.com/krishanuc1001/PlaywrightGradleFW/assets/40739038/f62e1388-6c8c-4109-b25e-5e930bd57863)

![img_1](https://github.com/krishanuc1001/PlaywrightGradleFW/assets/40739038/c5ff23d7-cfe9-42a7-8635-eac7a5593562)

![img_2](https://github.com/krishanuc1001/PlaywrightGradleFW/assets/40739038/25dd91b7-53f9-4d9a-b0f4-05d06fbd722b)


## CI-CD

The repository comes with ready-to-use `Jenkins` and `GitHub actions` integration.

Please go through the sample `infra/Jenkinsfile.groovy` and `.github/workflows/web-test.yml` for more details.

![img_5](https://github.com/krishanuc1001/PlaywrightGradleFW/assets/40739038/6c0d1cb4-e743-499f-bdff-57123f9d7958)

![img_6](https://github.com/krishanuc1001/PlaywrightGradleFW/assets/40739038/3dc9a0e5-1f08-49e5-a91f-cce8cd802b73)
