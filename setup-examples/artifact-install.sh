#!/usr/bin/env bash

# Location where the Bean Validation TCK dist has been extracted
TCK_DIST=/tmp/BV/beanvalidation-tck-dist-${tck.version}

# Parent pom
mvn org.apache.maven.plugins:maven-install-plugin:3.0.0-M1:install-file \
-Dfile=${TCK_DIST}/src/pom.xml -DgroupId=org.hibernate.beanvalidation.tck \
-DartifactId=beanvalidation-tck-parent -Dversion=${tck.version} -Dpackaging=pom

# Install the tests jar
mvn org.apache.maven.plugins:maven-install-plugin:3.0.0-M1:install-file \
-Dfile=${TCK_DIST}/artifacts/beanvalidation-tck-tests-${tck.version}.jar -DgroupId=org.hibernate.beanvalidation.tck \
-DartifactId=beanvalidation-tck-tests -Dversion=${tck.version} -Dpackaging=jar

# Install the test-suite.xml
mvn org.apache.maven.plugins:maven-install-plugin:3.0.0-M1:install-file \
-Dfile=${TCK_DIST}/artifacts/tck-tests.xml -DgroupId=org.hibernate.beanvalidation.tck \
-DartifactId=beanvalidation-tck-tests -Dversion=${tck.version} -Dpackaging=xml -Dclassifier=suite
