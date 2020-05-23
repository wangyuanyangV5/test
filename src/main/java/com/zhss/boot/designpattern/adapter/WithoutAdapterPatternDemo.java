package com.zhss.designpattern.adapter;

/**
 * 不用设计模式的实现
 * @author zhonghuashishan
 *
 */
public class WithoutAdapterPatternDemo {
	
	public static void main(String[] args) {
		OldInterface oldObject = new OldInterfaceImpl();
		NewInterface newObject = new NewInterfaceImpl();
		oldObject.oldExecute();
		newObject.newExecute();
		
		// 如果不用任何设计模式，我们的问题在哪儿？
		// 问题其实很明显，就是说，我们的新的代码中，融合了新老两套接口，很麻烦的一个事情
		// 首先如果你这么干的话，就会导致代码很恶心，面向的是规范和风格完全不同的两套接口，你理解和维护的成本提高了
		// 其次，假如说，现在都不给你选择使用老版本接口的机会
		// 直接强制性公司规范要求按照新版本接口来走，你的老版本接口的实现类，就没法用了啊？
		// 难不成还要基于新版本的接口重新写一套？
	}
	
	/**
	 * 老版本接口
	 * @author zhonghuashishan
	 *
	 */
	public static interface OldInterface {
	
		void oldExecute();
		
	}
	
	/**
	 * 老版本接口的实现类
	 * @author zhonghuashishan
	 *
	 */
	public static class OldInterfaceImpl implements OldInterface {

		public void oldExecute() {
			System.out.println("老版本接口实现的功能逻辑");  
		}
		
	}
	
	/**
	 * 新版本接口
	 * @author zhonghuashishan
	 *
	 */
	public static interface NewInterface {
	
		void newExecute();
		
	}
	
	/**
	 * 新版本接口的实现类
	 * @author zhonghuashishan
	 *
	 */
	public static class NewInterfaceImpl implements NewInterface {

		public void newExecute() {
			System.out.println("新版本接口实现的功能逻辑");  
		}
		
	}
	
}
