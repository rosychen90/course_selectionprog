package vo;

import java.util.List;

public class PersonVo {
	protected String id ;
	protected String name ;
	protected String password ;
	protected int sex;//�Ա�  1�� 0Ů
	// ���������ڱ���ȫ��������Ϣ
	protected List<String> errors ;

	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public int getSex() {
		return sex;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public boolean invalidate()
	{
		boolean flag = true ;
		// ��֤ID
		if(this.id==null||"".equals(this.id))
		{
			flag = false ;
			errors.add("ID����Ϊ�գ�") ;
		}
		else
		{
			// ���г�����֤��3~10λ
			if(this.id.length()<3||this.id.length()>10)
			{
				flag = false ;
				errors.add("ID�ĳ���ӦΪ3~10λ��") ;
			}
		}
		// ��֤����
		if(this.password==null||"".equals(this.password))
		{
			flag = false ;
			errors.add("���벻��Ϊ�գ�") ;
		}
		else
		{
			// ���г�����֤��3~10λ
			if(this.password.length()<3||this.password.length()>10)
			{
				flag = false ;
				errors.add("����ĳ���ӦΪ3~10λ��") ;
			}
		}
		return flag ;
	}
	
}
