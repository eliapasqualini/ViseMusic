package org.vise.controller;

/**
 * 
 * @author eliapasqualini
 *
 */
public interface PlayerController {

    /**
     * 
     */
    void play();

    /**
     * 
     */
    void replay();

    /**
     * 
     * @param path
     *          The path of song to be loaded.
     */
    void loadSong(String path);
}
