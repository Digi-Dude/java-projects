import java.util.*;
import java.util.concurrent.RecursiveTask;

public class LinkSite extends RecursiveTask<Site> {
    private final Site site;
    private final Set<String> allUrls;

    public LinkSite(Site site) {
        this.site = site;
        allUrls = Collections.synchronizedSet(new HashSet<>());
    }

    public LinkSite(Site site, Set<String> allUrls) {
        this.site = site;
        this.allUrls = allUrls;
    }

    @Override
    protected Site compute() {
        List<LinkSite> taskList = new ArrayList<>();

        for (String link : site.getUrls()) {
            if (allUrls.contains(link)) {
                continue;
            }
            allUrls.add(link);
            LinkSite task = new LinkSite(new Site(link), allUrls);
            task.fork();
            taskList.add(task);
        }

        for (LinkSite linkLenta : taskList) {
            site.getSites().add(linkLenta.join());
        }

        return site;
    }
}
