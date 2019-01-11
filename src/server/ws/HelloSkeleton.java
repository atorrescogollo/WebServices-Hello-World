/**
 * HelloSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */
package server.ws;


/**
 *  HelloSkeleton java skeleton for the axisService
 */
public class HelloSkeleton implements HelloSkeletonInterface {
    private helloapp.IHello hello;

    public HelloSkeleton() {
        hello = new helloapp.Hello();
    }

    /**
     * Auto generated method signature
     *
     * @param sayHello0
     * @return sayHelloResponse1
     */
    public server.ws.helloapp.SayHelloResponse sayHello(
        server.ws.helloapp.SayHello sayHello0) {
        server.ws.helloapp.SayHelloResponse response = new server.ws.helloapp.SayHelloResponse();
        response.set_return(hello.sayHello());

        return response;
    }
}
