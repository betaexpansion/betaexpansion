#!/bin/bash
# clean up MCP and betaexpansion files

source config.sh

printf "WARNING -- cleaning will remove any source files that\n"
printf "           have not been saved! Run extract.sh first to save\n"
printf "           your work!\n"

read -p "type \"confirm\" to continue: " INPUT

if [ ! "$INPUT" == "confirm" ]; then
    printf "confirmation failed, aborting.\n";
    exit 1
else
    printf "\n"
    printf "cleaning\n"
    rm -rf "$CLEAN_SOURCE_DIR"
    rm -rf "$SOURCE_DIR"
    rm -rf "$BUILD_DIR"
    rm -rf "$BIN_DIR"
    cd mcp
    echo "Yes" | sh cleanup.sh > /dev/null
fi
