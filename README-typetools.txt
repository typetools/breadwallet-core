This is a version of breadwallet-core that is annotated with type annotations for the Checker Framework.


To build this project
---------------------

```
cd Java
./gradlew assemble
```

There will be pluggable type-checking errors, because only the signatures, not
the bodies, of methods are annotated.

This creates file
???

