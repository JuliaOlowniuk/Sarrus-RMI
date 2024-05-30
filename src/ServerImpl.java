import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl implements iServer {
    protected Registry registry;


    @Override
    public Double computeDeterminant(Double[][] mx) throws RemoteException {
        if (mx.length != 3 || mx [0].length != 3) {
            System.err.println("Matrix must be a 3x3 matrix.");
            return null;
        }

        try {
            // Użycie rejestru do wyszukiwania agentów
            Registry registry = LocateRegistry.getRegistry();
            iAgent stub1 = (iAgent) registry.lookup("Agent 1");
            iAgent stub2 = (iAgent) registry.lookup("Agent 2");
            iAgent stub3 = (iAgent) registry.lookup("Agent 3");

            double firstDiag, secondDiag, thirdDiag;
            double firstSum, secondSum;
            double determinant;

            firstDiag = stub1.pierwszaPrzekatna(mx);
            secondDiag = stub2.pierwszaPrzekatna(mx);
            thirdDiag = stub3.pierwszaPrzekatna(mx);

            System.out.println("Pierwsze przekatne " + firstDiag + " " + secondDiag + " " + thirdDiag);

            firstSum = stub1.sumujWyniki(firstDiag, secondDiag, thirdDiag);

            System.out.println("Suma = " + firstSum);

            firstDiag = stub1.drugaPrzekatna(mx);
            secondDiag = stub2.drugaPrzekatna(mx);
            thirdDiag = stub3.drugaPrzekatna(mx);

            System.out.println("Drugie przekatne " + firstDiag + " " + secondDiag + " " + thirdDiag);

            secondSum = stub2.sumujWyniki(firstDiag, secondDiag, thirdDiag);

            System.out.println("Suma = " + secondSum);

            determinant = stub3.obliczRoznice(firstSum, secondSum);

            System.out.println("Wyznacznik = " + determinant);

            return determinant;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Server exception: " + e.getMessage());
            return 0.0;
        }
    }
}
