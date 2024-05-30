import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends ServerImpl {


    public static void main(String[] args) {
        try {
            // Utwórz rejestr RMI
            Registry registry = LocateRegistry.getRegistry();

            // Utwórz instancję Server i przekaż do niej rejestr
            ServerImpl server =  new ServerImpl();
            iServer stub = (iServer) UnicastRemoteObject.exportObject(server, 0);

            // Zarejestruj stub w rejestrze
            registry.bind("Server", stub);

            System.out.println("Server ready");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Server exception: " + e.getMessage());
        }
    }
}
