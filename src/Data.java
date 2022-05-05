import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;;

public class Data {

    static String Directory = "/home";

    private static ConfigModel[] Configs = {
            new ConfigModel(Config.HttpPort, "5252"),
            new ConfigModel(Config.UdpPort, "5253")
    };

    public static String GetConfig(String ConfigName) {
        for (ConfigModel cc : Configs) {
            if (cc.Name == ConfigName)
                return cc.Val;
        }
        Log.print(String.format("Config \"%s\" not found.", ConfigName));
        return "";
    }

    public static boolean MagicCompare(String a, String b) { // 神奇比较[捂脸哭]
        char[] a1 = a.toCharArray(), b1 = b.toCharArray();
        if (a1.length != b1.length) {
            return false;
        }
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != b1[i]) {
                return false;
            }
        }
        return true;
    }

    public static void SetConfig(String ConfigName, String Value) {
        for (int i = 0; i < Configs.length; i++) {
            if (MagicCompare(Configs[i].Name, ConfigName)) {
                    Configs[i].Val = Value;
                    Log.print(String.format("Config \"%s\" got value \"%s\".", ConfigName, Value));
                    WriteConfig();
                return;
            }
        }
        Log.print(String.format("Config \"%s\" not found.", ConfigName));
    }

    private static void ReadConfig() {
        try {
            File file = new File(Directory + "/config.cfg");
            if (!file.exists()) {
                file.createNewFile();
                WriteConfig();
            }
            List<String> allLines = Files.readAllLines(Paths.get(Directory + "/config.cfg"), StandardCharsets.UTF_8);
            for (String cl : allLines) {
                String[] cls = cl.split("=");
                SetConfig(cls[0], cls[1]);
            }
            My._ini_(Integer.parseInt(GetConfig(Config.HttpPort)), Integer.parseInt(GetConfig(Config.UdpPort)));
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.print(String.format("Unable to read config."));
            System.exit(-1);
        }
    }

    private static void WriteConfig() {
        try {
            File cfgConfig = new File(Directory + "/config.cfg");
            FileOutputStream fo = new FileOutputStream(cfgConfig);
            for (ConfigModel cc : Configs) {
                fo.write(cc.toString().getBytes("utf-8"));
                fo.write('\n');
            }
            fo.flush();
            fo.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            Log.print(String.format("Unable to access file \"%s\".", Directory + "/config.cfg"));
        }
    }

    public static void SetDirectory(String directory) {
        Directory = directory + "/.MarchPlayerServer";
        Log.print("Data directory is " + Directory + " .");
        try {
            File folder = new File(Directory);
            if (!folder.exists() && !folder.isDirectory()) {
                folder.mkdirs();
            }
            ReadConfig();
        } catch (Exception e) {
            e.printStackTrace();
            Log.print("Unable to access datas.");
        }
    }

}
