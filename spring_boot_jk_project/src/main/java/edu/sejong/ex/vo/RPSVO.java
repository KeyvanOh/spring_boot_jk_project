package edu.sejong.ex.vo;
import consts.Const;
import lombok.Getter;
//@Setter
@Getter
//@NoArgsConstructor
//@AllArgsConstructor
public class RPSVO {
	private String rps1;
	private String rps2;
	private String result;
	public RPSVO(String rps1) {
		this.rps1 = rps1;
		this.rps2 = Const.rpsList[(int) (Math.random() * 3.)];
		if (this.rps1.equals(this.rps2)) {
			this.result = "TIE";
		} else if ((this.rps1.equals(Const.rpsList[0]) && this.rps2.equals(Const.rpsList[2]))
				|| (this.rps1.equals(Const.rpsList[1]) && this.rps2.equals(Const.rpsList[0]))
				|| (this.rps1.equals(Const.rpsList[2]) && this.rps2.equals(Const.rpsList[1]))) {
			this.result = "WIN";
		} else {
			this.result = "LOSE";
		}
	}
}