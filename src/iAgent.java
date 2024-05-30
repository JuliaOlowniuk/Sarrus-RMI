import java.rmi.Remote;
import java.rmi.RemoteException;

public interface iAgent extends Remote {

    public Double pierwszaPrzekatna(Double[][] mx) throws RemoteException;

    public Double drugaPrzekatna(Double[][] mx) throws RemoteException;


    public Double sumujWyniki(Double x, Double y, Double z) throws RemoteException;


    public Double obliczRoznice(Double x, Double y) throws RemoteException;
}
