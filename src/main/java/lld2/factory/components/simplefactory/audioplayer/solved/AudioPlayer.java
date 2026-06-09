package lld2.factory.components.simplefactory.audioplayer.solved;

public abstract class AudioPlayer {
    public int volume;
    public double playBackRate;

    public abstract void play() ;

    public abstract void pause() ;

    public abstract void stop() ;

    public abstract int getVolume() ;

    public abstract void setVolume(int volume) ;

    public abstract double getPlayBackRate() ;

    public abstract MediaFormat supportsType();
}
