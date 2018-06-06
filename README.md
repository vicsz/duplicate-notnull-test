# Testing duplicate NotNull dependencies via NotBlank Annotation on PCF

# Instructions for deploying to PCF

```sh
./mvnw package
```

```sh
cf push notnull-test -p target/duplicate-notnull-test-0.0.1-SNAPSHOT.jar
```

Test the default root endpoint .. if things are working correctly , the response text should be *Constraint violation detected - may not be empty [ Things seem to be working!!]*





