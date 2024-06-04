import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl implements iServer {
    protected Registry registry;


    @Override
    public Double computeDeterminant(Double[][] mx) throws RemoteException {
        if (mx.length != 3 || mx[0].length != 3) {
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

            Watek t1 = new Watek(stub1, 1, mx);
            Watek t2 = new Watek(stub2, 1, mx);
            Watek t3 = new Watek(stub3, 1, mx);

            t1.start();
            t2.start();
            t3.start();

            t1.join();
            t2.join();
            t3.join();

            firstDiag = t1.getWynik();
            secondDiag = t2.getWynik();
            thirdDiag = t3.getWynik();

            System.out.println("Pierwsze przekatne " + firstDiag + " " + secondDiag + " " + thirdDiag);

            firstSum = stub1.sumujWyniki(firstDiag, secondDiag, thirdDiag);

            System.out.println("Suma = " + firstSum);

            t1 = new Watek(stub1, 2, mx);
            t2 = new Watek(stub2, 2, mx);
            t3 = new Watek(stub3, 2, mx);

            t1.start();
            t2.start();
            t3.start();

            t1.join();
            t2.join();
            t3.join();

            firstDiag = t1.getWynik();
            secondDiag = t2.getWynik();
            thirdDiag = t3.getWynik();

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