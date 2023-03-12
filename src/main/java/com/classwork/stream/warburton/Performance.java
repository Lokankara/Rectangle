package com.classwork.stream.warburton;

import java.util.stream.Stream;

public interface Performance {
	public String getName();

	public Stream<Artist> getMusicians();

	default Stream<Artist> getAllMusicians() {
		return getMusicians().flatMap(artist -> {
			return Stream.concat(Stream.of(artist), artist.getMembers());
		});
	}
}