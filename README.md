# betaexpansion

version 1.2_dev

## about

* todo *

## usage

    The betaexpansion toolchain uses a modified version of MCP for decompiling and recompiling minecraft. The first step to using the toolchain is to copy a beta 1.7.3 `minecraft.jar` and `bin/` directory into `jars/`. Next, run `setup.sh` to decompile the source code. You should now have a copy of the vanilla beta 1.7.3 code in the `src/` directory. 
    
    You should then run `patch.sh` to apply the modified betaexpansion files to the `src/` directory. `path.sh` also creates a duplicate of the vanilla source files in `cleansrc`, and updates MCP's registry of MD5 hashes. These will be used later for recompiling. At this point you should have a fully functional source tree with betaexpansion. You can now edit however you wish, be it with a text editor or an IDE (see the IDE section for more information).

    If you wish to share your work, you need to run `extract.sh`. This does the inverse of `patch.sh`, running the script will copy new and modified files from the `src/` directory to the `betaexpansion/` directory.

    You can create a functional zip archive of the mod using `build.sh`. Running `build.sh` will recompile and reobfuscate the source files using mcp, then package them into a zip archive in `build/`.

    `clean.sh` will clean up all files created by the toolchain and MCP. Make sure that you have run `extract.sh` before cleaning if you don't want t lose your work!

## IDEs

    Once you have decompiled and patched, it should be a trivial process to point your favorite IDE at the `src/` directory and start editing. You will have to add the `jar` files in `jars/bin/` to the classpath, along with the natives for your operating system. You may also need to copy the `assets/` directory into wherever your IDE places compiled files.
