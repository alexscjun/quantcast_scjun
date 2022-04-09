# quantcast_challenge

This Java project uses JUnit and Maven. Python scripts were used to generate test files, which can be found in the notebook folder.

Run the project with:
```
./most_active_cookie [path] [flag] [date]
```

Run JUnit maven tests with:
```
./most_active_cookie_test [path] [flag] [date]
```

Notes:
The test files are in a subfolder, so update path appropriately. 
The build jar has also been conveniently exported to app.jar for convenience. The bash script targets app.jar. Updated build jars can be found in target.
To view test output, open this project in an IDE and run an individual test class as a JUnit test.
