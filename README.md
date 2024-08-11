# Amazon Book Search Test

**Author:** Artem Tykhonenko  
**Version:** 3   
**Software:** TestNG, Selenium

## Description

This project is a test automation suite for searching books on Amazon. It utilizes TestNG for test orchestration and Selenium for web automation.

## Project Structure

- `WebDriver`: Contains configurations for Chrome and Gecko drivers.
- `PageFactory`: Includes page element definitions using PageFactory.
- `Helpers`: Contains logic for bookEntity search, collection creation, and bestseller label verification.
- `BookColection`: Collection with books elements like "name", "author", and "price".
- `WaitHelper`: A class for handling waits, useful for waiting for all books to load.
- `BaseTest`: Common methods and class declarations.
- `AmazonBookTest`: The main test class to run the test.
- `AmazonBookTestDataProvider`: contains books name for searching

## How to Use

1. Clone the repository:

   ```bash
   git clone https://bitbucket.org/artem-education/tykhonenko-amazon-book-test.git
   
2. Open the project in your preferred IDE.
3. Wait for all dependencies to be loaded.
4. Run the main test class AmazonBookTest.

## Test Execution
The test results will be displayed in the console. The information extracted includes the bookEntity's name, author, prices, and whether it is labeled as a bestseller.
## Notes
- This project has been tested only with Chrome WebDriver
- IF test failed thats mean book has been changed information or xpath changed. Please confirm that book info in dataprovider entered according to book on Amazon website.