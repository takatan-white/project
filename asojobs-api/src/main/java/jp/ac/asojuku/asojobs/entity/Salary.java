package jp.ac.asojuku.asojobs.entity;

import java.io.Serializable;

/*
 * 賃金テーブル(Entity)
 * */
public class Salary implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	//１年コース初任給
	public static String ONE_SALARY        ="one_salary";
	//2年コース初任給
	public static String TWO_SALARY        ="two_salary";
	//3年コース初任給
	public static String THREE_SALARY      ="three_salary";
	//4年コース初任給
	public static String FOUR_SALARY       ="four_salary";
	//賞与（回/年）
	public static String BONUS_FREQ        ="bonus_freq";
	//賞与（ヶ月/年）
	public static String BONUS_MONTH       ="bonus_month";
	//昇給（回/年
	public static String PAY_RAISE         ="pay_raise";
	//昇給最低額
	public static String MINIMUM           ="minimum";
	//昇給最高額
	public static String MAXIMUM           ="maximum";
	//昇給（％）
	public static String PAY_RAISE_INDEX   ="pay_raise_index";
	//その他
	public static String ETCETERA          ="etcetera";
	
	private Joboffer joboffer;
	private Integer one_salary;
	private Integer two_salary;
	private Integer three_salary;
	private Integer four_salary;
	private Integer bonus_freq;
	private Integer bonus_month;
	private Integer pay_raise;
	private Integer minimum;
	private Integer maximum;
	private Integer pay_raise_index;
	private String etcetera;
	public Joboffer getJoboffer() {
		return joboffer;
	}
	public void setJoboffer_no(Joboffer joboffer) {
		this.joboffer = joboffer;
	}
	public Integer getOne_salary() {
		return one_salary;
	}
	public void setOne_salary(Integer one_salary) {
		this.one_salary = one_salary;
	}
	public Integer getTwo_salary() {
		return two_salary;
	}
	public void setTwo_salary(Integer two_salary) {
		this.two_salary = two_salary;
	}
	public Integer getThree_salary() {
		return three_salary;
	}
	public void setThree_salary(Integer three_salary) {
		this.three_salary = three_salary;
	}
	public Integer getFour_salary() {
		return four_salary;
	}
	public void setFour_salary(Integer four_salary) {
		this.four_salary = four_salary;
	}
	public Integer getBonus_freq() {
		return bonus_freq;
	}
	public void setBonus_freq(Integer bonus_freq) {
		this.bonus_freq = bonus_freq;
	}
	public Integer getBonus_month() {
		return bonus_month;
	}
	public void setBonus_month(Integer bonus_month) {
		this.bonus_month = bonus_month;
	}
	public Integer getPay_raise() {
		return pay_raise;
	}
	public void setPay_raise(Integer pay_raise) {
		this.pay_raise = pay_raise;
	}
	public Integer getMinimum() {
		return minimum;
	}
	public void setMinimum(Integer minimum) {
		this.minimum = minimum;
	}
	public Integer getMaximum() {
		return maximum;
	}
	public void setMaximum(Integer maximum) {
		this.maximum = maximum;
	}
	public Integer getPay_raise_index() {
		return pay_raise_index;
	}
	public void setPay_raise_index(Integer pay_raise_index) {
		this.pay_raise_index = pay_raise_index;
	}
	public String getEtcetera() {
		return etcetera;
	}
	public void setEtcetera(String etcetera) {
		this.etcetera = etcetera;
	}
	
}
