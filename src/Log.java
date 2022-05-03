public class Log {
    public static void print(String content){
        System.out.printf("[%s] %s\n", My.TimeOfDay(), content);
    }
}
