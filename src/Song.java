public class Song {

    public String name = "";
    public String singer = "";
    public String url = "";
    public String coverUrl = "";
    public String uploader = "";

    public String toString() {
        return String.format("%s;%s;%s;%s;%s;", name, singer, url, coverUrl, uploader);
    }
}
