package org.vise.model;

import org.vise.model.playlist.Song;

/**
 * 
 * @author mattianavach
 *
 */
public interface Player {

    /**
     * 
     * @param song
     *          The song to be loaded;
     */
    void loadSong(Song song);

    /**
     * 
     */
    void play();

    /**
     * 
     */
    void pause();

    /**
     * 
     */
    void replay();

    /**
     * 
     * @return
     *          It the player is playing a song.
     */
    boolean isPlayingSong();
    
    /**
     * 
     * @param amount
     *          The value of the volume.
     */
    void setVolume(float amount);
}
