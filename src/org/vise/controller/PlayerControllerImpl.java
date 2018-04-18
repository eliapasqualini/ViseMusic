package org.vise.controller;

import java.util.List;

import org.vise.model.Player;
import org.vise.model.PlayerImpl;
import org.vise.model.playlist.Playlist;
import org.vise.model.playlist.SongImpl;

/**
 * 
 * @author eliapasqualini
 *
 */
public class PlayerControllerImpl implements PlayerController {

    private final Player player;

    /**
     * 
     */
    public PlayerControllerImpl() {
        this.player = new PlayerImpl();
    }

    /**
     * Play song.
     */
    @Override
    public void play() {
        this.player.play();
    }

    /**
     * 
     */
    @Override
    public void replay() {
        this.player.replay();
    }

    /**
     * 
     */
    @Override
    public void loadSong(final String path) {
        this.player.loadSong(new SongImpl(path));
    }

    /**
     * 
     */
    @Override
    public void changeVolume(final float amount) {
        this.player.setVolume(amount);
    }

    /**
     * 
     */
    @Override
    public void changePosition(final float position) {
        this.player.setPosition((int) position);
    }

    /**
     * 
     */
    @Override
    public int getPosition() {
        return this.player.getPosition();
    }

    /**
     * 
     */
    @Override
    public int getMaxLengthSong() {
        return this.player.getSongLenght();
    }

    /**
     * 
     */
    @Override
    public void addPlaylist(final String namePlaylist) {
        this.player.addPlaylist(namePlaylist);
    }

    /**
     * 
     */
    @Override
    public List<Playlist> getAllPlaylist() {
        return this.player.getAllPlaylist();
    }
}
