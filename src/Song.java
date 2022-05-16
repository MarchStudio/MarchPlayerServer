public class Song {

    // Song的字符串形式:name;singer;url;coverUrl;uploader;

    public String name = "";
    public String singer = "";
    public String url = "";
    public String coverUrl = "";
    public String uploader = "";

    public static Song toSong(String songSource) throws Exception{  //从字符串转换成Song
        try {
            Song song = new Song();
            String[] source = songSource.split(";");
            song.name = source[0];
            song.singer = source[1];
            song.url = source[2];
            song.coverUrl = source[3];
            song.uploader = source[4];
            return song;
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.print(String.format("Unable while converting \"%s\" to Song.", songSource));
            throw new Exception();
        }
    }

    public String toString() {
        return String.format("%s;%s;%s;%s;%s;", name, singer, url, coverUrl, uploader);
    }
}
