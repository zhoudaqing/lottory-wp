package com.unison.lottery.weibo.data.service.store.persist.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 篮球欧赔PO
 * 
 * @author Yang Bo
 */
@Entity
@Table(name = "md_bb_odds_euro")
public class BBOddsEuroPO {
	@Id
	private int id;
	private long matchId;
	private long corpId;
	private BigDecimal initHomeWinOdds;
	private BigDecimal initGuestWinOdds;
	private BigDecimal realtimeHomeWinOdds;
	private BigDecimal realtimeGuestWinOdds;
	private Date createTime;
	private Date updateTime;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public long getMatchId() {
		return matchId;
	}
	public void setMatchId(long matchId) {
		this.matchId = matchId;
	}
	public long getCorpId() {
		return corpId;
	}
	public void setCorpId(long corpId) {
		this.corpId = corpId;
	}
	public BigDecimal getInitHomeWinOdds() {
		return initHomeWinOdds;
	}
	public void setInitHomeWinOdds(BigDecimal initHomeWinOdds) {
		this.initHomeWinOdds = initHomeWinOdds;
	}
	public BigDecimal getInitGuestWinOdds() {
		return initGuestWinOdds;
	}
	public void setInitGuestWinOdds(BigDecimal initGuestWinOdds) {
		this.initGuestWinOdds = initGuestWinOdds;
	}
	public BigDecimal getRealtimeHomeWinOdds() {
		return realtimeHomeWinOdds;
	}
	public void setRealtimeHomeWinOdds(BigDecimal realtimeHomeWinOdds) {
		this.realtimeHomeWinOdds = realtimeHomeWinOdds;
	}
	public BigDecimal getRealtimeGuestWinOdds() {
		return realtimeGuestWinOdds;
	}
	public void setRealtimeGuestWinOdds(BigDecimal realtimeGuestWinOdds) {
		this.realtimeGuestWinOdds = realtimeGuestWinOdds;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String toString(){
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}