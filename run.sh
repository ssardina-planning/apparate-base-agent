#!/bin/bash

echo "Running path planner on configuration file" "$1"
echo ================================================
cat "$1"
echo `java -version`
echo ================================================

# Include path where libraries to be used are located (e.g., libHRTimer.so native library and apparate simulator framework)
export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:lib/

java -Djava.library.path=lib/ -cp bin:/../out/production/apparate-agents-extras.git/:lib/apparate-simulator.jar:lib/MyCoolAgent.jar au.edu.rmit.agtgrp.apparate.gui.simviewer.controller.Launcher "$1"
