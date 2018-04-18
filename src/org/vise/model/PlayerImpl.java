package org.vise.model;

import java.util.ArrayList;
import java.util.List;

import org.vise.model.playlist.FileSystemHandler;
import org.vise.model.playlist.Playlist;
import org.vise.model.playlist.PlaylistImpl;
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
    private static final float MAXGAIN = 5.0f;
    private static final float MINGAIN = -60.0f;
    private List<Playlist> playlists;

    /**
     * Constructor for the class PlayerImpl.
     */
    public PlayerImpl() {
        this.minim = new Minim(new FileSystemHandler());
        this.playlists = new ArrayList<>();
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
    }

    /**
     * 
     */
    @Override
    public void pause() {
        this.checkPlayerLoaded();
        this.player.pause();
    }

    /**
     * 
     */
    @Override
    public void replay() {
        this.checkPlayerLoaded();
        this.player.pause();
        this.player.rewind();
    }

    /**
     * 
     * @return
     *          If the player is playing a song.
     */
    @Override
    public boolean isPlayingSong() {
        return this.player.isPlaying();
    }

    /**
     * 
     */
    @Override
    public void setVolume(final float amount) {
        this.setGain(amount);
        if (this.player.getGain() <= MINGAIN) {
            this.setGain(MINGAIN);
            this.player.mute();
        } else {
            this.player.unmute();
        }
        if (this.player.getGain() >= MAXGAIN) {
            this.setGain(MAXGAIN);
        }
    }

    /**
     * 
     */
    @Override
    public int getPosition() {
        return this.player.position();
    }

    /**
     * 
     */
    @Override
    public void setPosition(final int pos) {
        if (pos < 0 || pos > this.getSongLength()) {
            throw new IllegalArgumentException();
        }
        final int newPosition = pos;
        this.player.play(newPosition);
    }

    /**
     * 
     */
    @Override
    public int getSongLength() {
        return this.player.length();
    }

    /**
     * 
     */
    @Override
    public void addPlaylist(final String namePlaylist) {
        this.playlists.add(new PlaylistImpl(namePlaylist));
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
     */
    @Override
    public List<Playlist> getAllPlaylist() {
        return this.playlists;
    }

    private void setGain(final float amount) {
        this.player.setGain(amount);
    }

}
