#!/bin/bash
# set up MCP

source config.sh

cd "$MCP_DIR"
sh decompile.sh
mv src ../"$SOURCE_DIR" 
printf "\n"
printf "MCP setup complete, ready to patch.\n"
