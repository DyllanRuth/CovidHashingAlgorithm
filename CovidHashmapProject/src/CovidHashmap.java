// Dyllan Ruth
import java.util.*;
import java.util.Map.Entry;
public class CovidHashmap {

	static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	static int partition(int[] array, int x, int y) {
		int pivot = array[y];
		int i = (x - 1);
		for (int j = x; j <= y - 1; j++) {
			if (array[j] < pivot) {
				i++;
				swap(array, i, j);
			}
		}
		swap(array, i + 1, y);
		return (i + 1);
	}

	static void quickSort(int[] array, int x, int y) {
		if (x < y) {
			int pi = partition(array, x, y);
			quickSort(array, x, pi - 1);
			quickSort(array, pi + 1, y);
		}
	}

	static void GetResults(int[] array, int size) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int key = 1;
		int count = 1;
		for (int i = 0; i < size; i++) {
			System.out.print(array[i] + " ");
			map.put(key, count);
			if (i < size - 1) {
				int distance = array[i + 1] - array[i];
				if (distance >= 6) {
					key++;
					count = 1;
				} else {
					count++;
				}
			}
		}
		System.out.println("\nThere are " + size + " amount of people!");
		System.out.println(map);
		// System.out.println(map.values());
		// System.out.println(map.keySet());
		int maxValueInMap = (Collections.max(map.values()));
		int minValueInMap = (Collections.min(map.values()));
		if(Collections.max(map.values()) == Collections.min(map.values())) {
			System.out.println("Both will be infected");
		} else {
			for (Entry<Integer, Integer> entry : map.entrySet()) {
				if (entry.getValue() == maxValueInMap) {
					System.out.println("Group " + entry.getKey() + " will be most infected!");
				}
			}
			for (Entry<Integer, Integer> entry : map.entrySet()) {
				if (entry.getValue() == minValueInMap) {
					System.out.println("Group " + entry.getKey() + " will be the least infected!");
				}
			}
		}
	}

	public static void main(String[] args) {
		int intArray[];
		int rand_int1;
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.println("What is the size of the array: ");
		int a = sc.nextInt();
		intArray = new int[a];
		for (int i = 0; i < a; i++) {
			rand_int1 = rand.nextInt(100);
			intArray[i] = rand_int1;
		}
		quickSort(intArray, 0, a - 1);
		System.out.println("Sorted array: ");
		GetResults(intArray, a);
		
	}
}
