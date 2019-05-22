package com.tnpy.wcpsproject.model.mysql;

public class TbLaissezPasserInfo {
    private String id;

    private String laissezpasserid;

    private String carlicence;

    private String stoplocation;

    private String starttime;

    private String endtime;

    private String updatetime;

    private String operator;

    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getLaissezpasserid() {
        return laissezpasserid;
    }

    public void setLaissezpasserid(String laissezpasserid) {
        this.laissezpasserid = laissezpasserid == null ? null : laissezpasserid.trim();
    }

    public String getCarlicence() {
        return carlicence;
    }

    public void setCarlicence(String carlicence) {
        this.carlicence = carlicence == null ? null : carlicence.trim();
    }

    public String getStoplocation() {
        return stoplocation;
    }

    public void setStoplocation(String stoplocation) {
        this.stoplocation = stoplocation == null ? null : stoplocation.trim();
    }

    public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}