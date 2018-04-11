package org.vise.controller;

import org.vise.model.FileSystemHandler;

import ddf.minim.AudioPlayer;
import ddf.minim.Minim;

/**
 * 
 * @author mattianavach
 *
 */
public class PlayerControllerImpl {

    private final AudioPlayer player;
    private boolean isPlaying;

    /**
     * 
     */
    public PlayerControllerImpl() {
        final Minim minim = new Minim(new FileSystemHandler());
        this.player = minim.loadFile("res/songs/song1.mp3");
        this.isPlaying = false;
    }

    /**
     * Play song.
     */
    public void play() {
        if (!this.isPlaying)  {
            this.player.play();
            this.setPlay(true);
        } else {
            this.player.pause();
            this.setPlay(false);
        }
    }

    /**
     * 
     * @param isPlay
     */
    private void setPlay(final boolean isPlay) {
        this.isPlaying = isPlay;
    }

    /**
     * 
     */
    public void replay() {
        if (this.isPlaying) {
            this.player.pause();
            this.player.rewind();
        }
    }

}
