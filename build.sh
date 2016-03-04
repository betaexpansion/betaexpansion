#!/bin/bash
# recompile and reobfuscate source files,
# then bundle them into a zip archive

VERSION="v0.1"

source config.sh

printf "betaexpansion build script $VERSION\n"
printf "\n"

cp -r "$SOURCE_DIR" "$MCP_DIR"/"$SOURCE_DIR"
cd "$MCP_DIR"
sh recompile.sh > /dev/null
printf "reobfuscating\n"
sh reobfuscate.sh > /dev/null 2>&1
cd ..

printf "packing archive\n"
rm -rf "$BUILD_DIR"
mkdir -p "$BUILD_DIR"
cp reobf/minecraft/* "$BUILD_DIR"
cp -r "$ASSET_DIR"/* "$BUILD_DIR"

read -p "enter version string > " VERSION_STR
ARCHIVE_NAME="$ARCHIVE_NAME""$VERSION_STR".zip

cd "$BUILD_DIR"
zip -r "$ARCHIVE_NAME" * > /dev/null
rm *.class

printf "done.\n"
