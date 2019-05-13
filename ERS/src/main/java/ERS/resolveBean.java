package ERS;

public class resolveBean {

	private int status;
	private int id;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public resolveBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public resolveBean(int status, int id) {
		super();
		this.status = status;
		this.id = id;
	}
	@Override
	public String toString() {
		return "resolveBean [status=" + status + ", id=" + id + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + status;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		resolveBean other = (resolveBean) obj;
		if (id != other.id)
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	
	
	
}
