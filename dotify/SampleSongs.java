import java.util.ArrayList;


public class SampleSongs {
	
	
	public static ArrayList<Song> getAllSongs(){
		Playlist r = getSampleSongsFromFiles();
		Playlist s = getSampleSimpsonsSongsFromURL();
		Playlist sw = getSampleStarWarsSongsFromURL();
		
		ArrayList<Song> allSongs = r.getSongs();
		allSongs.addAll(s.getSongs());
		allSongs.addAll(sw.getSongs());
		
		return allSongs;
	}

	
	public static Playlist getSampleSongsFromFiles(){
		ArrayList<Song> songs = new ArrayList<Song>();
		songs.add(new Song("Chomp", "audio//chomp.wav", true));
		songs.add(new Song("Pop", "audio//pop.wav", true));
		songs.add(new Song("Mmmm Chocolate", "audio//mchocola.wav", true));
		songs.add(new Song("Cow", "audio//cow.wav", true));

		
		return new Playlist("Random Sounds", songs);
	}
	
	
	public static Playlist getSampleSimpsonsSongsFromURL(){
		ArrayList<Song> songs = new ArrayList<Song>();
		
		
		songs.add(new Song("Kings", "http://www.thesoundarchive.com/simpsons/bart/bartkings.wav", false));
		songs.add(new Song("Crap", "http://www.thesoundarchive.com/simpsons/homer/crap.wav", false));
		songs.add(new Song("MMM Cookies", "http://www.thesoundarchive.com/simpsons/homer/mcrumble.wav", false));
		songs.add(new Song("TV Sucks", "http://www.thesoundarchive.com/simpsons/bart/tvsucks.wav", false));
		songs.add(new Song("DOH", "http://www.thesoundarchive.com/simpsons/homer/doh1.wav", false));
		return new Playlist("Simpsons", songs);
	}
	
	public static Playlist getSampleStarWarsSongsFromURL(){
		ArrayList<Song> songs = new ArrayList<Song>();
		
		songs.add(new Song("Imperial Song", "http://www.thesoundarchive.com/starwars/imperial_march.wav", false));
		songs.add(new Song("Rebel Song", "http://www.thesoundarchive.com/starwars/rebel-theme.wav", false));
		songs.add(new Song("Disturbance", "http://www.thesoundarchive.com/starwars/disturbence.wav", false));
		songs.add(new Song("The Force", "http://www.thesoundarchive.com/starwars/force.wav", false));
		songs.add(new Song("Jedi", "http://www.thesoundarchive.com/starwars/jedi-know.wav", false));
		songs.add(new Song("Highness", "http://www.thesoundarchive.com/starwars/killyouif.wav", false));
		songs.add(new Song("Jar Jar ", "http://www.thesoundarchive.com/starwars/Jarjar1.wav", false));
		
		return new Playlist("Star Wars", songs);
	}

}
