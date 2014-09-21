package vo;

import java.util.List;

public class PersonVo {
	protected String id ;
	protected String name ;
	protected String password ;
	protected int sex;//性别  1男 0女
	// 此属性用于保存全部错误信息
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
		// 验证ID
		if(this.id==null||"".equals(this.id))
		{
			flag = false ;
			errors.add("ID不能为空！") ;
		}
		else
		{
			// 进行长度验证：3~10位
			if(this.id.length()<3||this.id.length()>10)
			{
				flag = false ;
				errors.add("ID的长度应为3~10位！") ;
			}
		}
		// 验证密码
		if(this.password==null||"".equals(this.password))
		{
			flag = false ;
			errors.add("密码不能为空！") ;
		}
		else
		{
			// 进行长度验证：3~10位
			if(this.password.length()<3||this.password.length()>10)
			{
				flag = false ;
				errors.add("密码的长度应为3~10位！") ;
			}
		}
		return flag ;
	}
	
}
