package CricinfoLLD.stratergy;

public class T20 implements MatchFormatStratergy{

    @Override
    public int getOvers() {
        return 2;
    }

    @Override
    public int getInnings() {
        return 2;
    }

    @Override
    public String getFormatName() {
        return "T20";
    }

    
}
