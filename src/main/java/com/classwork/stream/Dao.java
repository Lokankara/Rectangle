package com.classwork.stream;

import java.util.Arrays;
import java.util.List;

public class Dao {
	public static final Artist johnColtrane = new Artist("John Coltrane", "US");

	public static final Artist johnLennon = new Artist("John Lennon", "UK");
	public static final Artist paulMcCartney = new Artist("Paul McCartney", "UK");
	public static final Artist georgeHarrison = new Artist("George Harrison", "UK");
	public static final Artist ringoStarr = new Artist("Ringo Starr", "UK");
	public static final Artist hatfield = new Artist("James", "US");
	public static final Artist hammet = new Artist("Kirk", "US");
	public static final Artist mustaine = new Artist("Dave", "UK");
	public static final Artist ulrich = new Artist("Lars", "UK");

	public static final List<Artist> membersOfMetallica = List.of(hatfield, hammet, mustaine, ulrich);

	public static final List<Track> masterList = List.of(new Track("Battery", 524), new Track("Master", 378),
			new Track("Orion", 451));

	public static final Artist metallica = new Artist("Metallica", membersOfMetallica, "UK");

	public static final List<Artist> membersOfTheBeatles = Arrays.asList(johnLennon, paulMcCartney, georgeHarrison,
			ringoStarr);

	public static final Artist theBeatles = new Artist("The Beatles", membersOfTheBeatles, "UK");

	public static final Album aLoveSupreme = new Album("A Love Supreme",
			Arrays.asList(new Track("Acknowledgement", 467), new Track("Resolution", 442)),
			Arrays.asList(johnColtrane));

	public static final Album master = new Album("Master of Puppets", masterList, membersOfMetallica);
	public static final Album garage = new Album("Garage Inc", masterList, membersOfTheBeatles);

	public static final List<Album> albums = List.of(master, garage, aLoveSupreme);
}
