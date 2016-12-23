package com.kikurage.util;

import java.time.LocalDateTime;

public class KikurageTime {
	/*
	 * LocalDateTime time = LocalDateTime.now();	現在の日時取得します。
	 * getYear();  		年 (2015)
	 * getMonth(); 		月 (JANUARY)
	 * getDayOfMonth(); 日 (1)
	 * getDatOfWeek();	週 (MONDAY)
	 * getHour();		時 (0)
	 * getMinute();		分 (0)
	 * getSecond();		秒 (0)
	 */
	//getnow() 年/月/日(週) 時:分     をString型で出力します。(スペースあり)半角×3
	String[] month ={"1","2","3","4","5","6","7","8","9","10","11","12"};
	String[] week = {"月","火","水","木","金","土","日"};
	public String getnow(){
		LocalDateTime time = LocalDateTime.now();
		String now=null;
		now =time.getYear()+"/"+myDate(time.getMonth().toString())+"/"+time.getDayOfMonth()+
				"("+myDate(time.getDayOfWeek().toString())+")"+"   "+time.getHour()+":"+
				myDate(time.getMinute());
		return now;
	}
	public String myDate(int i){
		String ans=null;
		switch (i) {
		case 0:ans = "00";
		break;
		case 1:ans = "01";
		break;
		case 2:ans = "02";
		break;
		case 3:ans = "03";
		break;
		case 4:ans = "04";
		break;
		case 5:ans = "05";
		break;
		case 6:ans = "06";
		break;
		case 7:ans = "07";
		break;
		case 8:ans = "08";
		break;
		case 9:ans = "09";
		break;
		default:ans = String.valueOf(i);
			break;
		}
		return ans;
	}

	public String myDate(String s){
		String ans=null;
		switch (s) {
		/////month/////
		case "JANUARY":ans = month[0];//1
		break;
		case "FEBRUARY":ans = month[1];//2
		break;
		case "MARCH":ans = month[2];//3
		break;
		case "APRIL":ans = month[3];//4
		break;
		case "MAY":ans = month[4];//5
		break;
		case "JUNE":ans = month[5];//6
		break;
		case "JULY":ans = month[6];//7
		break;
		case "AUGUST":ans = month[7];//8
		break;
		case "SEPTEMBER":ans = month[8];//9
		break;
		case "OCTOBER":ans = month[9];//10
		break;
		case "NOVEMBER":ans = month[10];//11
		break;
		case "DECEMBER":ans = month[11];//12
		break;
		/////week/////
		case "MONDAY":ans = week[0];//月
		break;
		case "TUESDAY":	ans = week[1];//火
		break;
		case "WEDNESDAY":ans = week[2];//水
		break;
		case "THURSDAY":ans = week[3];//木
		break;
		case "FRIDAY":ans = week[4];//金
		break;
		case "SATURDAY":ans = week[5];//土
		break;
		case "SUNDAY":ans = week[6];//日
		break;
		default:
			break;
		}
		return ans;
	}

}
