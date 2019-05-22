package com.tnpy.wcpsproject.model.mysql;

public class TbRole {


	private String id;

	private String name;

	private String roleinfo;

	private String status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getRoleinfo() {
		return roleinfo;
	}

	public void setRoleinfo(String roleinfo) {
		this.roleinfo = roleinfo == null ? null : roleinfo.trim();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}


}