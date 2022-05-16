public class VPlayer {
    
    static boolean isPlaying = PlayState.Paused;

    static Song onPlay = new Song();

    static long playLength = 0;

    public boolean PlayState(){
        return isPlaying;
    }

    public static void Pause(){
        isPlaying = false;
    }

    public static void Play(){
        isPlaying = true;
    }

    public static void Play(Song song){
        playLength = 0;
        onPlay = song;
        Play();
    }

    public static String getStatus(){
        String result = "";
        result = String.format("%s|%d|%d", onPlay.toString(), playLength, isPlaying ? 1: 0);
        Log.print("VPLayer Status:s " + result);
        return result;
    }

    public static String getLength(){
        Song song = new Song();
        String[] source = songSource.split(";");
        song.url = source[2];
        return getMp3Length(song.url);
    }

    public static long getMp3Length(String url) {
		File file = new File(url);
		try {
			MP3File f = (MP3File) AudioFileIO.read(file);
			MP3AudioHeader audioHeader = (MP3AudioHeader) f.getAudioHeader();
			// System.out.println(audioHeader.getTrackLength());
			return audioHeader.getTrackLength();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
