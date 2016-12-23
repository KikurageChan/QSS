package com.kikurage.util;

public final class KikurageTextHtml {
	private final String BR = System.getProperty("line.separator");
	private static KikurageTextHtml kikurageTextHtml;

	private KikurageTextHtml(){

	}
	//インスタンス生成用のメソッドです。
	public static KikurageTextHtml getInstance(){
		if(kikurageTextHtml == null){
			kikurageTextHtml = new KikurageTextHtml();
		}
		return kikurageTextHtml;
	}

	//引数で渡した文字列に改行があるかどうか調べます。
	public boolean brCheck(String text){
		if(text.contains(BR)){
			return true;
		}
		return false;
	}

	//引数で渡した文字列に改行があった場合その位置を<br>に置き換えます。
	public String brChange(String text){
		return text.replace(BR,"<br>");
	}

	//引数で渡した文字にタブがあるかどうか調べます。
	public boolean tabCheck(String text){
		if(text.contains("\t")){
			return true;
		}
		return false;
	}

	//引数で渡した文字列にタブがあった場合その位置を &nbsp; ×4 に置き換えます。
	public String tabChange(String text){
		return text.replace("\t","&nbsp;&nbsp;&nbsp;&nbsp;");
	}

	//引数で渡した文字に" "または"　"があるかどうか調べます。
	public boolean spaceCheck(String text){
		char[] c1={'\u0020'};
		char[] c2={'\u2000'};
		String s1 = new String(c1);
		String s2 = new String(c2);
		if(text.contains(s1)||text.contains(" ")||text.contains(s2)||text.contains("　")){
			return true;
		}
		return false;
	}

	//引数で渡した文字列に" "があった場合その位置を &nbsp; に置き換えます。
	public String spaceChange(String text){ 
		char[] c1={'\u0020'};
		char[] c2={'\u2000'};
		String s1 = new String(c1);
		String s2 = new String(c2);
		text = text.replace(s1,"&nbsp;");
		text = text.replace(s2,"&nbsp;");
		return text;
	}


	//引数で渡した文字列に<p>のようなスクリプトがあった場合それを表示記号に変えます。
	public String scriptChange(String text){
		text = text.replace("<","&lt;");
		text = text.replace(">","&gt;");
		return text;
	}

	//上記メソッドを1度に実行します。
	public String htmlAll(String text){
		text = scriptChange(text);
		text = brChange(text);
		text = tabChange(text);
		text = spaceChange(text);
		return text;
	}

	//仮引数のname最低2文字　9文字までの文字列の場合trueを返します。 ただし、木耳という名前はNG
	public boolean nameCheck(String name){
		if(name.equals("木耳ちゃん0817")||name.equals("きくらげ0817")){
			return true;
		}else if(name.contains("木耳")){
				return false;
		}else if(name.matches("[\\s　]*k[\\s　]*i[\\s　]*k[\\s　]*u[\\s　]*r[\\s　]*a[\\s　]*g[\\s　]*e")||
				name.matches("[\\s　]*木[\\s　]*耳[\\s　]*ち[\\s　]*ゃ[\\s　]*ん")||
				name.matches("[\\s　]*き[\\s　]*く[\\s　]*ら[\\s　]*げ[\\s　]*ち[\\s　]*ゃ[\\s　]*ん")||
				name.matches("[\\s　]*キ[\\s　]*ク[\\s　]*ラ[\\s　]*ゲ[\\s　]*")||
				name.matches("[\\s　]*キ[\\s　]*ク[\\s　]*ラ[\\s　]*ゲ[\\s　]*ち[\\s　]*ゃ[\\s　]*ん[\\s　]*")||
				name.matches("[\\s　]*き[\\s　]*み[\\s　]*み[\\s　]*")||
				name.matches("[\\s　]*こ[\\s　]*み[\\s　]*み[\\s　]*")){
			return false;
		}
		if(name.matches("...*")&&name.length() < 10){
			return true;
		}
		return false;
	}
	//特殊木耳文字を通常に戻します。
	public String toKikurage(String name){
		if(name.equals("木耳ちゃん0817")) name = "木耳ちゃん";
		if(name.equals("きくらげ0817")) name = "きくらげ";
		return name;
	}

	//仮引数のtextが "" 長さ0 null 改行や空白のみ の場合trueを返します。
	public boolean isEmpty(String text){
		if(text == null || text.length()==0 || text.equals("") || text.matches("\\s+") || text.matches("　*") || text.matches("[\\s　]*")){
			return true;
		}
		return false;
	}

	//以下のパスワードが正しいかチェックします。(大文字でも小文字に変換されて判定されます。全角でも可能です。)
	public boolean comClearAll(String s){
		if(s.toLowerCase().equals("clear-all-0817") || s.equals("cぇあr−あっl−０８１７")){
			return true;
		}
		return false;
	}

	//以下の-で文字列を区切ります。
	public int comClearIndex(String s){
		String[] sa = s.split("-");
		return Integer.parseInt(sa[1]);
	}


	//BRのgetterです。
	public String getBR() {
		return BR;
	}
}
