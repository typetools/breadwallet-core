This is a version of breadwallet-core that is annotated with type annotations for the Checker Framework.

PLSE changes from https://github.com/breadwallet/breadwallet-core/:
- made master the default branch
- modified build to remove all references to android version
- modified build to remove all references to native code
- copied all files from Java/CoreNative to appropriate place in Java/corenative
- added new lib directory with annotated version of guava-31.1-jre.jar
- modified build.gradle to run the SignednessChecker
- added @SignedPositive annotations to all declarations of block numbers
- added a github workflow for testing
- added this README file

To build this project
---------------------

```
cd Java
./gradlew assemble
```

There will be pluggable type-checking errors, because only the signatures, not
the bodies, of methods are annotated.

