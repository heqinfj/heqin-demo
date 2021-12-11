package com.heqin.oopinherit;

public class Student extends Person {

	protected int score;

	public Student(String name, int age, int score) {
		super(name, age);
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public void hello(){
		//System.out.println("Hello, " + super.privateVariable);//编译报错：'privateVariable' has private access in 'com.heqin.oopinherit.Person'

		/**
		 * 定义为private的field、method无法被其他类访问：
		 * 实际上，确切地说，private访问权限被限定在class的内部
		 */
	}

}
