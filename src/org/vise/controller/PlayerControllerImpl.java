package org.vise.controller;

import org.vise.model.PlayerImpl;
import org.vise.model.playlist.SongImpl;

/**
 * 
 * @author eliapasqualini
 *
 */
public class PlayerControllerImpl implements PlayerController {

    private final PlayerImpl player;

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
     * @param path
     *          The path of the song to be played.
     */
    @Override
    public void loadSong(final String path) {
        this.player.loadSong(new SongImpl(path));
    }
}
