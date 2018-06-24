package jp.ac.asojuku.asojobs.entity;

import java.io.Serializable;
import java.util.Date;


/*
 * 求人期間関連テーブル（エンティティ）
 * 
 * */
public class JobofferdDuration implements Serializable{
	
	//求人票コード
	public static  String    JOBOFFER_NO = "joboffer_no";
	//受付開始期間                  	              	
	public static  String    JOBOFFER_START =            "joboffer_start";
	//受付終了期間                  	              	
	public static  String    JOBOFFER_END =            	"joboffer_end";
	//企業訪問可否                  	              	
	public static  String    JOBOFFER_VISIT =            	"joboffer_visit";
	//学内説明会の有無                	              	
	public static  String    JOBOFFER_DES_SCHOOL =            	"joboffer_des_school";
	//学内説明会日程                 	              	
	public static  String    JOBOFFER_DES_DAY =            	"joboffer_des_day";
	//学内説明会他日程の有無             	              	
	public static  String    JOBOFFER_DES_DAY_OH =            	"joboffer_des_day_oh";
	//学内説明会実施場所               	              	
	public static  String    JOBOFFER_DES_LOC =            	"joboffer_des_loc";
	//学外説明会日程                 	              	
	public static   String   COM_EXPLAN_DAY =            	"com_explan_day";
	//学外説明会場所                               	
	public static  String    COM_EXPLAN_PLACE =            	"com_explan_place";
	//交通費支給額                  	              	
	public static  String    TRANS_EXP =            	"trans_exp";
	//学外説明会他日程の有無             	              	
	public static  String    COM_EXPLAN_DAY_OH = "com_explan_day_oh";
	//提出書類                    	              	
	public static  String    SUBMIT_DOCUMENT =            	"submit_document";
	//その他提出書類                 	              	
	public static  String    SUBMIT_DOCUMENT_ETC =            	"submit_document_etc";
	//選考方法                                  	
	public static  String    SELECTION_METHOD =            	"selection_method";
	//その他選考方法                 	              	
	public static  String    ELECTION_METHOD_ETC =            	"selection_method_etc";
	//当日携行品                   	              	
	public static  String    BAGGAGE =            	"baggage";
	//その他当日携行品                	              	
	public static  String    BAGGAGE_ETC =            	"baggage_etc";
	//採否決定日                   	              	
	public static  String    JOBOFFER_DECIDE_DAY =            	"joboffer_decide_day";
	//採否決定期間                  	              	
	public static  String    JOBOFFER_DECIDE_DURING =            	"joboffer_decide_during";
	
	private Joboffer joboffer_no;
	private Date joboffer_start;
	private Date joboffer_end;
	private Integer joboffer_visit;
	private Integer joboffer_des_school;
	private Date joboffer_des_day;
	private Date joboffer_des_day_oh;
	private String joboffer_des_loc;
	private Date com_explan_day;
	private String com_explan_place;
	private String trans_exp;
	private Date com_explan_day_oh;
	private String submit_document;
	private String submit_document_etc;
	private String selection_method;
	private String selection_method_etc;
	private String baggage;
	private String baggage_etc;
	private Date joboffer_decide_day;
	private Integer joboffer_decide_during;
	public Joboffer getJoboffer_no() {
		return joboffer_no;
	}
	public void setJoboffer_no(Joboffer joboffer_no) {
		this.joboffer_no = joboffer_no;
	}
	public Date getJoboffer_start() {
		return joboffer_start;
	}
	public void setJoboffer_start(Date joboffer_start) {
		this.joboffer_start = joboffer_start;
	}
	public Date getJoboffer_end() {
		return joboffer_end;
	}
	public void setJoboffer_end(Date joboffer_end) {
		this.joboffer_end = joboffer_end;
	}
	public Integer getJoboffer_visit() {
		return joboffer_visit;
	}
	public void setJoboffer_visit(Integer joboffer_visit) {
		this.joboffer_visit = joboffer_visit;
	}
	public Integer getJoboffer_des_school() {
		return joboffer_des_school;
	}
	public void setJoboffer_des_school(Integer joboffer_des_school) {
		this.joboffer_des_school = joboffer_des_school;
	}
	public Date getJoboffer_des_day() {
		return joboffer_des_day;
	}
	public void setJoboffer_des_day(Date joboffer_des_day) {
		this.joboffer_des_day = joboffer_des_day;
	}
	public Date getJoboffer_des_day_oh() {
		return joboffer_des_day_oh;
	}
	public void setJoboffer_des_day_oh(Date joboffer_des_day_oh) {
		this.joboffer_des_day_oh = joboffer_des_day_oh;
	}
	public String getJoboffer_des_loc() {
		return joboffer_des_loc;
	}
	public void setJoboffer_des_loc(String joboffer_des_loc) {
		this.joboffer_des_loc = joboffer_des_loc;
	}
	public Date getCom_explan_day() {
		return com_explan_day;
	}
	public void setCom_explan_day(Date com_explan_day) {
		this.com_explan_day = com_explan_day;
	}
	public String getCom_explan_place() {
		return com_explan_place;
	}
	public void setCom_explan_place(String com_explan_place) {
		this.com_explan_place = com_explan_place;
	}
	public String getTrans_exp() {
		return trans_exp;
	}
	public void setTrans_exp(String trans_exp) {
		this.trans_exp = trans_exp;
	}
	public Date getCom_explan_day_oh() {
		return com_explan_day_oh;
	}
	public void setCom_explan_day_oh(Date com_explan_day_oh) {
		this.com_explan_day_oh = com_explan_day_oh;
	}
	public String getSubmit_document() {
		return submit_document;
	}
	public void setSubmit_document(String submit_document) {
		this.submit_document = submit_document;
	}
	public String getSubmit_document_etc() {
		return submit_document_etc;
	}
	public void setSubmit_document_etc(String submit_document_etc) {
		this.submit_document_etc = submit_document_etc;
	}
	public String getSelection_method() {
		return selection_method;
	}
	public void setSelection_method(String selection_method) {
		this.selection_method = selection_method;
	}
	public String getSelection_method_etc() {
		return selection_method_etc;
	}
	public void setSelection_method_etc(String selection_method_etc) {
		this.selection_method_etc = selection_method_etc;
	}
	public String getBaggage() {
		return baggage;
	}
	public void setBaggage(String baggage) {
		this.baggage = baggage;
	}
	public String getBaggage_etc() {
		return baggage_etc;
	}
	public void setBaggage_etc(String baggage_etc) {
		this.baggage_etc = baggage_etc;
	}
	public Date getJoboffer_decide_day() {
		return joboffer_decide_day;
	}
	public void setJoboffer_decide_day(Date joboffer_decide_day) {
		this.joboffer_decide_day = joboffer_decide_day;
	}
	public Integer getJoboffer_decide_during() {
		return joboffer_decide_during;
	}
	public void setJoboffer_decide_during(Integer joboffer_decide_during) {
		this.joboffer_decide_during = joboffer_decide_during;
	}
}
