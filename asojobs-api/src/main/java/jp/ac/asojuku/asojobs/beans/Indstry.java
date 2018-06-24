package jp.ac.asojuku.asojobs.beans;

/*
 * 職種テーブル
 * */
public class Indstry {
	public static String INDSTRY_TBL_NAME = "indstry";
	public static String INDSTRY_TBL_INDSTRYNO = "indstry_no";
	public static String INDStRY_TBL_INDSTRYNAME = "indstry_name";
	
	//職種コード
	private Integer indstry_no;
	//職種名
	private String  indstry_name;
	
	
	public Integer getIndstry_no() {
		return indstry_no;
	}
	public void setIndstry_no(Integer indstry_no) {
		this.indstry_no = indstry_no;
	}
	public String getIndstry_name() {
		return indstry_name;
	}
	public void setIndstry_name(String indstry_name) {
		this.indstry_name = indstry_name;
	}
	
	
}
