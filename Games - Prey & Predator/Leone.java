public class Leone implements Predatore {

    @Override
    public void corro() {
        System.out.println("the lion runs towards the prey");
    }

    @Override
    public void attacco() {
        System.out.println("the lion attacked the gazelle");
    }
}
