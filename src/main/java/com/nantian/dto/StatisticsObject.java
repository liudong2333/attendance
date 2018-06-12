/**
 * 
 */
package com.nantian.dto;

import java.util.List;

/**
 * @author ld
 * @date 2018年6月1日 用于存储统计出来的数据
 */
public class StatisticsObject {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 加班时间(分钟)
	private float totaltimeminutes;
	
	// 加班时间(小时)
	private float totaltimehours;

	// 用于存储集中开发的天数
	private int jizhongkaifa;

	public float getTotaltimehours() {
		return totaltimehours;
	}

	public void setTotaltimehours(float totaltimehours) {
		this.totaltimehours = totaltimehours;
	}

	// 用于存储有哪些天集中开发
	private List<String> daysjizhongkaifa;
	// 用于存储未打卡天数
	private int weidaka;
	// 用于存储有哪些天全天未打卡
	private List<String> daysweidaka;
	// 用于存储上班未打卡天数
	private int shangbanweidaka;
	// 用于存储哪些天上班未打卡
	private List<String> daysshangbanweidaka;
	// 用于存储下班未打卡天数
	private int xiabanweidaka;
	// 用于存储哪些天下班未打卡
	private List<String> daysxiabanweidaka;
	// 用于存储早退天数
	private int zaotui;
	// 用于存储有哪些天早退
	private List<String> dayszaotui;
	// 用于存储迟到天数
	private int chidao;
	// 用于存储有哪些天迟到
	private List<String> dayschidao;

	public float getTotaltimeminutes() {
		return totaltimeminutes;
	}

	public void setTotaltimeminutes(float totaltimeminutes) {
		this.totaltimeminutes = totaltimeminutes;
	}

	public int getJizhongkaifa() {
		return jizhongkaifa;
	}

	public void setJizhongkaifa(int jizhongkaifa) {
		this.jizhongkaifa = jizhongkaifa;
	}

	public List<String> getDaysjizhongkaifa() {
		return daysjizhongkaifa;
	}

	public void setDaysjizhongkaifa(List<String> daysjizhongkaifa) {
		this.daysjizhongkaifa = daysjizhongkaifa;
	}

	public int getWeidaka() {
		return weidaka;
	}

	public void setWeidaka(int weidaka) {
		this.weidaka = weidaka;
	}

	public List<String> getDaysweidaka() {
		return daysweidaka;
	}

	public void setDaysweidaka(List<String> daysweidaka) {
		this.daysweidaka = daysweidaka;
	}

	public int getShangbanweidaka() {
		return shangbanweidaka;
	}

	public void setShangbanweidaka(int shangbanweidaka) {
		this.shangbanweidaka = shangbanweidaka;
	}

	public List<String> getDaysshangbanweidaka() {
		return daysshangbanweidaka;
	}

	public void setDaysshangbanweidaka(List<String> daysshangbanweidaka) {
		this.daysshangbanweidaka = daysshangbanweidaka;
	}

	public int getXiabanweidaka() {
		return xiabanweidaka;
	}

	public void setXiabanweidaka(int xiabanweidaka) {
		this.xiabanweidaka = xiabanweidaka;
	}

	public List<String> getDaysxiabanweidaka() {
		return daysxiabanweidaka;
	}

	public void setDaysxiabanweidaka(List<String> daysxiabanweidaka) {
		this.daysxiabanweidaka = daysxiabanweidaka;
	}

	public int getZaotui() {
		return zaotui;
	}

	public void setZaotui(int zaotui) {
		this.zaotui = zaotui;
	}

	public List<String> getDayszaotui() {
		return dayszaotui;
	}

	public void setDayszaotui(List<String> dayszaotui) {
		this.dayszaotui = dayszaotui;
	}

	public int getChidao() {
		return chidao;
	}

	public void setChidao(int chidao) {
		this.chidao = chidao;
	}

	public List<String> getDayschidao() {
		return dayschidao;
	}

	public void setDayschidao(List<String> dayschidao) {
		this.dayschidao = dayschidao;
	}

}
