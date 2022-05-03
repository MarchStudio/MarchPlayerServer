public class Song {
    public String name;
    public String singer;
    public String url;

    public String toString() {
        return String.format("%s;%s;%s", name, singer, url);
    }
}
