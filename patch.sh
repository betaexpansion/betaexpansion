#!/bin/bash
# patch betaexpansion source files into the source directory

VERSION="v0.1"

source config.sh

printf "betaexpansion patcher $VERSION\n"
printf "\n"

if [ -d "$SOURCE_DIR" ]; then
    if [ ! -d "$CLEAN_SOURCE_DIR" ]; then
        printf "clean source directory does not exist, creating it\n"
        printf "NOTE -- assuming the source directory contains only\n"
        printf "        vanilla code, if this is not the case problem\n"
        printf "        will arise!\n"
        printf "\n"
        printf "updating md5sums for MCP\n"
        cd "$MCP_DIR"
        cp -r ../"$SOURCE_DIR" ./src
        sh updatemd5.sh
        rm -rf src
        cd ..
        printf "\n"
        cp -r "$SOURCE_DIR" "$CLEAN_SOURCE_DIR"
    fi
    if [ ! -d "$PATCH_DIR" ]; then
        printf "!! betaexpansion source does not exist, aborting!\n"
        printf "   expected betaexpansion source at: $PATCH_DIR/\n"
        exit 1
    fi
    printf "applying betaexpansion source\n"
    cp -r "$PATCH_DIR"/* "$SOURCE_DIR"/minecraft/net/minecraft/src/
    printf "done!\n"
    printf "happy modding :)\n"
else
    printf "source directory does not exist!\n"
    printf "have you decompiled?\n"
fi
