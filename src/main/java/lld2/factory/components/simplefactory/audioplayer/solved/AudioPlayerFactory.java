package lld2.factory.components.simplefactory.audioplayer.solved;

public class AudioPlayerFactory {
    public static AudioPlayer createAudioPlayer(MediaFormat mediaFormat, int volume, double playBackRate) {
        if(mediaFormat == MediaFormat.FLAC)
            return new FLACPlayer(volume, playBackRate);
        else if (mediaFormat == MediaFormat.MP3)
            return new MP3Player(volume, playBackRate);
        else
            return new WAVPlayer(volume, playBackRate);
    }
}
