# Selenium tests for the-internet.herokuapp.com

Maven + Selenium 4 + TestNG project, built with the Page Object pattern.
Target site: http://the-internet.herokuapp.com/

## Structure

```
src/main/java/pages/     Page Objects (one class per page)
src/test/java/tests/     Test classes (one per page) + BaseTest (driver lifecycle)
src/test/resources/      testng.xml suite file
```

Pages / tests implemented:

| Page                  | Page Object                    | Test class                    | Scenario |
|-----------------------|---------------------------------|--------------------------------|----------|
| Form Authentication   | `LoginPage`                     | `FormAuthenticationTest`       | Positive login + 2 negative (bad password / bad username) |
| Dynamic Controls      | `DynamicControlsPage`           | `DynamicControlsTest`          | Remove checkbox, wait until gone, add it back |
| Add/Remove Elements   | `AddRemoveElementsPage`         | `AddRemoveElementsTest`        | Add 2 elements, delete 1, assert count |
| Checkboxes             | `CheckboxesPage`                 | `CheckboxesTest`               | Assert initial state, toggle both checkboxes |
| Dropdown                | `DropdownPage`                   | `DropdownTest`                  | List options, select each, assert selection |
| Inputs                    | `InputsPage`                       | `InputsTest`                       | Numeric entry + ARROW_UP/ARROW_DOWN, reject non-numeric |
| Typos                     | `TyposPage`                        | `TyposTest`                        | Assert paragraph text against known acceptable variants |
| Sortable Data Tables | `SortableDataTablesPage`   | `SortableDataTablesTest`  | Assert several cell values via XPath |
| Hovers                    | `HoversPage`                       | `HoversTest`                       | Actions hover chain per profile, verify name + link not 404 |
| Notification Message | `NotificationMessagePage` | `NotificationMessageTest`  | Click, wait for flash message, assert against known variants |

## Requirements

- JDK 17+
- Maven 3.8+
- Google Chrome installed (driver is managed automatically by WebDriverManager — no manual chromedriver download needed)

## Running the tests

```bash
mvn clean test
```

This runs `src/test/resources/testng.xml` via the Surefire plugin. Results:

- Console output from `mvn test`
- `target/surefire-reports/` — per-class XML/TXT reports
- `target/surefire-reports/emailable-report.html` (if generated) / `index.html`

To run headless (e.g. in CI), uncomment the `--headless=new` line in `BaseTest.setUp()`.

## Design notes

- **Explicit waits**: every Page Object uses a shared `WebDriverWait` (`ExpectedConditions`) instead of `Thread.sleep`.
- **Locators**: prefer `By.id`, stable `By.xpath`/`By.cssSelector` tied to attributes/text rather than
  brittle absolute paths, per the assignment's suggested locators.
- **Driver lifecycle**: `BaseTest` creates the driver in `@BeforeMethod(alwaysRun = true)` and always
  quits it in `@AfterMethod(alwaysRun = true)`, so a failing test never leaks a browser process.
- **Flaky content (Typos / Notification Message)**: these pages intentionally serve varying text, so the
  tests assert membership in a small set of known acceptable strings rather than a single exact value.

## Report checklist (fill in for submission)

- [ ] Title page: discipline, group, full name, date
- [ ] Environment: OS, JDK/Maven/Chrome/chromedriver versions (`java -version`, `mvn -version`, `chrome --version`)
- [ ] List of implemented scenarios (table above can be reused) with brief steps/expected results
- [ ] Link to your feature branch and the Pull Request
- [ ] Screenshots: green `mvn test` run, `target/surefire-reports/`, page/notification states,
      one problem case + fix (if any)
- [ ] Conclusions: stability, risks found (e.g. Typos/Notification Message flakiness), possible
      improvements; branch URL and last commit hash

## Suggested git workflow

Branch naming per the assignment: `feature/<группа>_<фамилия>_selenium`

```bash
git init                      # if the repo doesn't exist yet
git add .
git commit -m "chore: initial Maven + Selenium + TestNG project skeleton"

git checkout -b feature/<группа>_<фамилия>_selenium

# work in small, atomic commits, e.g.:
git commit -m "feat: add Page Objects for Add/Remove Elements, Checkboxes, Dropdown"
git commit -m "test: add tests for Inputs, Typos, Sortable Data Tables"
git commit -m "feat: add Hovers and Notification Message page objects + tests"
git commit -m "fix: stabilize Typos/Notification Message assertions against known variants"

git remote add origin https://github.com/<ваш-аккаунт>/<репозиторий>.git
git push -u origin feature/<группа>_<фамилия>_selenium
# open a Pull Request on GitHub, add your mentor as Reviewer
```

Record the branch URL and the hash of the last commit (`git rev-parse HEAD`) in the report's
Conclusions section, as required.
