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

## Steps to Format Code (One-time set up)

### Step 1

- Install [pre-commit](https://pre-commit.com/) which is a package manager for installing pre-commit hooks.

> NOTE: This particular step is already done and is only here for your information. No action is required from new users,
since Hook file is already copied in the project. Adding this step here since it is good to know how this was done and so that if needed in future one can add (new) hooks here.

- Search for the pre commit hook you are interested in from the list of [available hooks](https://pre-commit.com/hooks.html).
- If you search with word "java" in the search window of above webpage, you will find (at least) 3 different pre commit hooks.
- All of these hooks use [Google Java Format program](https://github.com/google/google-java-format) that reformats Java source code to comply with [Google's Java codestyle](https://google.github.io/styleguide/javaguide.html).
- The hook we have chosen for our project is named `pretty-format-java` from user [macisamuele - on Github](https://github.com/macisamuele/language-formatters-pre-commit-hooks).
- Click on the above GitHub URL to go to see how to use this hook. You will see an example as below

```
- repo: https://github.com/macisamuele/language-formatters-pre-commit-hooks
  rev: d2425a62376c2197448cce2f825d5a0c3926b862
  hooks:
  - id: pretty-format-java
    args: [ --autofix ]
```

- Add a file in root of this repository named `.pre-commit-config.yaml` and paste above content in it (already done, added fyi only).
- Update the latest `rev` (commit `sha`) version (already done, added fyi only. Have a check for the latest commit `sha` from the above git repo).
- Add any other hooks you are interested in here (as you will see in file `.pre-commit-config.yaml`).

#### Step 2

- Each user need to run below step (Only one time ever for a project repo):
    - To install the git hook script on your local git repository:
        - run `pre-commit install` from the root of this repository.
        - Should give result as below if successful.

            ```bash
            $ pre-commit install
            pre-commit installed at .git/hooks/pre-commit
           ```

#### Step 3

- That's it we are set now!
- Pre-commit will now run on every commit that we make and our code will be auto-magically formatted as per [Google's Java codestyle](https://google.github.io/styleguide/javaguide.html)
- If there are any formatting violations, not only it will tell you what the failures are, but it will also fix it for us automatically before commit (of course we would need to add those changes to stage and commit again)

```
20:52:05.449: [PlaywrightPoCGradle] git -c credential.helper= -c core.quotepath=false -c log.showSignature=false reset -- .github/workflows/format-java-code.yaml
20:52:05.474: [PlaywrightPoCGradle] git -c credential.helper= -c core.quotepath=false -c log.showSignature=false add --ignore-errors -A -f -- src/main/java/com/tbd/BadCode.java
20:52:05.503: [PlaywrightPoCGradle] git -c credential.helper= -c core.quotepath=false -c log.showSignature=false commit -F /private/var/folders/vb/1zlkz6115mgfttm2tfl1l59w0000gp/T/git-commit-msg-1.txt --
[WARNING] Unstaged files detected.
[INFO] Stashing unstaged files to /Users/krish.chakraborty/.cache/pre-commit/patch1687101726-24189.
check yaml...........................................(no files to check)Skipped
check json...........................................(no files to check)Skipped
check xml............................................(no files to check)Skipped
pretty format json...................................(no files to check)Skipped
fix end of files.........................................................Passed
trim trailing whitespace.................................................Passed
mixed line ending........................................................Passed
Google Java Formatter....................................................Failed
- hook id: pretty-format-java
- exit code: 1
- files were modified by this hook
[cwd=/Users/krish.chakraborty/IdeaProjects/PlaywrightPoCGradle] Run command: ('java', '-version')
[return_code=0] |
	stderr: openjdk version "17.0.2" 2022-01-18
OpenJDK Runtime Environment (build 17.0.2+8-86)
OpenJDK 64-Bit Server VM (build 17.0.2+8-86, mixed mode, sharing)
[cwd=/Users/krish.chakraborty/IdeaProjects/PlaywrightPoCGradle] Run command: ('java', '--add-exports', 'jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED', '--add-exports', 'jdk.compiler/com.sun.tools.javac.file=ALL-UNNAMED', '--add-exports', 'jdk.compiler/com.sun.tools.javac.parser=ALL-UNNAMED', '--add-exports', 'jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED', '--add-exports', 'jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED', '-jar', '/Users/krish.chakraborty/.cache/pre-commit/google-java-formatter1.17.0.jar', '--set-exit-if-changed', '--replace', 'src/main/java/com/tbd/BadCode.java')
[return_code=1] |
	stderr:
[INFO] Restored changes from /Users/krish.chakraborty/.cache/pre-commit/patch1687101726-24189.
20:52:07.592: [PlaywrightPoCGradle] git -c credential.helper= -c core.quotepath=false -c log.showSignature=false add --ignore-errors -A -f -- .github/workflows/format-java-code.yaml
```

#### Step 4 [One-time action to be conducted for the whole project]

When  pre-commit is first introduced in a project it is advised to format all the files at least
one time to avoid seeing formatting changes going forward. The way we can do this is by running
the below command in a powershell or a git terminal

> Note: It would not work from intellij or normal terminals.

`java -jar "/Users/krish.chakraborty/.cache/pre-commit/google-java-formatter1.17.0.jar" --replace "$(git ls-files *.java)"`

> Please replace the "krish.chakraborty" user with your user directory where this jar file was downloaded.
> Once formatted, push all the changes in a PR, and we can be assured that we do not have to see any formatting related
> issues anymore in our project PRs.


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
