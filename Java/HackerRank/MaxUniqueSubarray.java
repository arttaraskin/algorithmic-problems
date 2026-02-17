import java.util.*;
public class MaxUniqueSubarray {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Deque<Integer> deque = new ArrayDeque<>();
		int n = in.nextInt();
		int m = in.nextInt();

		// initialize
		for(int i = 0; i < m; i++){
			deque.add(in.nextInt());
		}
		Set<Integer> set = new HashSet<>(m);
		set.addAll(deque);
		int maxUnique = set.size();          
		
		for (int i = 0; i < n - m; i++) {
			int num = in.nextInt();
			
			int head = deque.pollFirst();
			if (!deque.contains(head)) {
				set.remove(head);
			}
			
			deque.offerLast(num);
			set.add(num);
			maxUnique = Math.max(maxUnique, set.size());
			if (maxUnique == m) {
				break; // already maxUnique value
			}
		}
		
		System.out.println(maxUnique);
	}
}
