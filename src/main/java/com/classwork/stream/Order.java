package com.classwork.stream;

import java.util.List;
import java.util.function.ToLongFunction;

public abstract class Order {

	protected final List<Album> albums;

	public Order(List<Album> albums) {
		this.albums = albums;
	}

	public abstract long countRunningTime();

	public abstract long countMusicians();

	public abstract long countTracks();

}

class OrderStream extends Order {

	public OrderStream(List<Album> albums) {
		super(albums);
	}

	@Override
	public long countRunningTime() {
		return countFeature(albums, (album -> countFeature(album.getTrackList(), track -> track.getLength())));
		
//		return albums.stream().mapToLong(album -> album.getTracks().mapToLong(track -> track.getLength()).sum()).sum();

	}

	@Override
	public long countMusicians() {
		return countFeature(albums, album -> album.getMusicians().count());
	}

	@Override
	public long countTracks() {
		return countFeature(albums, album -> album.getTracks().count());
	}

	public <T> long countFeature(List<T> albums, ToLongFunction<T> function) {
		return albums.stream().mapToLong(function).sum();
	}
}