//package operations;
//
//import java.util.Iterator;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//
//public class DictionaryImplement implements Dictonary<Integer, String> {
//
//	public static Tree<Integer, String> dictTree = new Tree<Integer, String>();
//
//	/**
//	 * Initialize dictonary by taking initial key value from JSON string
//	 * 
//	 * @param inputValue
//	 * @throws JSONException
//	 */
//	public DictionaryImplement(String inputValue) throws JSONException {
//		if (inputValue == null) {
//			throw new NullPointerException();
//		}
//		try {
//			JSONObject jsonObject = new JSONObject(inputValue);
//			JSONArray keyValueArray = convertArray(jsonObject);
//
//			for (int index = 0; index < keyValueArray.length(); index++) {
//				String value = jsonObject.getString(String
//						.valueOf(keyValueArray.get(index)));
//				Integer key = Integer.parseInt(String.valueOf(keyValueArray
//						.get(index)));
//
//				add(key, value);
//			}
//		} catch (JSONException exception) {
//
//		}
//	}
//
//	/**
//	 * Convert JSON string into JSON array
//	 * 
//	 * @param jsonObject
//	 * @return JSONArray
//	 */
//	public JSONArray convertArray(JSONObject jsonObject) {
//		JSONArray keyValueArray = new JSONArray();
//
//		@SuppressWarnings("unchecked")
//		Iterator<String> keys = jsonObject.keys();
//		while (keys.hasNext()) {
//			keyValueArray.put(keys.next());
//		}
//		return keyValueArray;
//	}
//
//	/**
//	 * Adds Key Value pair to dictonary
//	 */
//	public void add(Integer key, String value) {
//		KeyValue<Integer, String> node = new KeyValue<Integer, String>(key,
//				value);
//		dictTree.add(dictTree.root, node);
//	}
//
//	/**
//	 * Find minimum value from the given node
//	 * 
//	 * @param root
//	 * @return minimum value
//	 */
//	int minValue(KeyValue<Integer, String> root) {
//		int min = root.key;
//		while (root.left != null) {
//			min = root.left.key;
//			root = root.left;
//		}
//		return min;
//	}
//
//	/**
//	 * delete key value pair from the tree structure representing dictonary
//	 * 
//	 * @param root
//	 * @param key
//	 * @return
//	 */
//	public KeyValue<Integer, String> deleteValue(
//			KeyValue<Integer, String> root, Integer key) {
//		if (root == null) {
//			return root;
//		}
//		if (key < root.key) {
//			root.left = deleteValue(root.left, key);
//		} else if (key > root.key) {
//			root.right = deleteValue(root.right, key);
//		} else {
//			if (root.left == null) {
//				return root.right;
//			} else if (root.right == null) {
//				return root.left;
//			}
//			root.key = minValue(root.right);
//
//			root.right = deleteValue(root.right, root.key);
//		}
//		return root;
//	}
//
//	/**
//	 * Get the value of the given key from the tree structure
//	 * 
//	 * @param root
//	 * @param key
//	 * @return
//	 */
//	public String getValue(KeyValue<Integer, String> root, Integer key) {
//		if (root == null) {
//			throw new NullPointerException();
//		}
//		if (root.key == key) {
//			return root.value;
//		}
//		if (key < root.key) {
//			return getValue(root.left, key);
//		} else {
//			return getValue(root.right, key);
//		}
//	}
//
//	/**
//	 * Get the value of the given key from dictonary
//	 */
//	public String get(Integer key) {
//		return getValue(dictTree.root, key);
//	}
//
//	/**
//	 * Prints all the key value pair of the dictonary
//	 * 
//	 * @param root
//	 */
//	public void printDictonary(KeyValue<Integer, String> root) {
//		if (root != null) {
//			printDictonary(root.left);
//			System.out.println(root.key + "->" + root.value);
//			printDictonary(root.right);
//		}
//	}
//
//	/**
//	 * Delete the key value pair from the dictonary
//	 */
//	public boolean delete(Integer key) {
//		KeyValue<Integer, String> deletedValue = deleteValue(dictTree.root, key);
//		if (deletedValue.key == key) {
//			return true;
//		} else {
//			return false;
//		}
//	}
//
//	/**
//	 * traverse the three where key value pairs are stored and add them to a
//	 * list
//	 * 
//	 * @param root
//	 * @param list
//	 */
//	public void inorder(KeyValue<Integer, String> root,
//			ArrayList<KeyValue<Integer, String>> list) {
//		if (root == null) {
//			return;
//		}
//		inorder(root.left, list);
//		list.add(root);
//		inorder(root.right, list);
//
//	}
//
//	/**
//	 * traverse the key value and add them to the list between given range
//	 * 
//	 * @param root
//	 * @param list
//	 * @param key1
//	 *            ,lower bound
//	 * @param key2
//	 *            , upper bound
//	 */
//	public void inorderTraverseForSortByCondition(
//			KeyValue<Integer, String> root,
//			ArrayList<KeyValue<Integer, String>> list, Integer key1,
//			Integer key2) {
//		if (root == null) {
//			return;
//		}
//		inorderTraverseForSortByCondition(root.left, list, key1, key2);
//		if (root.key >= key1 && root.key <= key2) {
//			list.add(root);
//		}
//		inorderTraverseForSortByCondition(root.right, list, key1, key2);
//	}
//
//	/**
//	 * Sort key value according to keys and return sorted list of key value pair
//	 * 
//	 * @param root
//	 * @return sortedList
//	 */
//	public ArrayList<KeyValue<Integer, String>> sortAccordingToKeys(
//			KeyValue<Integer, String> root) {
//		if (root == null) {
//			throw new NullPointerException();
//		}
//		ArrayList<KeyValue<Integer, String>> sortedList = new ArrayList<KeyValue<Integer, String>>();
//		inorder(root, sortedList);
//
//		return sortedList;
//	}
//
//	/**
//	 * Sort key value pair and return key value pair in given range
//	 * 
//	 * @param key1
//	 * @param key2
//	 * @return list
//	 */
//	public ArrayList<KeyValue<Integer, String>> sortCondition(Integer key1,
//			Integer key2) {
//		if (key1 > key2 || key1 == null || key2 == null) {
//			throw new NullPointerException();
//		}
//		ArrayList<KeyValue<Integer, String>> list = new ArrayList<KeyValue<Integer, String>>();
//		inorderTraverseForSortByCondition(dictTree.root, list, key1, key2);
//		return list;
//	}
//
//	public static void main(String args[]) throws JSONException {
//		String testValue = "{\"1\":\"java\",\"2\":\"JS\",\"3\":\"Python\"}";
//		DictonaryImplement test = new DictonaryImplement(testValue);
//		System.out.println(test.delete(2));
//		test.printDictonary(dictTree.root);
//	}
//}