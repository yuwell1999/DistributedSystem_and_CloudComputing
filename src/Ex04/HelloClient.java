package Ex04;

import java.rmi.Naming;

public class HelloClient {
    public static void main(String[] args) {
        try {
            IHello hi = (IHello) Naming.lookup("rmi:"
                    + Constants.IP_ADDRESS
                    + ":"
                    + Constants.CLIENT_PORT
                    + "/hello");

            HelloTask task = new HelloTaskImpl();

            for (int i = 0; i < 10; i++) {
                System.out.println(hi.say(task));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
