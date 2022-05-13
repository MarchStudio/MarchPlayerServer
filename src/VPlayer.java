public class VPlayer {
    
    static boolean isPlaying = PlayState.Paused;

    static Song onPlay = new Song();

    public boolean PlayState(){
        return isPlaying;
    }

    public static void Pause(){
        isPlaying = !isPlaying;
    }

    public static String getStatus(){
        String result = "";
        
        return result;
    }

}
