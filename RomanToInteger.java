/*
https://leetcode.com/problems/roman-to-integer/submissions/
思路:
从大到小扫描,列举特殊情况,利用下标指针扫描字符串
利用异常机制保证结果正确性
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
			ch = chars[index];//如果抛出异常,说明指针越界,捕获异常并结束扫描
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
					index--;//如果运行到此,说明非特殊情况,回退指针
				}
			} catch (Exception ignored) {
			} finally {
				if (tch == 0) {
					tch = 100;//在此赋值,防止异常导致的无法获取结果
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
