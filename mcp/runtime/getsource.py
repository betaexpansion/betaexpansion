# -*- coding: utf-8 -*-
import sys, time
from optparse import OptionParser
from commands import Commands

def main(conffile=None):
    commands = Commands(conffile)

    commands.logger.info ('== Extracting client source files ==')
    if commands.checkbins(0):
        commands.logger.info ('> Gathering md5 checksums')
        commands.gathermd5ssource(0,True)
        commands.logger.info ('> Extracting modified source files')
        commands.unpackreobfsource(0)

if __name__ == '__main__':
    parser = OptionParser(version='MCP %s' % Commands.MCPVersion)
    parser.add_option('-c', '--config', dest='config', help='additional configuration file')
    (options, args) = parser.parse_args()
    main(options.config)
