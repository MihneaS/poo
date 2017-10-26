
public class QueueInheritance extends Array {
	int firstpos = 0;
	int lastpos = 0;
	public int enqueue (int x) {
		if (lastpos < 10) {
			return set(lastpos++, x);
		}
		return ERROR;
	}
	
	public int dequeue(){
		if (firstpos != lastpos) {
			return get(firstpos++);
		}
}
