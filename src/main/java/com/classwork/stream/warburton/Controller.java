package com.classwork.stream.warburton;

import static java.util.stream.Collectors.toSet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Controller {

	public static int parallelArraySum(List<Album> albums) {
		 return albums.parallelStream()
		 .flatMap(Album::getTracks)
		 .mapToInt(Track::getLength)
		 .sum();
		}

	public static int addUp(Stream<Integer> numbers) {
		return numbers.reduce(0, Integer::sum);
	}

	public static List<String> getNamesAndOrigins(List<Artist> artists) {
		return artists.stream().flatMap(artist -> Stream.of(artist.getName(), artist.getNationality())).toList();
	}

	public static List<Album> getAlbumsWithAtMostThreeTracks(List<Album> albums) {
		return albums.stream().filter(album -> album.getTrackList().size() <= 3).collect(Collectors.toList());
	}

	public static long count(List<Artist> artists) {
		return artists.stream().flatMap(Artist::getMembers).count();
	}

	public Set<String> findLongTrack(List<Album> albums) {
		Set<String> trackNames = new HashSet<>();
		albums.stream().forEach(album -> {
			album.getTracks().filter(track -> track.getLength() > 60).map(track -> track.getName())
					.forEach(name -> trackNames.add(name));
		});
		return trackNames;
	}

	public static Set<String> findLongStreamTracks(List<Album> albums) {
		return albums.stream().flatMap(album -> album.getTracks()).filter(track -> track.getLength() > 60)
				.map(track -> track.getName()).collect(toSet());
	}

	public static AtomicInteger countMusicians(Album album) {
		AtomicInteger count = new AtomicInteger();
		album.getMusicians().forEach(musician -> count.incrementAndGet());
		return count;
	}

	public static long countLowerCase(String text) {
		return text.chars().filter(c -> c > 96 && c < 123).count();
	}

	public static Optional<String> getLargestString(List<String> list) {
		return list.stream().max(Comparator.comparingLong(Controller::countLowerCase));
	}

	public static void printTrackLengthStatistics(Album album) {
		IntSummaryStatistics stats = album.getTracks().mapToInt(track -> track.getLength()).summaryStatistics();
		System.out.printf("Max: %d, Min: %d, Ave: %f, Sum: %d", stats.getMax(), stats.getMin(), stats.getAverage(),
				stats.getSum());

	}

	public static <T> List<T> filter(Stream<T> stream, Predicate<? super T> predicate) {
		return stream.reduce(new ArrayList<>(), (list, element) -> {
			if (predicate.test(element)) {
				list.add(element);
			}
			return list;
		}, addAll());
	}

	private static <T> BinaryOperator<ArrayList<T>> addAll() {
		return (a, b) -> {
			a.addAll(b);
			return a;
		};
	}

	public static <T, R> List<R> map(Stream<T> stream, Function<T, R> mapper) {
		return stream.reduce(new ArrayList<>(), (acc, item) -> {
			acc.add(mapper.apply(item));
			return acc;
		}, addAll());
	}
}
