public class Watek extends Thread {

    iAgent agent;
    int przekatna;
    Double[][] mx;


    double wynik = 0;

    public Watek(iAgent agent, int przekatana, Double[][] mx) {
        this.agent = agent;
        this.przekatna = przekatana;
        this.mx = mx;
    }

    @Override
    public void run() {

        switch (this.przekatna) {
            case 1:

                try {
                    wynik = agent.pierwszaPrzekatna(mx);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Agent exception: " + e.getMessage());
                }

                break;

            case 2:
                try {
                    wynik = agent.drugaPrzekatna(mx);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Agent exception: " + e.getMessage());
                }

                break;
        }

    }

    public double getWynik() {
        return wynik;
    }
}