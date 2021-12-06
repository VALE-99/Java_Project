public class Leone implements Predatore {

    @Override
    public void corro() {
        System.out.println("corro dietro la preda");
    }

    @Override
    public void attacco() {
        System.out.println("il leone ha attaccato");
    }
}
