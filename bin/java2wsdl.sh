#!/bin/sh

EXEC_PATH=`pwd`
cd `dirname $0`/..
PROJECT_HOME=`pwd`

if [ $# -ne 2 ]; then
	echo "Usage:   $0 <fully qualified class name> <uri/url>"
	echo "Example: $0 helloapp.Hello http://localhost:8080/axis2/services/Hello"
	exit 1
fi

##################################################
JAVA_CLASSPATH="$PROJECT_HOME/build"
FQ_CLASSNAME="$1"
URI="$2"
OUTPUT_LOCATION="$PROJECT_HOME/wsdl"
OUTPUT_FILENAME="Hello.wsdl"
##################################################

java2wsdl.sh -cp "$JAVA_CLASSPATH" -o $OUTPUT_LOCATION -of $OUTPUT_FILENAME -l "$URI" -cn $FQ_CLASSNAME

cd $EXEC_PATH
