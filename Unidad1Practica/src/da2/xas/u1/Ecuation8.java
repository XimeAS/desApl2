package da2.xas.u1;

import java.io.Serializable;

public class Ecuation8 implements Serializable{
	
	private double valx;
	private double valy;
	
	public double getValx() {
		return valx;
	}
	public void setValx(double valx) {
		this.valx = valx;
	}
	public double getValy() {
		return valy;
	}
	public void setValy(double valy) {
		this.valy = valy;
	}
	public double getEcu() {
		return (5*(Math.sqrt(valx*valy)-3)-(2-4*(Math.sqrt(valx*valy))));
	}
	
	@Override
	public String toString() {
		return "Ecuation8 [valx=" + valx + ", valy=" + valy + "]";
	}
	


	
}
