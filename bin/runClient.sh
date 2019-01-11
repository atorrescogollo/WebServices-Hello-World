#!/bin/sh

EXEC_PATH=`pwd`
cd `dirname $0`/..
PROJECT_HOME=`pwd`

AXIS2_HOME=`whereis axis2.sh | cut -d" " -f2 | xargs dirname | xargs dirname`
AXIS2_CLASSPATH="$AXIS2_HOME/lib/*:$AXIS2_HOME/lib/endorsed/*"

java -cp "build:$AXIS2_CLASSPATH" client.HelloClient

cd $EXEC_PATH
