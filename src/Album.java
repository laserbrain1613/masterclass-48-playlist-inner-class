import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public boolean addSong(String songTitle, double songDuration) {
        return this.songs.add(new Song(songTitle, songDuration));
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        Song song = songs.findSong(trackNumber);
        if (song != null) {
            return playList.add(song);
        }
        return false;
    }

    public boolean addToPlayList(String trackName, LinkedList<Song> playList) {
        Song song = songs.findSong(trackName);
        if (song != null) {
            return playList.add(song);
        }
        return false;
    }


    private static class SongList {
        private ArrayList<Song> songs;

        private SongList() {
            this.songs = new ArrayList<>();
        }

        private boolean add(Song song) {
            if (songs.contains(song)) {
                return false;
            }
            return songs.add(song);
        }

        private Song findSong(String songName) {
            for (Song song : this.songs) {
                if (song.getTitle().equals(songName)) {
                    return song;
                }
            }
            return null;
        }

        private Song findSong(int trackNumber) {
            int index = trackNumber - 1;
            if ((index >= 0) && (index < songs.size())) {
                return songs.get(index);
            }
            return null;
        }
    }

}