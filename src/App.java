public class App {
    public static void main(String[] args) throws Exception {
        Log.print(String.format("Welcome! MarchPlayerServer Version %s.", My.Version));
        Data.SetDirectory(System.getProperty("user.home").replaceAll("\\\\", "/"));
        NetHttp.startHttp();
    }
}