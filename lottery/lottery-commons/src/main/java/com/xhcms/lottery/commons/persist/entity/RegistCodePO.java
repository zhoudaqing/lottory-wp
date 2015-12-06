package com.xhcms.lottery.commons.persist.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 邀请码类
 * @author haohao
 *
 */
@Entity
@Table(name="registration_code")
public class RegistCodePO implements Serializable{

	private static final long serialVersionUID = -1213237411224683939L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String code;
	
	private int status;//是否有效 0 无效 1有效 2过期 
	
	@Column(name="user_id")
	private long userId;
	
	@Column(name="end_time")
	private Date endTime;
	
	private long vid;    //验证码所属大Vid
	
	@Column(name="create_time")
	private Date createTime; //验证码创建时间
	
	@Column(name="used_time")
	private Date usedTime;//验证码使用时间
	
	public RegistCodePO(){
		
	}
	public RegistCodePO(long genvid) {
		this.vid=genvid;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public long getVid() {
		return vid;
	}
	public void setVid(long vid) {
		this.vid = vid;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUsedTime() {
		return usedTime;
	}
	public void setUsedTime(Date usedTime) {
		this.usedTime = usedTime;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
}