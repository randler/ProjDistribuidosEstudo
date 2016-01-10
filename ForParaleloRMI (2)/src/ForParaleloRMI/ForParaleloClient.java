package ForParaleloRMI;

import java.lang.Thread.State;
import java.net.MalformedURLException;
import java.rmi.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ForParaleloClient {

    static double v1, v2, v3, v4, pi;

    public static double getV1() {
        return v1;
    }

    public static void setV1(double v1) {
        ForParaleloClient.v1 = v1;
    }

    public static double getV2() {
        return v2;
    }

    public static void setV2(double v2) {
        ForParaleloClient.v2 = v2;
    }

    public static double getV3() {
        return v3;
    }

    public static void setV3(double v3) {
        ForParaleloClient.v3 = v3;
    }

    public static double getV4() {
        return v4;
    }

    public static void setV4(double v4) {
        ForParaleloClient.v4 = v4;
    }

// saida tem que ser proximo de -> 3,14159 26535 89793 23846 26433 83279 50288 41971 69399 37510 58209 74944 59230 78164 06286 20899 86280 34825 34211 70679 82148 08651 32823 06647 09384 46095 50582 23172 53594 08128 48111 74502 84102 70193 85211 05559 64462 29489 54930 38196 44288 10975 66593 34461 28475 64823 37867 83165 27120 19091 45648 56692 34603 48610 45432 66482 13393 60726 02491 41273

    public static void main(String args[]) {
        try {
            final ForParaleloRemote forParalelo1 = (ForParaleloRemote) Naming.lookup("//localhost/ForParalelo");
            final ForParaleloRemote forParalelo2 = (ForParaleloRemote) Naming.lookup("//localhost/ForParalelo");
            final ForParaleloRemote forParalelo3 = (ForParaleloRemote) Naming.lookup("//localhost/ForParalelo");
            final ForParaleloRemote forParalelo4 = (ForParaleloRemote) Naming.lookup("//localhost/ForParalelo");
            Thread t1, t2, t3, t4;
            
            t1 = new Thread() {
                @Override
                public void run() {
                    try {
                        setV1(forParalelo1.op1(0));
                    } catch (RemoteException ex) {
                        Logger.getLogger(ForParaleloClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
            t1.start();
            
            
            t2 = new Thread() {
                @Override
                public void run() {
                    try {
                        setV2(forParalelo2.op1(125000));
                    } catch (RemoteException ex) {
                        Logger.getLogger(ForParaleloClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
            t2.start();
            t3 = new Thread() {
                @Override
                public void run() {
                    try {
                        setV3(forParalelo3.op1(250000));
                    } catch (RemoteException ex) {
                        Logger.getLogger(ForParaleloClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
            t3.start();
            t4 = new Thread() {
                @Override
                public void run() {
                    try {
                        setV4(forParalelo4.op1(375000));
                    } catch (RemoteException ex) {
                        Logger.getLogger(ForParaleloClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
            t4.start();

            while ((t1.getState() != State.TERMINATED) || (t2.getState() != State.TERMINATED) || (t3.getState() != State.TERMINATED) || (t4.getState() != State.TERMINATED)) {
            }

            pi = forParalelo1.merge(v1, v2, v3, v4);
            System.out.println(pi);
   

        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            System.out.println("SomaClient exception:" + e);
        }
    }
}
