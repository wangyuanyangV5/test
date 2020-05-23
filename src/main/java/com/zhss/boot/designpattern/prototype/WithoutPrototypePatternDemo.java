package com.zhss.designpattern.prototype;

public class WithoutPrototypePatternDemo {
	
	public static void main(String[] args) {
		// 手头有这么一个对象，需要进行拷贝
		Product product = new Product("测试产品", new Component("测试组件"));  
		// 手动来拷贝
		Product copyProduct = new Product(product.getName(), product.getComponent());
		System.out.println(copyProduct);  
		
		// 问题是什么？
		// 代码的拷贝逻辑，是每个要拷贝的调用方自己来实现的
		// 相同的拷贝逻辑会分散在很多不同的地方，如果拷贝逻辑改变了，多个调用的地方都要修改代码
		// 可维护性、可扩展性，很差
	}
	
	public static class  Component {
		
		private String name;

		public Component(String name) {
			super();
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Component [name=" + name + "]";
		}
		
	}
	
	public static class Product {
		
		private String name;
		private Component component;
		
		public Product(String name, Component component) {
			super();
			this.name = name;
			this.component = component;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Component getComponent() {
			return component;
		}
		public void setComponent(Component component) {
			this.component = component;
		}
		
		@Override
		public String toString() {
			return "Product [name=" + name + ", component=" + component + "]";
		}
		
	}
	
}
