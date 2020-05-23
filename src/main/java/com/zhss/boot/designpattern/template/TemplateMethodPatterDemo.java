package com.zhss.designpattern.template;

/**
 * 使用了模板方法模式
 * @author zhonghuashishan
 *
 */
public class TemplateMethodPatterDemo {

	public static void main(String[] args) {
		DiscountCalculator calculator1 = new DiscountCalculator1();
		calculator1.calculate();
		
		DiscountCalculator calculator2 = new DiscountCalculator2();
		calculator2.calculate();
		
		DiscountCalculator calculator3 = new DiscountCalculator3();
		calculator3.calculate();
	}
	
	public interface DiscountCalculator {
		
		void calculate();
		
	}
	
	/**
	 * 模板方法实现的精华所在
	 * @author zhonghuashishan
	 *
	 */
	public static abstract class AbstractDiscountCalculator implements DiscountCalculator {
		
		public void calculate() {
			// 完成通用的计算逻辑
			commonCalculate();
			// 完成特殊的计算逻辑
			specificCalculate();
		}
		
		private void commonCalculate() {
			System.out.println("通用的计算逻辑，修改了一下");
		}
		
		protected abstract void specificCalculate();
		
	}
	
	public static class DiscountCalculator1 extends AbstractDiscountCalculator {
		
		public void specificCalculate() {
			System.out.println("优惠计算器1的特殊计算逻辑");  
		}
		
	}
	
	public static class DiscountCalculator2 extends AbstractDiscountCalculator {
			
		public void specificCalculate() {
			System.out.println("优惠计算器2的特殊计算逻辑");  
		}
		
	}
	
	public static class DiscountCalculator3 extends AbstractDiscountCalculator {
		
		public void specificCalculate() {
			System.out.println("优惠计算器3的特殊计算逻辑");  
		}
		
	}
	
}
