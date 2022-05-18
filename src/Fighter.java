public class Fighter extends Characters{

    @Override
    public double calculateHealthPoint(double strength, double vitality, double intelligence) {
        super.calculateHealthPoint(6, 3, 1);
        return healthPoint;
    }

    @Override
    public void printInfo() {
    }

}
