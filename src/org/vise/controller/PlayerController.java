package org.vise.controller;

import java.util.List;

import org.vise.model.playlist.Playlist;

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

    /**
     * 
     * @param amount
     *          The value of the volume requested.
     */
    void changeVolume(float amount);

    /**
     * 
     * @param position
     *          The new position of the song.
     */
    void changePosition(float position);

    /**
     * 
     * @return
     *          The position of the song.
     */
    int getPosition();

    /**
     * 
     * @return
     *          The lenght of the song.
     */
    int getMaxLengthSong();

    /**
     * 
     * @param namePlaylist
     *          The name of the playlist.
     */
    void addPlaylist(String namePlaylist);

    /**
     * 
     * @return
     *          The list of the playlists attached 
     */
    List<Playlist> getAllPlaylist();
}
