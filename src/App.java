public class App {
    public static void main(String[] args) throws Exception {
        Log.print(String.format("Welcome! MarchPlayerServer Version %s.", My.Version));
        Data.SetDirectory(System.getProperty("user.home").replaceAll("\\\\", "/"));
        Playlist.ReadPlaylist();
        NetHttp.startHttp();
        NetUdp.startUdp();
    }

    // : ; {} 都是数据分割符号，不得出现在内容文本中！！

}