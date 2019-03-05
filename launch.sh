#!/bin/sh
export CLASSPATH="dist/*:dist/lib/*"

java -Xmx1024M -Dorg.whitestar.gateway_ip="127.0.0.1" -Dfile.encoding="UTF-8" -Dwhitestar.servertype="old" -server server.Start
