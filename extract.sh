#!/bin/bash
# extract new and modified source files

VERSION="v0.1"

source config.sh

printf "betaexpansion extractor $VERSION\n"
printf "\n"

if [ ! -d "$SOURCE_DIR" ]; then
    printf "source directory ($SOURCE_DIR/) does not exist!\n"
    exit 1
elif [ ! -d "$CLEAN_SOURCE_DIR" ]; then
    printf "clean source directory ($CLEAN_SOURCE_DIR/) does not exist!\n"
    exit 1
elif [ ! -d "$DEST_DIR" ]; then
    printf "destination director ($DEST_DIR/) does not exist!\n"
    exit 1
else
    printf "extracting modified and new source files\n";
    COUNT=0;
    for f in $SOURCE_DIR/**/**/**/**/*; do
        f=${f#$SOURCE_DIR}
        if [ ! -f "$CLEAN_SOURCE_DIR$f" ]; then
            printf "> found new file ${f##*/}\n"
            cp "$SOURCE_DIR$f" "$DEST_DIR"
            ((COUNT++))
        else
            MD5=$(md5sum < "$SOURCE_DIR$f")
            MD5_CLEAN=$(md5sum < "$CLEAN_SOURCE_DIR$f")
            if [[ "$MD5" != "$MD5_CLEAN" ]]; then
                printf "> found modified file ${f##*/}\n"
                cp "$SOURCE_DIR$f" "$DEST_DIR"
                ((COUNT++))
            fi
        fi
    done
    printf "done.\n"
    printf "found $COUNT new or modified files\n"
fi
