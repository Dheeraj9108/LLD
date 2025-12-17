package MusicStreamingSystemLLD.observer;

import MusicStreamingSystemLLD.entities.Album;
import MusicStreamingSystemLLD.entities.Artist;

public interface ArtistObserver {
    void update(Artist artist, Album album);
}
