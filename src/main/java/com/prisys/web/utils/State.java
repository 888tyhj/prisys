package com.prisys.web.utils;

/**
 * enum枚举类型是一个不可以被继承的final类，就以上面的State枚举为例，如果你查看enum类型的字节码，其实是State类型的类静态常量
 * @author yangl
 *
 */
public enum State implements ICanReadState{
	Normal("正常", 1), Update("已更新", 2), Deleted("已删除", 3), Fired("已屏蔽", 4);
	private String name;
	private int index;

	private State(String name, int index) {
		this.name = name;
		this.index = index;
	}

	
	public void read() {
		System.out.println(this.index + ":" + this.name);
	}

	
	public String getState() {
		return this.name;
	}

}
