#  APPARATE MyCoolAgent

This package contains additional advanced agents for the [APPARATE Path Planner Simulator](https://bitbucket.org/ssardina-research/apparate-simulator). APPARATE allows to simulate agents moving in real-time in [Moving-AI+](http://movingai.com/benchmarks/) maps. 

This package only contains agents and path-planners that the agents use. It does *not* contain the infrastructure itself.


## Prerequisites

* Java Runtime Environment (JRE) and Java Compiler (javac) v1.6+ (Sun version recommended)
* The [APPARATE Path Planner Simulator](https://bitbucket.org/ssardina-research/apparate-simulator) infrastructure, which includes the JPathPlan class files for the additional path planners.
    * A JAR file for it is provided under `lib`
* `libHRTimer.so` to have access to C access to the clock.
* A configuration file (see below)
* [Moving-AI+](http://movingai.com/benchmarks/) compatible maps.


## Compiling and Running APPARATE 

jar cvf MyCoolAgent.jar bin/*

    

We show here how to compile the framework from CLI (Command Line Interface). 

Compile all agents available in package `agents`:

```
javac -d bin/ -cp src/:lib/apparate-simulator.jar \
	`find src/au/edu/rmit/agtgrp/apparate/agents/ -name *.java | xargs`
```

That should also automatically compile all the path planners used and located in 

To **run** the system from CLI:

```
java -cp bin/:lib/apparate-simulator.jar \
    au.edu.rmit.agtgrp.apparate.gui.simviewer.controller.Launcher <config-file>
```

where:

* `apparate-simulator.jar` is the JAR file for the [APPARATE Path Planner Simulator](https://bitbucket.org/ssardina-research/apparate-simulator) (version 4.0 provided under `lib/`)
* `au.rmit.ai.agtgrp.apparate.gui.simviewer.controller.Launcher` is the main class that starts the application.
* `<config-file>` contains all the options for the simulation (an example `config.properties` is included). See below for details.

You can also use the script `./run.sh <conf-file>`

	
## Agents Provided



## Contributors

* Sebastian Sardina (contact - ssardina@gmail.com)
* Abhijeet Anand
* Miguel Ramirez

## License

This project is using the GPLv3 for open source licensing for information and the license visit GNU website (https://www.gnu.org/licenses/gpl-3.0.en.html).

This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with this program.  If not, see <http://www.gnu.org/licenses/>.
