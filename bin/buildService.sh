#!/bin/sh

EXEC_PATH=`pwd`
cd `dirname $0`/..
PROJECT_HOME=`pwd`

AXIS2_HOME=`whereis axis2.sh | cut -d" " -f2 | xargs dirname | xargs dirname`
export AXIS2_HOME

##################################################
BUILDFILE="build-server.xml"
##################################################

echo "Building Service as Ant Archive (.aar)..."

ant -f $BUILDFILE

echo Building process finished!

cd $EXEC_PATH
