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
RESOURCES_RELATIVE_PATH="resources-server"
JAVA_PACKAGE_NAME="server.ws"
PACKAGE_FOREACH_NAMESPACE="http://helloapp=$JAVA_PACKAGE_NAME.helloapp"
##################################################

cd $EXEC_PATH
WSDL_FILE_PATH=`echo $WSDL_FILE_PATH | xargs realpath`
cd $PROJECT_HOME


wsdl2java.sh \
	-ss -sd -ssi \
	-ns2p $PACKAGE_FOREACH_NAMESPACE \
	-p $JAVA_PACKAGE_NAME -S $SRC_RELATIVE_PATH -R $RESOURCES_RELATIVE_PATH -uri $WSDL_FILE_PATH

mv build.xml build-server.xml

cd $EXEC_PATH
