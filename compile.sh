#!/bin/bash

rm -rf bin/*
javac -d bin/ -cp src/:lib/apparate-simulator.jar \
	`find src/ -name *.java | xargs`


