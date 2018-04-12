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
}
