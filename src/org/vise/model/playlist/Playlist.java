package org.vise.model.playlist;

import java.util.List;
import java.util.UUID;

/**
 * 
 * @author eliapasqualini
 *
 */
public interface Playlist {

    /**
     * 
     * @param newSong
     *          The song to be added.
     */
    void addSong(Song newSong);

    /**
     * 
     * @param song
     *          The song to be removed.
     * @throws IllegalArgumentException
     *          Exception if the song is not stored.
     */
    void removeSong(Song song) throws IllegalArgumentException;

    /**
     * 
     * @return
     *          The number of the songs.
     */
    int getNumberOfSongs();

    /**
     * 
     * @return
     *          The ID of the current playlist.
     */
    UUID getID();

    /**
     * 
     * @return
     *          The name of the current playlist.
     */
    String getName();

    /**
     * 
     * @return
     *          The name of the author.
     */
    String getAuthor();

    /**
     * 
     * @return
     *          The list of the song in the current playlist.
     */
    List<Song> getPlaylistContent();

    /**
     * 
     * @return
     *          If the current playlist is empty.
     * 
     */
    boolean isEmpty();

    /**
     * 
     * @param newName
     *          The new name of the current playlist.
     */
    void setName(String newName);

    /**
     *
     */
    void removeAllSongs();
}
