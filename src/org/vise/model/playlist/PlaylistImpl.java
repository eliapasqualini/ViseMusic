package org.vise.model.playlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.vise.model.Song;


/**
 * 
 * @author eliapasqualini
 *
 */
public  class PlaylistImpl implements Playlist {

    private final UUID playlistID;
    private String name;
    private final  Map<UUID, List<Song>> map = new HashMap<>();

    /**
     * 
     * @param name
     *          The name of Playlist
     */
    public PlaylistImpl(final String name) {
        this.playlistID = UUID.randomUUID();
        this.name = name;
        this.map.put(this.playlistID, new ArrayList<>());
    }

    /**
     * 
     */
    @Override
    public void addSong(final Song newSong) {
        this.map.get(this.playlistID).add(newSong);
    }

    /**
     * 
     */
    @Override
    public void removeSong(final Song song) throws IllegalArgumentException {
        if (!checkSong(song)) {
            throw new IllegalArgumentException("Song not found");
        }
        this.map.get(this.playlistID).remove(song);
    }

    /**
     * 
     */
    @Override
    public int getNumberOfSongs() {
        return this.map.get(this.playlistID).size();
    }

    /**
     * 
     */
    @Override
    public UUID getID() {
        return this.playlistID;
    }


    /**
     * 
     */
    @Override
    public String getName() {
        return this.name;
    }


    /**
     * 
     */
    @Override
    public List<Song> getPlaylistContent() {
        return this.map.get(this.playlistID);
    }


    /**
     * 
     */
    @Override
    public boolean isEmpty() {
            return this.map.get(this.playlistID).isEmpty();
    }

    /**
     * 
     */
    @Override
    public void setName(final String newName) {
        this.name = newName;
    }

    /**
     * 
     */
    @Override
    public void removeAllSongs() {
        this.map.get(this.playlistID).clear();
    }

    private boolean checkSong(final Song song) {
        return this.map.get(this.playlistID).contains(song);
    }

}
