package jp.ac.asojuku.asojobs.entity;


public class Company {
	
	public static String COMPANY_TABLE        = "company";
	
	public static String COMPANY_NO   	       = "company_no";   //企業コード
	
	public static String COMPANY_NAME 	       = "company_name"; //企業名
	
	public static String COMPANY_KANA 	       = "company_kana"; //企業名（カナ）
	
	public static String COMPANY_BRANCH 	   = "company_branch";//支店名
	
	public static String COMPANY_BRANCH_KANA = "company_branch_kana";//支店名
	
	public static String COMPANY_CAPITAL   	   = "company_capital";//資本金
	
	public static String COMPANY_SALES     	   = "company_sales";//売上高
	
	public static String COMPANY_DAY      	   = "company_day"; //設立日
	
	public static String COMPANY_SUM       	   = "company_sum";//総従業員数
	
	public static String COMPANY_MAN       	   = "company_man";//男性従業員数
	
	public static String COMPANY_WOMAN     	   = "company_woman";//女性従業員数
	
	public static String COMPANY_ZIPCODE   	   = "company_zipcode";//郵便番号
	
	public static String COMPANY_PREFECTURES       = "company_prefectures";//都道府県
	
	public static String COMPANY_ADDRESS		       = "company_address";//所在地
	
	public static String COMPANY_BUSINESS	       = "company_business";//事業内容
	
	public static String COMPANY_MAIL   	       = "company_mail";//メールアドレス
	
	public static String COMPANY_TEL   		       = "company_tel";//電話番号
	
	public static String COMPANY_FAX   		       = "company_fax";//メールアドレス
	
	public static String COMPANY_URL   		       = "company_url";//URL
	
	public static String COMPANY_STOCK 		       = "company_stock";//株式
	
	
	//企業コード
	private Integer company_no;
	//企業名
	private String company_name;
	//企業名（カナ）
	private String company_kana;
	//支店名
	private String company_branch;
	//支店名カナ
	private String company_branch_kana;
	//資本金
	private Integer company_capital;
	//売上高
	private Integer company_sales;
	//設立日
	private String company_day;
	//総従業員数
	private Integer company_sum;
	//男性従業員数
	private Integer company_man;
	//女性従業員数
	private Integer company_woman;
	//郵便番号
	private String company_zipcode;
	//都道府県
	private String company_prefectures;
	//所在地
	private String company_address;
	//産業名
	private  Indstry indstry;
	//事業内容
	private String company_business;
	//メールアドレス
	private String company_mail;
	//電話番号
	private String company_tel;
	//FAX
	private String company_fax;
	//URL
	private String company_url;
	//株式上場
	private String company_stock;
	
	public Integer getCompany_no() {
		return company_no;
	}
	public void setCompany_no(Integer company_no) {
		this.company_no = company_no;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getCompany_kana() {
		return company_kana;
	}
	public void setCompany_kana(String company_kana) {
		this.company_kana = company_kana;
	}
	public String getCompany_branch() {
		return company_branch;
	}
	public void setCompany_branch(String company_branch) {
		this.company_branch = company_branch;
	}
	public String getCompany_branch_kana() {
		return company_branch_kana;
	}
	public void setCompany_branch_kana(String company_branch_kana) {
		this.company_branch_kana = company_branch_kana;
	}
	public Integer getCompany_capital() {
		return company_capital;
	}
	public void setCompany_capital(Integer company_capital) {
		this.company_capital = company_capital;
	}
	public Integer getCompany_sales() {
		return company_sales;
	}
	public void setCompany_sales(Integer company_sales) {
		this.company_sales = company_sales;
	}
	public String getCompany_day() {
		return company_day;
	}
	public void setCompany_day(String company_day) {
		this.company_day = company_day;
	}
	public Integer getCompany_sum() {
		return company_sum;
	}
	public void setCompany_sum(Integer company_sum) {
		this.company_sum = company_sum;
	}
	public Integer getCompany_man() {
		return company_man;
	}
	public void setCompany_man(Integer company_man) {
		this.company_man = company_man;
	}
	public Integer getCompany_woman() {
		return company_woman;
	}
	public void setCompany_woman(Integer company_woman) {
		this.company_woman = company_woman;
	}
	public String getCompany_zipcode() {
		return company_zipcode;
	}
	public void setCompany_zipcode(String company_zipcode) {
		this.company_zipcode = company_zipcode;
	}
	public String getCompany_prefectures() {
		return company_prefectures;
	}
	public void setCompany_prefectures(String company_prefectures) {
		this.company_prefectures = company_prefectures;
	}
	public String getCompany_address() {
		return company_address;
	}
	public void setCompany_address(String company_address) {
		this.company_address = company_address;
	}
	public Indstry getIndstry() {
		return indstry;
	}
	public void setIndstry(Indstry indstry) {
		this.indstry = indstry;
	}
	public String getCompany_business() {
		return company_business;
	}
	public void setCompany_business(String company_business) {
		this.company_business = company_business;
	}
	public String getCompany_mail() {
		return company_mail;
	}
	public void setCompany_mail(String company_mail) {
		this.company_mail = company_mail;
	}
	public String getCompany_tel() {
		return company_tel;
	}
	public void setCompany_tel(String company_tel) {
		this.company_tel = company_tel;
	}
	public String getCompany_fax() {
		return company_fax;
	}
	public void setCompany_fax(String company_fax) {
		this.company_fax = company_fax;
	}
	public String getCompany_url() {
		return company_url;
	}
	public void setCompany_url(String company_url) {
		this.company_url = company_url;
	}
	public String getCompany_stock() {
		return company_stock;
	}
	public void setCompany_stock(String company_stock) {
		this.company_stock = company_stock;
	}
	
	
}
