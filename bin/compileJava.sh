#!/bin/sh

EXEC_PATH=`pwd`
cd `dirname $0`/..
PROJECT_HOME=`pwd`

if [ ! -d build ]; then
	mkdir build
fi

echo Compilation is running...

AXIS2_HOME=`whereis axis2.sh | cut -d" " -f2 | xargs dirname | xargs dirname`
AXIS2_CLASSPATH="$AXIS2_HOME/lib/*:$AXIS2_HOME/lib/endorsed/*"

for f in $(find src -name "*.java"); do javac -cp "src:$AXIS2_CLASSPATH" -d build $f; done

echo Compilation finished!

cd $EXEC_PATH
