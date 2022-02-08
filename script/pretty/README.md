# Pretty

[pretty.zip](https://github.com/ngageoint/coordinate-reference-systems-java/releases/latest/download/pretty.zip)

Parse OGC Coordinate Reference System Well-Known Text (1|2) and pretty print Coordinate Reference System Well-Known Text 2 and PROJ params

## Run

### Script

    ./pretty.sh well-known_text

### Jar

    java -jar pretty.jar well-known_text

### Alias

Add an alias to your shell to run from any location

    alias pretty="~/pretty/pretty.sh"

And run

    pretty well-known_text

## Examples

Run using the script, Jar, or alias.

    pretty 'GEOGCS["WGS 84",DATUM["WGS_1984",SPHEROID["WGS 84",6378137,298.257223563]],PRIMEM["Greenwich",0]]'

    pretty 'PROJCS["WGS 84 / Pseudo-Mercator",\
      GEOGCS["WGS 84",\
          DATUM["WGS_1984",\
              SPHEROID["WGS 84",6378137,298.257223563,\
                  AUTHORITY["EPSG","7030"]],\
              AUTHORITY["EPSG","6326"]],\
          PRIMEM["Greenwich",0,\
              AUTHORITY["EPSG","8901"]],\
          UNIT["degree",0.0174532925199433,\
              AUTHORITY["EPSG","9122"]],\
          AUTHORITY["EPSG","4326"]],\
      PROJECTION["Mercator_1SP"],\
      PARAMETER["central_meridian",0],\
      PARAMETER["scale_factor",1],\
      PARAMETER["false_easting",0],\
      PARAMETER["false_northing",0],\
      UNIT["metre",1,\
          AUTHORITY["EPSG","9001"]],\
      AXIS["X",EAST],\
      AXIS["Y",NORTH],\
      EXTENSION["PROJ4","+proj=merc +a=6378137 +b=6378137 +lat_ts=0.0 +lon_0=0.0 +x_0=0.0 +y_0=0 +k=1.0 +units=m +nadgrids=@null +wktext  +no_defs"],\
      AUTHORITY["EPSG","3857"]]'

## Help

```
USAGE

	well-known_text

DESCRIPTION

	Parse OGC Coordinate Reference System Well-Known Text (1|2) and pretty print Coordinate Reference System Well-Known Text 2 and PROJ params

	well-known_text
		Coordinate Reference System Well-Known Text
			Example: 'GEOGCS["WGS 84",DATUM["WGS_1984",SPHEROID["WGS 84",6378137,298.257223563]],PRIMEM["Greenwich",0]]'
```
