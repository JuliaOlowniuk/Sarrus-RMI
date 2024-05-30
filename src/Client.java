import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {

        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            iServer stub = (iServer) registry.lookup("Server");

            // przykladowa macierz
            Double[][] mx = {{1.0, 2.0, 3.0}, {1.0, 4.0, 9.0}, {1.0, 8.0, 27.0}};


            Double determinant = stub.computeDeterminant(mx);
            System.out.println("Determinant: " + determinant);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Client exception: " + e.getMessage());
        }
    }
}