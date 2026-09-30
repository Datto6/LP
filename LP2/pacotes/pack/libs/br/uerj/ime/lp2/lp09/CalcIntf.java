package br.uerj.ime.lp2.lp09;
import com.start.excp.*;
public interface CalcIntf {
	public  int soma(int a,int b);
	public  int sub(int a,int b);
	public  double mult(double a,double b);
	public  double div(double a,double b)throws Div0ex;
}
