/**
 * 
 */
package com.homework.inherit;

/**
 * @author PPoliak
 *
 */
interface Factory<T> {
	T build();
}

interface AirFactory extends Factory<Air> {
	Air build();

	Air build(String name);

	Air build(String name, int price);
}

class AeroPlaneFactory implements AirFactory {

	public AeroPlaneFactory() {
		super();
	}

	@Override
	public AeroPlane build() {
		return new AeroPlane("AeroPlane");
	}

	@Override
	public AeroPlane build(String name) {
		return new AeroPlane(name);
	}

	@Override
	public AeroPlane build(String name, int price) {
		return new AeroPlane(name, price);
	}
}

class FighterFactory implements AirFactory {

	public FighterFactory() {
		super();
	}

	@Override
	public Fighter build() {
		return new Fighter("Fighter");
	}

	@Override
	public Fighter build(String name) {
		return new Fighter(name);
	}

	@Override
	public Fighter build(String name, int price) {
		return new Fighter(name, price);
	}
}

interface AutoFactory extends Factory<Wheel> {
	public Wheel build();

	public Wheel build(String name);

	public Wheel build(String name, int price);

	public Wheel build(int wheels, String name, int price);
}

