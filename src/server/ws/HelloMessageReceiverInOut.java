/**
 * HelloMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */
package server.ws;


/**
 *  HelloMessageReceiverInOut message receiver
 */
public class HelloMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver {
    public void invokeBusinessLogic(
        org.apache.axis2.context.MessageContext msgContext,
        org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault {
        try {
            // get the implementation class for the Web Service
            Object obj = getTheImplementationObject(msgContext);

            HelloSkeletonInterface skel = (HelloSkeletonInterface) obj;

            //Out Envelop
            org.apache.axiom.soap.SOAPEnvelope envelope = null;

            //Find the axisOperation that has been set by the Dispatch phase.
            org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext()
                                                                      .getAxisOperation();

            if (op == null) {
                throw new org.apache.axis2.AxisFault(
                    "Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
            }

            java.lang.String methodName;

            if ((op.getName() != null) &&
                    ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(
                            op.getName().getLocalPart())) != null)) {
                if ("sayHello".equals(methodName)) {
                    server.ws.helloapp.SayHelloResponse sayHelloResponse7 = null;
                    server.ws.helloapp.SayHello wrappedParam = (server.ws.helloapp.SayHello) fromOM(msgContext.getEnvelope()
                                                                                                              .getBody()
                                                                                                              .getFirstElement(),
                            server.ws.helloapp.SayHello.class);

                    sayHelloResponse7 = skel.sayHello(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            sayHelloResponse7, false,
                            new javax.xml.namespace.QName("http://helloapp",
                                "sayHelloResponse"));
                } else {
                    throw new java.lang.RuntimeException("method not found");
                }

                newMsgContext.setEnvelope(envelope);
            }
        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    //
    private org.apache.axiom.om.OMElement toOM(
        server.ws.helloapp.SayHello param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(server.ws.helloapp.SayHello.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        server.ws.helloapp.SayHelloResponse param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(server.ws.helloapp.SayHelloResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        server.ws.helloapp.SayHelloResponse param, boolean optimizeContent,
        javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    server.ws.helloapp.SayHelloResponse.MY_QNAME, factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private server.ws.helloapp.SayHelloResponse wrapsayHello() {
        server.ws.helloapp.SayHelloResponse wrappedElement = new server.ws.helloapp.SayHelloResponse();

        return wrappedElement;
    }

    /**
     *  get the default envelope
     */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory) {
        return factory.getDefaultEnvelope();
    }

    private java.lang.Object fromOM(org.apache.axiom.om.OMElement param,
        java.lang.Class type) throws org.apache.axis2.AxisFault {
        try {
            if (server.ws.helloapp.SayHello.class.equals(type)) {
                return server.ws.helloapp.SayHello.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (server.ws.helloapp.SayHelloResponse.class.equals(type)) {
                return server.ws.helloapp.SayHelloResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }
        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

        return null;
    }

    private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();

        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }
} //end of class
