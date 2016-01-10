package ForParaleloRMI;
import java.rmi.*;
import java.rmi.server.*;

public class ForParalelo extends UnicastRemoteObject implements ForParaleloRemote
{                      
	 
        
	public ForParalelo() throws RemoteException{}
	public double op1(int inicial ) throws RemoteException
	{
            int fim = inicial+125000;
            double saida=0;
            double potencia;
           
            
            for (int i = inicial; i <= fim; i++) {               
                potencia =Math.pow(-1, i);
                saida+= potencia * 4/(1+(2*i));                
            }
//            
//            int size=a.length;
//            int li=0;//limite inferior
//            int ls=(int)Math.abs(size*0.25);
//            for(int i=li;i<ls;i++)
//            {
//                a[i]=(int)Math.abs(Math.random()*valor_random);
//                a[i]*=5;
//            }

            
            return saida;
	}
//	public int[] op2(int a[] ) throws RemoteException
//	{
//            int size=a.length;
//            int li=(int)Math.abs(size*0.25);//limite inferior
//            int ls=(int)Math.abs(size*0.5);
//            for(int i=li;i<ls;i++)
//            {
//                //a[i]=(int)Math.abs(Math.random()*valor_random);
//                a[i]*=5;
//            }
//            return a;
//	}
//	public int[] op3(int a[] ) throws RemoteException
//	{
//            int size=a.length;
//            int li=(int)Math.abs(size*0.5);//limite inferior
//            int ls=(int)Math.abs(size*0.75);
//            for(int i=li;i<ls;i++)
//            {
//             //   a[i]=(int)Math.abs(Math.random()*valor_random);
//                a[i]*=5;
//            }
//            return a;
//	}
//	public int[] op4(int a[] ) throws RemoteException
//	{
//            int size=a.length;
//            int li=(int)Math.abs(size*0.75);//limite inferior
//            int ls=size;
//            for(int i=li;i<ls;i++)
//            {
//               // a[i]=(int)Math.abs(Math.random()*valor_random);
//                a[i]*=5;
//            }
//            return a;
//	}
//        public int[] merge(int a[], int b[], int c[],int d[] ) throws RemoteException
//        {
//            int result[] = new int[a.length];
//            System.arraycopy(a, 0, result, 0, 25);
//            System.arraycopy(b, 25, result, 25, 25);
//            System.arraycopy(c, 50, result, 50, 25);
//            System.arraycopy(d, 75, result, 75, 25);
//            return result;
//        }

    @Override
    public double merge(double a, double b, double c, double d) throws RemoteException {    
        return a+b+c+d;
    }
}