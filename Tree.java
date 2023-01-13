package hw04;

public class Tree {
	private double payload;
	private Tree left;
	private Tree right;
	
	public Tree(double payload) {
		this.payload = payload;
		left = null;
		right = null;
	}
	
	public void insert(double nv) {
		Tree newTree = new Tree(nv);
		if (newTree.payload < this.payload) {
			if (left==null) {
				left= newTree;
			}
			else {
				left.insert(nv);
			}
		}
		else {
			if(right==null) {
				right = newTree;
			}
			else {
				right.insert(nv);
			}
		}
	}
	
	public double getPayload() {return payload;}
	
	public String toString() {
		String x = "";
		if (left!=null) {
			x+=(left.toString()+',');
		}
		x+=String.format("%.5f", payload);
		if (right!=null) {
			x+=(','+right.toString());
		}
		return x;
	}

}
