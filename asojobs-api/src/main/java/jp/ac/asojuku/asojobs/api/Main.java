package jp.ac.asojuku.asojobs.api;

import java.util.ArrayList;
import java.util.List;

import jp.ac.asojuku.asojobs.beans.OrderDetail;

public class Main {
	public void sample(){
		
		//OrderDetail型の
		/*
		 * なぜArrayList＜OrderDetail＞型のオブジェクトを生成して、List<OrderDetail>型の変数にオブジェクトを保持しているかというと
		 * もしList<OrderDetail>所をArrayにすると、後で他のList型への仕様変更が起きたときに、Arrayだと対応できないから
		 * たとえば、ArrayListから LinkedListにしたい場合は、
		 * ---List<OrderDetail> list = new ArrayList<OrderDetail>();---------------------------
		 * List<OrderDetail> list = new LinkedList<OrderDetail>();//これは、できますけど、
		 * ArrayList<OrderDetail> list = new LinkedList<OrderDetail>();//NGです。
		 * 何故かというとjavaの仕様書を見るとListは、"Interface List<E>"この用になっています。
		 * ＜E＞は、ジェネリックス (Generics) というのは汎用的なクラスやメソッドを特定の型に対応づける機能のことです。
		 * ArrayLiｓｔは、仕様を見れば、わかりますが、インターファースのEを実装していることになっているので。
		 */
		List<OrderDetail> list = new ArrayList<OrderDetail>();
		
		//１件のデータを入れる場合
		OrderDetail order = new OrderDetail();
		order.setProductid("P0001");
		order.setProductname("オブジェクト指向入門書");
		list.add(order);
		
		
		//OrderDetail型のリスト
		List<OrderDetail> list2 = new ArrayList<OrderDetail>();
		//サンプル用のLISTを作成します。 input test date
		List<String> orderid = new ArrayList<String>();
		orderid.add("P001");
		orderid.add("P002");
		orderid.add("P003");
		List<String> ordername = new ArrayList<String>();
		ordername.add("オブジェクト指向入門書");
		ordername.add("PHP入門書");
		ordername.add("基礎英語書");
		//end of test date
		int i = 0;
		for(String str : orderid){
			OrderDetail order2 = new OrderDetail();
			order2.setProductid(str);
			//OrderDetail str = ordername.get(i);
			order2.setProductname(ordername.get(i));
			list2.add(order2);
			/*
			for(String st : ordername ){
				OrderDetail order2 = new OrderDetail();
				order2.setProductid(str);
				order2.setProductname(st);
				list2.add(order2);
			}
			*/
		}
		
	}
}
