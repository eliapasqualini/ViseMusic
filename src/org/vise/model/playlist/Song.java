package org.vise.model.playlist;

import java.util.UUID;

/**
 * 
 * @author eliapasqualini
 *
 */
public interface Song {

    /**
     * 
     * @return
     *          The metadata field.
     */
    Metadata getMeta();

    /**
     * 
     * @return
     *          The path of the current song.
     */
    String getPath();

    /**
     * 
     * @return
     *          The ID of the current song.
     */
    UUID getUUID();

    /**
     * 
     * @return
     *          The title of the current song.
     */
    String getTitle();

    /**
     * 
     * @return
     *          The artist of the current song.
     */
    String getArtist();

    /**
     * 
     * @return
     *          The album of the current song.
     */
    String getAlbum();

    /**
     * 
     * @return
     *          The duration of the current song.
     */
    long getDuration();
}
