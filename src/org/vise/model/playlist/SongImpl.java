package org.vise.model.playlist;

import java.util.UUID;

/**
 * 
 * @author eliapasqualini
 *
 */
public class SongImpl implements Song {

    private final UUID songID;
    private final String audioPath;
    private final Metadata meta;

    /**
     * Create Song object.
     * @param audioPath
     *          Path of the song.
     */
    public SongImpl(final String audioPath) {
        this.songID = UUID.randomUUID();
        this.audioPath = audioPath;
        this.meta = new MetadataImpl(this.audioPath);
    }

    /**
     * 
     */
    @Override
    public Metadata getMeta() {
        return this.meta;
    }

    /**
     * 
     */
    @Override
    public String getPath() {
        return this.audioPath;
    }

    /**
     * 
     */
    @Override
    public UUID getUUID() {
        return this.songID;
    }

    /* Refresh metadata */

}
