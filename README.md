# Coordinate Reference Systems Java

#### Coordinate Reference Systems Lib ####

The Coordinate Reference Systems Library was developed at the [National Geospatial-Intelligence Agency (NGA)](http://www.nga.mil/) in collaboration with [BIT Systems](https://www.caci.com/bit-systems/). The government has "unlimited rights" and is releasing this software to increase the impact of government investments by providing developers with the opportunity to take things in new directions. The software use, modification, and distribution rights are stipulated within the [MIT license](http://choosealicense.com/licenses/mit/).

### Pull Requests ###
If you'd like to contribute to this project, please make a pull request. We'll review the pull request and discuss the changes. All pull request contributions to this project will be released under the MIT license.

Software source code previously released under an open source license and then modified by NGA staff is considered a "joint work" (see 17 USC § 101); it is partially copyrighted, partially public domain, and as a whole is protected by the copyrights of the non-government authors and must be released according to the terms of the original open source license.

### About ###

[Coordinate Reference Systems](http://ngageoint.github.io/coordinate-reference-systems-java/) is a Java library implementation of OGC's 'Geographic information — Well-known text representation of coordinate reference systems' ([18-010r7](http://docs.opengeospatial.org/is/18-010r7/18-010r7.html)) specification.

### Usage ###

View the latest [Javadoc](http://ngageoint.github.io/coordinate-reference-systems-java/docs/api/)

```java

// String wkt = ...

CRS crs = CRSReader.read(wkt);

CRSType type = crs.getType();
CategoryType category = crs.getCategoryType();

String text = CRSWriter.write(crs);
String prettyText = CRSWriter.writePretty(crs);

switch (category) {

case CRS:

  CoordinateReferenceSystem coordRefSys = (CoordinateReferenceSystem) crs;

  switch (type) {
  case BOUND:
    BoundCoordinateReferenceSystem bound = (BoundCoordinateReferenceSystem) coordRefSys;
    // ...
    break;
  case COMPOUND:
    CompoundCoordinateReferenceSystem compound = (CompoundCoordinateReferenceSystem) coordRefSys;
    // ...
    break;
  case DERIVED:
    DerivedCoordinateReferenceSystem derived = (DerivedCoordinateReferenceSystem) coordRefSys;
    // ...
    break;
  case ENGINEERING:
    EngineeringCoordinateReferenceSystem engineering = (EngineeringCoordinateReferenceSystem) coordRefSys;
    // ...
    break;
  case GEODETIC:
  case GEOGRAPHIC:
    GeoCoordinateReferenceSystem geo = (GeoCoordinateReferenceSystem) coordRefSys;
    // ...
    break;
  case PARAMETRIC:
    ParametricCoordinateReferenceSystem parametric = (ParametricCoordinateReferenceSystem) coordRefSys;
    // ...
    break;
  case PROJECTED:
    ProjectedCoordinateReferenceSystem projected = (ProjectedCoordinateReferenceSystem) coordRefSys;
    // ...
    break;
  case TEMPORAL:
    TemporalCoordinateReferenceSystem temporal = (TemporalCoordinateReferenceSystem) coordRefSys;
    // ...
    break;
  case VERTICAL:
    VerticalCoordinateReferenceSystem vertical = (VerticalCoordinateReferenceSystem) coordRefSys;
    // ...
    break;
  default:
  }

  // ...
  break;

case METADATA:

  CoordinateMetadata metadata = (CoordinateMetadata) crs;

  // ...
  break;

case OPERATION:

  Operation operation = (Operation) crs;

  switch (type) {
  case CONCATENATED_OPERATION:
    ConcatenatedOperation concatenatedOperation = (ConcatenatedOperation) operation;
    // ...
    break;
  case COORDINATE_OPERATION:
    CoordinateOperation coordinateOperation = (CoordinateOperation) operation;
    // ...
    break;
  case POINT_MOTION_OPERATION:
    PointMotionOperation pointMotionOperation = (PointMotionOperation) operation;
    // ...
    break;
  default:
  }

  // ...
  break;

}

```

### Installation ###

Pull from the [Maven Central Repository](http://search.maven.org/#artifactdetails|mil.nga|crs|1.0.0|jar) (JAR, POM, Source, Javadoc)

```xml

<dependency>
    <groupId>mil.nga</groupId>
    <artifactId>crs</artifactId>
    <version>1.0.0</version>
</dependency>

```

### Build ###

[![Build & Test](https://github.com/ngageoint/coordinate-reference-systems-java/workflows/Build%20&%20Test/badge.svg)](https://github.com/ngageoint/coordinate-reference-systems-java/actions/workflows/build-test.yml)

Build this repository using Eclipse and/or Maven:

    mvn clean install
