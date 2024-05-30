import java.rmi.Remote;
import java.rmi.RemoteException;

public interface iServer extends Remote {

    public Double computeDeterminant(Double[][] mx) throws RemoteException;
}
