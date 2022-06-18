import java.util.concurrent.ForkJoinPool;

public class Main
{
    public static void main(String[] args)
    {
        String url = "https://skillbox.ru/";
//        String url = "https://lenta.ru/";


        Site root = new Site(url);

        Site site = new ForkJoinPool().invoke(new LinkSite(root));
        print(site);
    }

    private static void print(Site lenta) {
        print(lenta, 0);
    }

    private static void print(Site lenta, int deep) {
        System.out.println(tabs(deep) + lenta.getUrl());
        for (Site l : lenta.getSites()) {
            print(l, deep + 1);
        }
    }

    private static String tabs(int deep) {
        StringBuilder tabs = new StringBuilder();
        for (int i = 0; i < deep; i++) {
            tabs.append('\t');
        }
        return tabs.toString();
    }
}
