package MusicStreamingSystemLLD;

import MusicStreamingSystemLLD.command.Command;
import MusicStreamingSystemLLD.command.Next;
import MusicStreamingSystemLLD.command.Pause;
import MusicStreamingSystemLLD.command.Play;
import MusicStreamingSystemLLD.entities.Album;
import MusicStreamingSystemLLD.entities.Artist;
import MusicStreamingSystemLLD.entities.Player;
import MusicStreamingSystemLLD.entities.Song;
import MusicStreamingSystemLLD.entities.User;
import MusicStreamingSystemLLD.enums.Subscription;

public class MusicStreamingSystemLLDMain {
    
    public static void main(String[] args) {
        MusicStreamingService system = MusicStreamingService.getInstance();

        // --- Setup Catalog ---
        Artist daftPunk = new Artist("Daft Punk");
        system.addArtist(daftPunk);

        Album discovery = new Album("Discovery");
        Song s1 = system.addSong("One More Time", daftPunk.getId(), 320);
        Song s2 = system.addSong("Aerodynamic", daftPunk.getId(), 212);
        Song s3 = system.addSong("Digital Love", daftPunk.getId(), 301);
        Song s4 = system.addSong("Radioactive", daftPunk.getId(), 311);
        discovery.addTrack(s1);
        discovery.addTrack(s2);
        discovery.addTrack(s3);
        discovery.addTrack(s4);

        // --- Register Users (Builder Pattern) ---
        User freeUser = new User.Builder().setName("Alice").setSubcription(Subscription.FREE).build();
        User premiumUser = new User.Builder().setName("Bob").setSubcription(Subscription.PREMIUM).build();
        system.registerUser(freeUser);
        system.registerUser(premiumUser);

        // --- Observer Pattern: User follows artist ---
        System.out.println("--- Observer Pattern Demo ---");
        premiumUser.followArtist(daftPunk);
        daftPunk.addAlbum(discovery); // This will notify Bob
        System.out.println();

        // --- Strategy Pattern: Playback behavior ---
        System.out.println("--- Strategy Pattern (Free vs Premium) & State Pattern (Player) Demo ---");
        Player player = system.getPlayer();
        player.load(discovery, freeUser);

        // --- Command Pattern: Controlling the player ---
        Command play = new Play(player);
        Command pause = new Pause(player);
        Command next = new Next(player);

        play.execute(); // Plays song 1
        next.execute(); // Plays song 2
        pause.execute(); // Pauses song 2
        play.execute(); // Resumes song 2
        next.execute(); // Plays song 3
        next.execute(); // Plays song 4 (ad for free user)
        System.out.println();

        // --- Premium user experience (no ads) ---
        System.out.println("--- Premium User Experience ---");
        player.load(discovery, premiumUser);
        play.execute();
        next.execute();
        System.out.println();
    }    
}
