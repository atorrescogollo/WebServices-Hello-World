#!/bin/sh

EXEC_PATH=`pwd`
cd `dirname $0`/..
PROJECT_HOME=`pwd`

if [ $# -ne 1 ]; then
	echo "Usage:   $0 <WSDL filepath>"
	echo "Example: $0 $PROJECT_HOME/wsdl/Hello.wsdl"
	exit 1
fi

##################################################
# Inputs
WSDL_FILE_PATH="$1"

# Outputs
SRC_RELATIVE_PATH="src"
JAVA_PACKAGE_NAME="client.ws"
##################################################

cd $EXEC_PATH
WSDL_FILE_PATH=`echo $WSDL_FILE_PATH | xargs realpath`
cd $PROJECT_HOME

wsdl2java.sh \
	-p $JAVA_PACKAGE_NAME -S $SRC_RELATIVE_PATH -uri $WSDL_FILE_PATH

[ $? -ne 0 ] && exit 1
mv build.xml build-client.xml

cd $EXEC_PATH
