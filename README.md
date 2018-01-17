#  APPARATE Template Agent MyCoolAgent

This package contains a template to develop agents for the [APPARATE Path Planner Simulator](https://bitbucket.org/ssardina-research/apparate-simulator). APPARATE allows to simulate agents moving in real-time in [Moving-AI+](http://movingai.com/benchmarks/) maps. 

This package only contains a simple DFS version of an agent in `MyCoolAgentDFS.java`. The idea is to develop an agent system and then pack it into a `MyCoolAgent.jar` file.


## Prerequisites

* Java Runtime Environment (JRE) and Java Compiler (javac) v1.6+ (Sun version recommended)
* The [APPARATE Path Planner Simulator](https://bitbucket.org/ssardina-research/apparate-simulator) infrastructure, which includes the JPathPlan class files for the additional path planners.
    * A JAR file for it is provided under `lib`
* `libHRTimer.so` to have access to C access to the clock.
* A configuration file (see below)
* [Moving-AI+](http://movingai.com/benchmarks/) compatible maps.


## Compiling and Running APPARATE 

Since the complete APPARATE systme is provided under `lib/`, the same instructions apply to compile and run this agent template. See instructions in [APPARATE Path Planner Simulator](https://bitbucket.org/ssardina-research/apparate-simulator) repository.

Generally, one will build the agent and pack it into a JAR file:

1. Compile using `./compile.sh`. This will leave all `.class` files in `bin/`.
2. Cd into `bin/`.
3. Build JAR file: `jar cvf MyCoolAgent.jar *`



## Contributors

* Sebastian Sardina (contact - ssardina@gmail.com)

## License

This project is using the GPLv3 for open source licensing for information and the license visit GNU website (https://www.gnu.org/licenses/gpl-3.0.en.html).

This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with this program.  If not, see <http://www.gnu.org/licenses/>.
