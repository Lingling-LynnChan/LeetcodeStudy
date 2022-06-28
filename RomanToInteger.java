/*
https://leetcode.com/problems/roman-to-integer/submissions/
*/
class Solution {
	public int romanToInt(String s) {
		chars = s.toCharArray();
		return tool();
	}
	
	private char[] chars;
	private int index = 0;
	
	private int tool() {
		char ch;
		try {
			ch = chars[index];
		} catch (Exception e) {
			return 0;
		}
		int tch = 0;
		if (ch == 'M') {
			tch = 1000;
		} else if (ch == 'C') {
			try {
				char next = chars[index+1];
				index++;//假设向后移动
				if (next == 'M') {
					tch = 900;
				} else if (next == 'D') {
					tch = 400;
				}else{
					index--;
				}
			} catch (Exception ignored) {
			} finally {
				if (tch == 0) {
					tch = 100;
				}
			}
		} else if (ch == 'D') {
			tch=500;
		}else if (ch=='X'){
			try{
				char next=chars[index+1];
				index++;
				if(next=='C'){
					tch=90;
				} else if (next=='L') {
					tch=40;
				}else {
					index--;
				}
			}catch (Exception ignored){
			}finally {
				if(tch==0){
					tch=10;
				}
			}
		} else if (ch == 'L') {
			tch=50;
		} else if (ch == 'I') {
			try{
				char next=chars[index+1];
				index++;
				if(next=='X'){
					tch=9;
				} else if (next=='V') {
					tch=4;
				}else {
					index--;
				}
			}catch (Exception ignored){
			}finally {
				if(tch==0){
					tch=1;
				}
			}
		} else if (ch == 'V') {
			tch=5;
		}else{
			throw new RuntimeException("Error Input!");
		}
		index++;
		return tch + tool();
	}
}
