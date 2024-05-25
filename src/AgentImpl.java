public class AgentImpl implements iAgent {

    int agentNumber = 0;

    public Double pierwszaPrzekatna(Matrix mx) {

        switch (agentNumber) {
            case 1:
                return mx.getValue(0, 0) * mx.getValue(1, 1) * mx.getValue(2, 2);

            case 2:
                return mx.getValue(0, 1) * mx.getValue(1, 2) * mx.getValue(2, 0);

            case 3:
                return mx.getValue(0, 2) * mx.getValue(1, 0) * mx.getValue(2, 1);

            default:

                return null;
        }
    }

    public Double drugaPrzekatna(Matrix mx) {
        switch (agentNumber) {
            case 1:
                return mx.getValue(0, 2) * mx.getValue(1, 1) * mx.getValue(2, 0);

            case 2:
                return mx.getValue(0, 1) * mx.getValue(1, 0) * mx.getValue(2, 2);

            case 3:
                return mx.getValue(0, 0) * mx.getValue(1, 2) * mx.getValue(2, 1);

            default:

                return null;
        }
    }

    public Double sumujWyniki(Double x, Double y, Double z) {
        return x + y + z;
    }

    public Double sumujWyniki(Double x, Double y) {
        return x + y;
    }
}
