import java.rmi.RemoteException;

public class AgentImpl implements iAgent {

    public AgentImpl(int agentNumber) throws RemoteException {
        super();
        this.agentNumber = agentNumber;
    }
    int agentNumber = 0;

    public Double pierwszaPrzekatna(Double[][] mx) {

        switch (agentNumber) {
            case 1:
                return mx[0][0] * mx[1][1] * mx[2][2];

            case 2:
                return mx[0][1] * mx[1][2] * mx[2][0];

            case 3:
                return mx[0][2] * mx[1][0] * mx[2][1];

            default:

                return null;
        }
    }

    public Double drugaPrzekatna(Double[][] mx) {
        switch (agentNumber) {
            case 1:
                return mx[0][2] * mx[1][1] * mx[2][0];

            case 2:
                return mx[0][1] * mx[1][0] * mx[2][2];

            case 3:
                return mx[0][0] * mx[1][2] * mx[2][1];

            default:

                return null;
        }
    }

    public Double sumujWyniki(Double x, Double y, Double z) {
        return x + y + z;
    }

    public Double obliczRoznice(Double x, Double y) {
        return x - y;
    }
}