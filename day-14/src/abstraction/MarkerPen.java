package abstraction;

import interfaces.Purchasable;

public class MarkerPen extends Pen implements Purchasable {
	@Override
	public void write() {
		System.out.println("*writes roughly in ink*");
	}
	
	@Override
	public void isPurchasable() {
		System.out.println("can be purchased!");
	}
	
	
// 	@Override
//	public void isDoable() {
//		System.out.println("can be purchased!");
//	}
//	
}
