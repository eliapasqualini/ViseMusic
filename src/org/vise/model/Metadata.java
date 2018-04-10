package org.vise.model;

/**
 * 
 * @author eliapasqualini
 *
 */
public interface Metadata {

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
