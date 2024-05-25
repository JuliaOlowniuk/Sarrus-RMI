import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends ServerImpl {

    public Server(Registry registry) {
        super(registry);
    }

    public static void main(String[] args) {
        try {
            // Utwórz rejestr RMI
            Registry registry = LocateRegistry.createRegistry(1099);

            // Utwórz instancję Server i przekaż do niej rejestr
            Server server = new Server(registry);
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
