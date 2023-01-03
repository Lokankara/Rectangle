/**
 * 
 */
package com.test.boyarsky.zoo;

/**
 * @author PPoliak
 *
 */
interface HasWhiskers {
	public int getNumberOfWhiskers();
}

abstract class HarborSeal implements HasTail, HasWhiskers {
}