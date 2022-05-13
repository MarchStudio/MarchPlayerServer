public class VPlayer {
    
    static boolean isPlaying = PlayState.Paused;

    static Song onPlay = new Song();

    static long playLength = 0;

    public boolean PlayState(){
        return isPlaying;
    }

    public static void Pause(){
        isPlaying = !isPlaying;
    }

    public static String getStatus(){
        String result = "";
        result = String.format("%s|%d|%d", onPlay.toString(), playLength, isPlaying ? 1: 0);
        Log.print("VPLayer Status:s " + result);
        return result;
    }

}
