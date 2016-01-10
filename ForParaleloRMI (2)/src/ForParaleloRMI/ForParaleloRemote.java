package ForParaleloRMI;
import java.rmi.*;

public interface ForParaleloRemote extends Remote
{
	public double op1(int inicial) throws RemoteException;
//	public int[] op2(int a[]) throws RemoteException;
//	public int[] op3(int a[]) throws RemoteException;
//	public int[] op4(int a[]) throws RemoteException;
	public double merge(double a, double b, double c, double d) throws RemoteException;
}
