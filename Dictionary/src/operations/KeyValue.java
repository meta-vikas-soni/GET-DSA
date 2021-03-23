package operations;

public class KeyValue<K, T> {

	K key;
	T value;
	KeyValue<K, T> left;
	KeyValue<K, T> right;

	/**
	 * Initialize a key value
	 * 
	 * @param key
	 * @param value
	 */
	KeyValue(K key, T value) {
		this.key = key;
		this.value = value;
		this.left = null;
		this.right = null;
	}
}