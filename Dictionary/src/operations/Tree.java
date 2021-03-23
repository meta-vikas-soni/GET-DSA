package operations;

public class Tree<K extends Comparable<K>, T> {

	KeyValue<K, T> root;

	Tree() {
		this.root = null;
	}

	/**
	 * Add a key value to the tree
	 * 
	 * @param root
	 * @param data
	 */
	public void add(KeyValue<K, T> root, KeyValue<K, T> data) {

		if (root == null) {
			this.root = data;
			return;
		}
		int keyCompare = data.key.compareTo(root.key);
		if (keyCompare < 0) {
			if (root.left == null) {
				root.left = data;
			} else {
				add(root.left, data);
			}
		} else if (keyCompare > 0) {
			if (root.right == null) {
				root.right = data;
			} else {
				add(root.right, data);
			}
		}
	}
}