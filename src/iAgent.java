import java.rmi.Remote;
import java.rmi.RemoteException;

public interface iAgent extends Remote {

    public Double pierwszaPrzekatna(Matrix mx) throws RemoteException;

    public Double drugaPrzekatna(Matrix mx) throws RemoteException;


    public Double sumujWyniki(Double x, Double y, Double z) throws RemoteException;


    public Double sumujWyniki(Double x, Double y) throws RemoteException;
}
