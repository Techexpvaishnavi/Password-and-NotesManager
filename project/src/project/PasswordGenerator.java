package project;

import java.security.SecureRandom;

public class PasswordGenerator {

	private static final SecureRandom rdm = new SecureRandom();
	private static final String caps="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String s_caps="abcdefghijklmnopqrstuvwxyz";
	private static final String num="012356789";
	private static final  String  special_char  ="~!@#$%^&*(+{}[]?<>|_=:";
	private static final  String dic= caps + s_caps + num + special_char;
	public String generatePsw(int len)
	{
		StringBuilder psw=new StringBuilder();
		for(int i=0;i<len;i++)
		{
			int index=rdm.nextInt(dic.length());
			psw.append(dic.charAt(index));
		}
		return psw.toString();
		}

}
