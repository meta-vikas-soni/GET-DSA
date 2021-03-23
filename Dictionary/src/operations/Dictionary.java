package operations;

public interface Dictionary<K extends Comparable<K>,T> {
	
	public void add(K key,T value);
	
	public boolean delete(K key);
	
	public T get(K key);
	
	public List<KeyValue<K,T>> sortAccordingToKeys(KeyValue<Integer, String> root);
	
	public List<KeyValue<K,T>> sortCondition(K key1,K key2);
}