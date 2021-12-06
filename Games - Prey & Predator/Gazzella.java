public class Gazzella implements Preda {
    int vita = 5;
    @Override
    public void scappa() {
        System.out.println("the gazelle runs away from the predator");
    }

    @Override
    public void life() {
        System.out.println("the gazelle was hit");
    }

    @Override
    public int points(int v_leone, int v_gazzella) {
        return vita = vita - (v_leone-v_gazzella);
    }

    @Override
    public void death() {
        System.out.println("The gazelle is dead");
    }

    public int getlife() {
        return vita;
    }
}
