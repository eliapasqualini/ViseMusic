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
