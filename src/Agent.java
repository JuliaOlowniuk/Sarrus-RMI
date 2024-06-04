import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Agent extends AgentImpl {

    public Agent(int agentNumber) throws RemoteException {
        super(agentNumber);
        this.agentNumber = agentNumber;
    }

    public static void main(String[] args) {
        // Kod inicjalizacyjny, np. uruchomienie agenta
        try {
            AgentImpl agent = new AgentImpl(Integer.parseInt(args[0]));

            iAgent stub = (iAgent) UnicastRemoteObject.exportObject(agent, 0);

            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Agent " + args[0], stub);


            System.out.println("Agent " + args[0] + " ready");

        } catch (RemoteException e) {
            e.printStackTrace();
            System.out.println("Agent exception: " + e.getMessage());
        } catch (AlreadyBoundException e) {
            throw new RuntimeException(e);
        }
    }

}