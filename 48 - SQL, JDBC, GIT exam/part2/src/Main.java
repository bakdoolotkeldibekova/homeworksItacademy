import db.NewsDb;

public class Main {
    public static void main(String[] args) {
        NewsDb newsDb = new NewsDb();

        newsDb.createNews("Newsss", "bla-bla-bla..");
        newsDb.showNews(1);
        newsDb.changeHeadline(1, "NEWS!");
        newsDb.changeText(1, "programming is...");
        newsDb.deleteNews(1);

    }
}
