import java.io.File;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;

public class VPlayer {

    static boolean isPlaying = PlayState.Paused;

    static Song onPlay = new Song();

    static long playLength = 0;

    public boolean PlayState() {
        return isPlaying;
    }

    public static void Pause() {
        isPlaying = false;
        Log.print("VPlayer Pause.");
    }

    public static void Play() {
        isPlaying = true;
        Log.print("VPlayer Play.");
    }

    public static void Play(Song song) {
        playLength = 0;
        onPlay = song;
        Play();
    }

    public static String getStatus() {
        String result = "";
        result = String.format("%s|%d|%d", onPlay.toString(), playLength, isPlaying ? 1 : 0);
        Log.print("VPLayer Status:s " + result);
        return result;
    }

    public static long getLength(Song songSource) {
        //TODO:添加下载音频文件的代码
        return getMp3Length(songSource.url);
    }

    public static long getMp3Length(String url) {
        File file = new File(url);
        try {
            MP3File f = (MP3File) AudioFileIO.read(file);
            MP3AudioHeader audioHeader = (MP3AudioHeader) f.getAudioHeader();
            return audioHeader.getTrackLength();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
