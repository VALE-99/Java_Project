public class Gazzella implements Preda {
    int vita = 5;
    @Override
    public void scappa() {
        System.out.println("scappo dal predatore");
    }

    @Override
    public void life() {
        System.out.println("mi hanno colpito");
    }

    @Override
    public int points(int v_leone, int v_gazzella) {
        return vita = vita - (v_leone-v_gazzella);
    }

    @Override
    public void death() {
        System.out.println("La gazzella  morta");
    }

    public int getlife() {
        return vita;
    }
}
