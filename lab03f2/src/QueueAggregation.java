
public class QueueAggregation {
	public Array ar = new Array();
	int firstpos = 0;
	int lastpos = 0;
	
	public int enqueue (int x) {
		return ar.set(lastpos++, x);
	}
	
	public int dequeue(){
		return ar.get(firstpos++);
	}
}
