package pageObject;

import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CalulatorPage {

	@AndroidFindBy(id = "digit_2")
	private List<MobileElement> digit2;
	@AndroidFindBy(id = "digit_3")
	private List<MobileElement> digit3;
	@AndroidFindBy(id = "digit_4")
	private List<MobileElement> digit4;
	@AndroidFindBy(id = "digit_5")
	private List<MobileElement> digit5;
	@AndroidFindBy(id = "digit_6")
	private List<MobileElement> digit6;
	@AndroidFindBy(id = "digit_7")
	private List<MobileElement> digit7;
	@AndroidFindBy(id = "digit_8")
	private List<MobileElement> digit8;
	@AndroidFindBy(id = "digit_9")
	private List<MobileElement> digit9;
	@AndroidFindBy(id = "digit_0")
	private List<MobileElement> digit0;
	public List<MobileElement> getDigit0() {
		return digit0;
	}

	public List<MobileElement> getDigit1() {
		return digit1;
	}

	@AndroidFindBy(id = "digit_1")
	private List<MobileElement> digit1;

	public List<MobileElement> getDigit9() {
		return digit9;
	}

	public void setDigit9(List<MobileElement> digit9) {
		this.digit9 = digit9;
	}

	public List<MobileElement> getDigit2() {
		return digit2;
	}

	public List<MobileElement> getDigit3() {
		return digit3;
	}

	public List<MobileElement> getDigit4() {
		return digit4;
	}

	public List<MobileElement> getDigit5() {
		return digit5;
	}

	public List<MobileElement> getDigit6() {
		return digit6;
	}

	public List<MobileElement> getDigit7() {
		return digit7;
	}

	public List<MobileElement> getDigit8() {
		return digit8;
	}

	public List<MobileElement> getOp_add() {
		return op_add;
	}

	public List<MobileElement> getoperatorEqual() {
		return operatorEqual;
	}

	@AndroidFindBy(id = "op_add")
	private List<MobileElement> op_add;
	@AndroidFindBy(id = "eq")
	private List<MobileElement> operatorEqual;
	
	
	@AndroidFindBy(id = "fun_sin")
	private List<MobileElement> fun_sin;
	
	@AndroidFindBy(id = "const_pi")
	private List<MobileElement> const_pi;
	
	@AndroidFindBy(id = "fun_log")
	private List<MobileElement> fun_log;
	
	@AndroidFindBy(id = "op_sqrt")
	private List<MobileElement> op_sqrt;
	
	@AndroidFindBy(id = "const_e")
	private List<MobileElement> const_e;

	public List<MobileElement> getFun_sin() {
		return fun_sin;
	}

	public List<MobileElement> getConst_pi() {
		return const_pi;
	}

	public List<MobileElement> getFun_log() {
		return fun_log;
	}

	public List<MobileElement> getOp_sqrt() {
		return op_sqrt;
	}

	public List<MobileElement> getConst_e() {
		return const_e;
	}
	
	@AndroidFindBy(id = "op_div")
	private List<MobileElement> op_div;

	public List<MobileElement> getOp_div() {
		return op_div;
	}
	
	@AndroidFindBy(id = "rparen")
	private List<MobileElement> rparen;

	public List<MobileElement> getRightParens() {
		return rparen;
	}
	
	@AndroidFindBy(id = "lparen")
	private List<MobileElement> lparen;

	public List<MobileElement> getLeftParens() {
		return lparen;
	}
	
	
	@AndroidFindBy(id = "result_final")
	private List<MobileElement> result_final;
	
	public List<MobileElement> getResult_final() {
		return result_final;
	}

	public List<MobileElement> getResult_preview() {
		return result_preview;
	}

	@AndroidFindBy(id = "result_preview")
	private List<MobileElement> result_preview;
	
	@AndroidFindBy(id = "op_pow")
	private List<MobileElement> op_pow;

	public List<MobileElement> getOp_pow() {
		return op_pow;
	}
	
	@AndroidFindBy(id = "del")
	private List<MobileElement> del;
	public List<MobileElement> getDel() {
		return del;
	}

	
}
