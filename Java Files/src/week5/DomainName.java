package week5;

public class DomainName {
	private String name;

	/**
	 * @param name
	 */
	public DomainName(String newName) {
		this.name = newName;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String newName) {
		this.name = newName;
	}

	public String toString() {
		return this.name;
	}
	
	public boolean equals(Object obj) {
		if (!(obj instanceof DomainName)) {
			return false;
		}
		else {
			DomainName other = (DomainName) obj;
			return this.name.equals(other.name);
		}
	}
	
	/**
	 * Check if the domain name starts with www
	 * @return boolean
	 */
	public boolean isWebDomain() {
		if (this.name.startsWith("www.")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Get the extension of the domain name
	 * @return String
	 */
	public String getExtension() {
		return this.name.substring(this.name.lastIndexOf('.'));
	}
	
	/**
	 * Get the middle bit of the domain name
	 * @return String
	 */
	public String getMiddle() {
		return this.name.substring(this.name.indexOf('.') + 1, this.name.lastIndexOf('.'));
	}
	
    public static void main(String[] args) {
        DomainName dn = new DomainName("www.artofproblemsolving.com");
        System.out.println("Starts with www: "+dn.isWebDomain());
        System.out.println("Extension: "+dn.getExtension());
        System.out.println("Actual name: "+dn.getMiddle());
    }
	
}
