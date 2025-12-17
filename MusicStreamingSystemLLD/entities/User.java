package MusicStreamingSystemLLD.entities;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import MusicStreamingSystemLLD.enums.Subscription;
import MusicStreamingSystemLLD.observer.ArtistObserver;
import MusicStreamingSystemLLD.stratergy.PlayStratergy;

public class User implements ArtistObserver {
    private String id;
    private String name;
    private Set<Artist> followedArtists;
    private PlayStratergy stratergy;

    public User(String name, Subscription subscription){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        followedArtists = new HashSet<>();
        this.stratergy = PlayStratergy.getStratergy(subscription);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Artist> getFollowedArtists() {
        return followedArtists;
    }

    public PlayStratergy getStratergy() {
        return stratergy;
    }

    public void followArtist(Artist artist){
        System.out.printf("%s followed %s \n",name,artist.getName());
        this.followedArtists.add(artist);
        artist.addObserver(this);
    }

    public static class Builder {
        private String name;
        private Subscription subscription;

        

        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public Builder setSubcription(Subscription subscription){
            this.subscription = subscription;
            return this;
        }

        public User build(){
            return new User(name, subscription);
        }
    }

    @Override
    public void update(Artist artist, Album album) {
        System.out.printf("Notification to %s --- %s released new album %s \n", name, artist.getName(), album.getName());
    }

}
