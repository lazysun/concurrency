package com.snippets;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class OverInterval {

	static Interval intervals [] = { new Interval(1,3), new Interval(2,4), new Interval(5,7), new Interval(6, 8)};  
	public static void main(String[] args) {
		TreeSet<Interval> intervalTree = new TreeSet<Interval>(new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.min.compareTo(o2.min);
			}
		});
		for(Interval interval : intervals ) {
			Interval floor = intervalTree.floor(new Interval(interval.min, Integer.MAX_VALUE));
			if(interval.min < floor.max && floor.max   < interval.max) {
				
			}
			Interval ceil = intervalTree.floor(new Interval(interval.max, Integer.MAX_VALUE));
			if(floor != null) {
				SortedSet<Interval>  interv = intervalTree.subSet(floor, true, ceil, true);
				if(interv.isEmpty()) {
					intervalTree.add(interval);
					continue;
				}
				int min = interv.first().min;
				int max = interv.last().max;
				min = Math.min(min, interval.min);
				max = Math.max(max, interval.max);
				Interval fInterval = new Interval(min, max);
				intervalTree.removeAll(interv);
				intervalTree.add(fInterval);
			}else {
				intervalTree.add(interval);
			}
		}
		for(Interval tmp : intervalTree) {
			System.out.println("Interval : " + tmp.min + ", " + tmp.max);
		}
	}
    static class Interval {

		Integer min;
    	Integer max;

    	public Interval(int min, int max) {
			super();
			this.min = min;
			this.max = max;
		}

		public Integer getMin() {
			return min;
		}

		public void setMin(int min) {
			this.min = min;
		}

		public Integer getMax() {
			return max;
		}

		public void setMax(int max) {
			this.max = max;
		}
    }
}
