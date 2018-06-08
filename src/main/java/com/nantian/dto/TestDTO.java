package com.nantian.dto;

public class TestDTO {

	private String jizhanming;
	private double weidu;

	public String getJizhanming() {
		return jizhanming;
	}

	public void setJizhanming(String jizhanming) {
		this.jizhanming = jizhanming;
	}

	public double getWeidu() {
		return weidu;
	}

	public void setWeidu(double weidu) {
		this.weidu = weidu;
	}

	@Override
	public String toString() {
		return "TestDTO [jizhanming=" + jizhanming + ", weidu=" + weidu + "]";
	}

	
}
