package ERS;

public class pastBean {
	
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public pastBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public pastBean(int id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "pastBean [id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		pastBean other = (pastBean) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
}
