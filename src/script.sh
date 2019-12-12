#!/bin/bash
set +e
clear
javac $(find * |grep .java)
play -q DistantMemories.mp3 repeat 3 &
java Main
pkill play
