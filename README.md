# Drone Remote

Team 2 result for Early November 2013 Clojure Dojo at uSwitch.  Simple console based remote control for Parrot AR Drone.

Uses the [clj-drone api wrapper](https://github.com/gigasquid/clj-drone) and [jline](https://github.com/jline/jline2)

Follow setup on clj-drone to get necessary dependencies.

## Usage

From the command line

```bash
lein run
```

#### Control the drone with following keys

* W:forward
* A:left 
* S:right
* Z:down
* T:takeoff  
* Q:land
* [:spin left  
* ]:spin right
* -:down
* =:up

## License

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
