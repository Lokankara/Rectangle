package com.classwork.stream.warburton;

import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public final class Artist {

	private String name;
	private List<Artist> members;
	private String nationality;

	public Artist(String name, String nationality) {
		this(name, Collections.emptyList(), nationality);
	}

	public Artist(String name, List<Artist> members, String nationality) {
		Objects.requireNonNull(name);
		Objects.requireNonNull(members);
		Objects.requireNonNull(nationality);
		this.name = name;
		this.members = new ArrayList<>(members);
		this.nationality = nationality;
	}

	public String getName() {
		return name;
	}

	public Stream<Artist> getMembers() {
		return members.stream();
	}

	public List<Artist> getAllMembers() {
		return unmodifiableList(members);
	}

	public String getNationality() {
		return nationality;
	}

	public boolean isSolo() {
		return members.isEmpty();
	}

	public boolean isFrom(String nationality) {
		return this.nationality.equals(nationality);
	}

	@Override
	public String toString() {
		return getName();
	}

	public Artist copy() {
		List<Artist> members = getMembers().map(Artist::copy).toList();
		return new Artist(name, members, nationality);
	}

}

class Track {
	int length;
	String name;

	public int getLength() {
		return length;
	}

	public String getName() {
		return name;
	}

	public Track copy() {
		return new Track(name, length);
	}

	public Track(String name, int length) {
		super();
		this.length = length;
		this.name = name;
	}
}

class Album {
	private String name;
	private List<Track> tracks;
	private List<Artist> musicians;

	public Album(String name, List<Track> tracks, List<Artist> musicians) {
		Objects.requireNonNull(name);
		Objects.requireNonNull(tracks);
		Objects.requireNonNull(musicians);

		this.name = name;
		this.tracks = new ArrayList<>(tracks);
		this.musicians = new ArrayList<>(musicians);
	}

	public String getName() {
		return name;
	}

	public Stream<Track> getTracks() {
		return tracks.stream();
	}

	public List<Track> getTrackList() {
		return unmodifiableList(tracks);
	}

	public Stream<Artist> getMusicians() {
		return musicians.stream();
	}

	public List<Artist> getMusicianList() {
		return unmodifiableList(musicians);
	}

	public Artist getMainMusician() {
		return musicians.get(0);
	}

	public Album copy() {
		List<Track> tracks = getTracks().map(Track::copy).collect(toList());
		List<Artist> musicians = getMusicians().map(Artist::copy).collect(toList());
		return new Album(name, tracks, musicians);
	}
}
class Artists {
	private List<Artist> artists;

	public Artists(List<Artist> artists) {
		this.artists = artists;
	}

	public Optional<Artist> getArtist(int index) {
		if (index < 0 || index >= artists.size()) {
			return Optional.empty();
		}
		return Optional.of(artists.get(index));
	}

	public String getArtistName(int index) {
		return getArtist(index).map(Artist::getName).orElse("unknown");
	}
}