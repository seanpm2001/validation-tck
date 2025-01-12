!# Jakarta Validation TCK
*Version: 2.0.5 - 05-08-2019*

This repository contains the Jakarta Validation 3.0
[TCK](http://en.wikipedia.org/wiki/Technology_Compatibility_Kit).

## Build from Source

You can build the TCK from source by cloning the git repository https://github.com/jakartaee/validation-tck
You will also need a [JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html) 8 and
[Maven](http://maven.apache.org/) 3. With these prerequisites in place you can compile the source via:

    mvn clean install

After successful execution you can find the full distribution bundles in _distribution/target_. To inspect the different test artifacts
and the TCK coverage report refer to _tests/target/artifacts_ and _tests/target/coverage-report_ respectively.

# Documentation

The documentation for the TCK is included in the docs directory of the [distribution package](https://beanvalidation.org/2.0/tck/)
or viewable [online](http://docs.jboss.org/hibernate/stable/beanvalidation/tck/reference/html_single/).

If you are looking at a quick start for testing your Jakarta Validation provider implementation against this TCK have a look at
the _[setup-examples](https://github.com/jakartaee/validation-tck/tree/master/setup-examples)_ directory.
It contains a setup example for [Ant](https://github.com/jakartaee/validation-tck/blob/master/setup-examples/ant/readme.md)
and [Maven](https://github.com/jakartaee/validation-tck/blob/master/setup-examples/maven/readme.md).

# Release Notes

The release notes for this release can be found [here](https://github.com/jakartaee/validation-tck/blob/master/changelog.txt).

# Issue tracking

The Jakarta Validation TCK issue tracker is [hosted on GitHub](https://github.com/jakartaee/validation-tck/issues).
