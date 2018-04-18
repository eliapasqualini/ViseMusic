package org.vise.model;

import org.vise.model.playlist.FileSystemHandler;
import org.vise.model.playlist.Song;

import ddf.minim.AudioPlayer;
import ddf.minim.Minim;

/**
 * 
 * @author eliapasqualini
 *
 */
public class PlayerImpl implements Player {

    private AudioPlayer player;
    private Minim minim;
    private boolean isPlaying;
    private static final float MAXGAIN = 5.0f;
    private static final float MINGAIN = -60.0f;

    /**
     * Constructor for the class PlayerImpl.
     */
    public PlayerImpl() {
        this.minim = new Minim(new FileSystemHandler());
        this.isPlaying = false;
    }

    /**
     * 
     * @param song
     *          The song to be played.
     */
    @Override
    public void loadSong(final Song song) {
        this.player = this.minim.loadFile(song.getPath());
    }

    /**
     * 
     */
    @Override
    public void play() {
        this.checkPlayerLoaded();
        this.player.play();
        this.setIsPlaying(true);
    }

    /**
     * 
     */
    @Override
    public void pause() {
        this.checkPlayerLoaded();
        this.player.pause();
        this.setIsPlaying(false);
    }

    /**
     * 
     */
    @Override
    public void replay() {
        this.checkPlayerLoaded();
        this.player.pause();
        this.player.rewind();
        this.setIsPlaying(false);
    }

    /**
     * 
     * @return
     *          If the player is playing a song.
     */
    @Override
    public boolean isPlayingSong() {
        return this.isPlaying;
    }


    /**
     * 
     */
    @Override
    public void setVolume(final float amount) {
        this.player.setGain(this.player.getGain() + amount);
        if (this.player.getGain() <= MINGAIN) {
            this.player.setGain(MINGAIN);
            this.player.mute();
        } else {
            this.player.unmute();
        }
        if (this.player.getGain() >= MAXGAIN) {
            this.player.setGain(MAXGAIN);
        }
    }

    /**
     * 
     */
    @Override
    public int getPosition() {
        // ritorna la percentuale della posizione attuale
        return (this.player.length() / 100) * this.player.position();
    }

    /**
     * 
     */
    @Override
    public void setPoistion(final int pos) {
        //controllo che il valore in ingresso sia una percentuale valida
        if (pos > 100 || pos < 0) {
            throw new IllegalArgumentException();
        }
        //calcola dalla percentuale i millisecondi da cui far eseguire la canzone
        final int newPosition = (this.player.length() / 100) * pos;
        this.player.play(newPosition);
    }

    /**
     * 
     */
    private void checkPlayerLoaded() {
        if (this.playerEmpty()) {
            throw new IllegalStateException("No song has been loaded.");
        }
    }

    /**
     * 
     * @return
     *          Return if there aren't song already loaded.
     */
    private boolean playerEmpty() {
        return this.player == null;
    }

    /**
     * 
     * @param state
     *          State to be attached to isPlaying field.
     */
    private void setIsPlaying(final boolean state) {
        this.isPlaying = state;
    }

}
