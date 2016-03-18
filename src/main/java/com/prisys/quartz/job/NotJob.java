package com.prisys.quartz.job;


import org.springframework.stereotype.Service;

@Service("notBean")
//@Repository("notBean")
public class NotJob {
    private int i=0;
	public void pri(){
		i++;
		System.out.println("相加后的值为："+i);
	}

}
