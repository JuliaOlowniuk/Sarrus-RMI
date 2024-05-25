import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl implements iServer {
    protected Registry registry;

    public ServerImpl(Registry registry) {
        this.registry = registry;
    }

    @Override
    public Double computeDeterminant(Matrix mx) throws RemoteException {
        if (mx.mx.length != 3 || mx.mx[0].length != 3) {
            System.err.println("Matrix must be a 3x3 matrix.");
            return null;
        }

        try {
            // Użycie rejestru do wyszukiwania agentów
            iAgent stub1 = (iAgent) registry.lookup("Agent 1");
            iAgent stub2 = (iAgent) registry.lookup("Agent 2");
            iAgent stub3 = (iAgent) registry.lookup("Agent 3");

            double firstDiag, secondDiag, thirdDiag;
            double firstSum, secondSum;
            double determinant;

            firstDiag = stub1.pierwszaPrzekatna(mx);
            secondDiag = stub2.pierwszaPrzekatna(mx);
            thirdDiag = stub3.pierwszaPrzekatna(mx);

            firstSum = stub1.sumujWyniki(firstDiag, secondDiag, thirdDiag);

            firstDiag = stub1.drugaPrzekatna(mx);
            secondDiag = stub2.drugaPrzekatna(mx);
            thirdDiag = stub3.drugaPrzekatna(mx);

            secondSum = stub2.sumujWyniki(firstDiag, secondDiag, thirdDiag);

            determinant = stub3.sumujWyniki(firstSum, secondSum);

            return determinant;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Server exception: " + e.getMessage());
            return 0.0;
        }
    }
}
