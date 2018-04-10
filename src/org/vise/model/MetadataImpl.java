package org.vise.model;

import java.io.IOException;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

/**
 * 
 * @author eliapasqualini
 *
 */
public class MetadataImpl implements Metadata {

    private final String path;
    private Mp3File song;
    private String title;
    private String artist;
    private String album;
    private long duration;
    private ID3v2 id3v2Tag;

    /**
     * Create Metadata for the song.
     * @param audioPath
     *          Path of the song.
     */
    public MetadataImpl(final String audioPath) {
        this.path = audioPath;
        try {
            this.song = new Mp3File(this.path);
            this.getMetadata();
        } catch (UnsupportedTagException | InvalidDataException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Check if a field is null.
     * @param condition
     *          Condition to be checked.
     * @param field
     *          THe field to be returned.
     */
    private String checkFields(final boolean condition, final String field) {
        if (condition) {
            return "Non disponibile";
        }
        return field;
    }

    private void getMetadata() {
        if (this.song.hasId3v2Tag()) {
            this.id3v2Tag = this.song.getId3v2Tag();
            this.title = this.id3v2Tag.getTitle();
            this.artist = this.id3v2Tag.getArtist();
            this.album = this.id3v2Tag.getAlbum();
            this.duration = this.song.getLengthInSeconds();
        } else {
            System.out.println("Metadati non pervenuti.");
        }
    }

    /**
     * 
     */
    @Override
    public String getTitle() {
        return this.checkFields(this.title == null, this.title);
    }

    /**
     * 
     */
    @Override
    public String getArtist() {
        return this.checkFields(this.artist == null, this.artist);
    }

    /**
     * 
     */
    @Override
    public String getAlbum() {
        return this.checkFields(this.album == null, this.album);
    }

    /**
     * 
     */
    @Override
    public long getDuration() {
        return this.duration;
    }

}
