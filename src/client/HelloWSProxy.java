package client;

import java.rmi.RemoteException;

import javax.management.RuntimeErrorException;

import org.apache.axis2.AxisFault;

import client.ws.HelloStub;
import client.ws.HelloStub.SayHello;
import client.ws.HelloStub.SayHelloResponse;

public class HelloWSProxy implements client.IHello{
        private HelloStub stub;
        
        public HelloWSProxy() throws RuntimeException{
                try {
                        stub=new HelloStub();
                } catch (AxisFault e) {
                        throw new RuntimeException(e);
                }
        }

        @Override
        public String sayHello() throws RuntimeException{
                try {
                        SayHello sayHello=new SayHello();
                        SayHelloResponse response = stub.sayHello(sayHello);
                        return response.get_return();
                } catch (RemoteException e) {
                        throw new RuntimeException(e);
                }
        }
        
}
