#!/bin/bash
# build and run minecraft

VERSION="0.1"

source config.sh

build()
{
    printf "building\n"
    rm -rf "$BIN_DIR"
    mkdir -p "$BIN_DIR"
    javac -d "$BIN_DIR" -cp .:"$LIB_DIR"/* src/**/**/**/**/*.java
}

launch()
{
    printf "launching\n"
    export vblank_mode=0
    cp -r "$ASSET_DIR"/* "$BIN_DIR" 
    java -Xmx512M -cp "$BIN_DIR":"$LIB_DIR"/* -Djava.library.path="$NATIVE_DIR" "$MAIN"
}

if [[ -z "$1" ]]; then
   build
   launch
elif [[ "$1" = "run" ]]; then
    launch
elif [[ "$1" = "launch" ]]; then
    launch
elif [[ "$1" = "make" ]]; then
    build
elif [[ "$1" = "build" ]]; then
    build
else
    printf "unknown argument $1!\n"
    printf "usage: run.sh [make|build/run|launch]\n"
fi
