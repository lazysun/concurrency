package com.snippets;

public class Transpose {
    static String arr[] = {"x1","x2", "x3","x4","y1","y2", "y3","y4", "z1", "z2", "z3", "z4"};
	public static void main(String[] args) {
		    int length = arr.length;
		    int rowsize = 3;
	        int columnsize = length/rowsize; 
	        for (int i = 0 ; i < arr.length ; i++){
	            int whereTo = get(i, columnsize, rowsize);
	            while (whereTo<i){
	                whereTo = get (whereTo, columnsize, rowsize);
	            }
	            swap (arr,i,whereTo);
	        }
	        print();
	}

	public static void main3(String[] args) {
		getConvertedArray(arr);
		print();
	}
	
	private static void print() {
		System.out.println("");
		System.out.print(" { ");
		for(int k=0;k<arr.length;k++) {
			System.out.print(arr[k]);
			System.out.print(", ");
		}
		System.out.println(" } ");
	}
	
	static public int get(int i,  int columnsize , int rowsize) {
		int row = i/rowsize;
		int col = i%rowsize;
		return col*columnsize+row; // reverse the row and column
	 // 
	}
	
	private static int getWhereToIndex2 (int i , int columnsize, int rowsize){
	        return (i%rowsize)*columnsize + i/rowsize;
	}
	
	public static String [] getConvertedArray(String [] arr){
        int length = arr.length;
        int n = length/3;
        for (int i = 0 ; i < arr.length ; i++){
            int whereTo = getWhereToIndex(i, n);
            while (whereTo<i){
                whereTo = getWhereToIndex (whereTo, n);
            }
            swap (arr,i,whereTo);
        }
        return arr;
        
    }
    private static int getWhereToIndex (int currIndex , int n){
        return (currIndex%3)*n + currIndex/3;
    }
    private static void swap (String [] arr, int l, int r){
        String temp = arr[l];
        arr[l] = arr [r];
        arr[r] = temp;
    }
}
