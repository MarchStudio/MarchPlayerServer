public class App {
    public static void main(String[] args) throws Exception {
        Log.print(String.format("Welcome! MarchPlayerServer Version %s.", My.Version));
        Data.SetDirectory(System.getProperty("user.home").replaceAll("\\\\", "/"));
        Playlist.ReadPlaylist();
        NetHttp.startHttp();
        NetUdp.startUdp();
    }

    // : ; {} 都是数据分割符号，不得出现在内容文本中！！


    //参考：https://www.cnblogs.com/tiancai/p/7942201.html              | http下载文件
    //     https://www.cnblogs.com/qiu18359243869/p/11136724.html      | http服务器
    //     https://www.jianshu.com/p/89b5737347f7                      | udp通信

}