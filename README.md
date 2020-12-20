
### How to run the UI and RWD Tests

###### UI Tests
```
$ mvn clean test -Dcucumber.options="--tags @Complete" -DexecutionPlatform="AWS_CHROME"
```



###### UI Tests
```
$ mvn clean test -Dcucumber.options="--tags '@UITest and @Smoke'" -DexecutionPlatform="LOCAL_CHROME"
$ mvn clean test -Dcucumber.options="--tags '@UITest and @Regression'" -DexecutionPlatform="LOCAL_CHROME"
$ mvn clean test -Dcucumber.options="--tags @UITest" -DexecutionPlatform="AWS_CHROME"
$ mvn clean test -Dcucumber.options="--tags @UITest" -DexecutionPlatform="AWS_FIREFOX"
$ mvn clean test -Dcucumber.options="--tags @UITest" -DexecutionPlatform="LOCAL_CHROME"
$ mvn clean test -Dcucumber.options="--tags '@UITest and @Smoke'" -DexecutionPlatform="LOCAL_CHROME"
$ mvn clean test -Dcucumber.options="--tags '@UITest and @Search'" -DExecutionPlatform="LOCAL_CHROME"
$ mvn clean test -Dcucumber.options="--tags '@UITest and @Smoke'" -DexecutionPlatform="AWS_DEVICEFARM_CHROME"
$ mvn clean test -Dcucumber.options="--tags '@UITest and @Smoke'" -DexecutionPlatform="AWS_DEVICEFARM_FIREFOX"

```

###### RWD Tests
```
$ mvn clean test -Dcucumber.options="--tags @UIRWDTest" -DexecutionPlatform="AWS_CHROME"
$ mvn clean test -Dcucumber.options="--tags @UIRWDTest" -DexecutionPlatform="AWS_DEVICEFARM_CHROME"

```
