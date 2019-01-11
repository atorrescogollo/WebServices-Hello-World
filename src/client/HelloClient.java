package client;

public class HelloClient {
        public static void main(String[] args) {
                try {
                        client.IHello hello = new HelloWSProxy();
                        System.out.println("> Say Hello");
                        System.out.println(hello.sayHello());
                } catch (RuntimeException e) {
                        System.err.println("[!] Something terrible happened!: "+e.getMessage());
                        //e.printStackTrace();
                }
        }
}
