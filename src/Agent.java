import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Agent extends AgentImpl {

    private int agentNumber;

    public Agent(int agentNumber) throws RemoteException {
        super();
        this.agentNumber = agentNumber;
    }

    public static void main(String[] args) {
        // Kod inicjalizacyjny, np. uruchomienie agenta
        try {
            AgentImpl agent1 = new Agent(1);
            AgentImpl agent2 = new Agent(2);
            AgentImpl agent3 = new Agent(3);

            iAgent stub1 = (iAgent) UnicastRemoteObject.exportObject(agent1, 0);
            iAgent stub2 = (iAgent) UnicastRemoteObject.exportObject(agent2, 0);
            iAgent stub3 = (iAgent) UnicastRemoteObject.exportObject(agent3, 0);


            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Agent 1", stub1);
            registry.bind("Agent 2", stub2);
            registry.bind("Agent 3", stub3);

            System.out.println("Agent ready");

        } catch (RemoteException e) {
            e.printStackTrace();
            System.out.println("Agent exception: " + e.getMessage());
        } catch (AlreadyBoundException e) {
            throw new RuntimeException(e);
        }
    }

}
