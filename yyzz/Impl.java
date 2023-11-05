package yyzz;

public class Impl {
    public static void main(String[] args) {
        Linkimpl<String> link = new Linkimpl<String>();
        link.add("null");
        link.add("fucking deep");
        link.add("NIHAO");
        link.add("ZTXD");
        System.out.println(link.getCount());
    }
}
