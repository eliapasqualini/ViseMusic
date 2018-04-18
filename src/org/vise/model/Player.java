package org.vise.model;

import java.util.List;

import org.vise.model.playlist.Playlist;
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
     * @return
     *          The position in percentage of the current song.
     */
    int getPosition();

    /**
     * 
     * @param position
     *          The position in percentage of the current song.
     */
    void setPosition(int position);

    /**
     * 
     * @param amount
     *          The value of the volume.
     */
    void setVolume(float amount);

    /**
     * 
     * @return
     *          The lenght of the song.
     */
    int getSongLength();

    /**
     * 
     * @param namePlaylist
     *          The name of the playlist to be added.
     */
    void addPlaylist(String namePlaylist);

    /**
     * 
     * @return
     *          The list of the playlist attached at the current player.
     */
    List<Playlist> getAllPlaylist();
}
