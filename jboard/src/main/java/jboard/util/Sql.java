package jboard.util;

public class Sql {
	//terms
	public static final String SELECT_TERMS = "select * from TB_TERMS where no=?";	
	
	//user
	public static final String SELECT_COUNT = "select count(*) from tb_user ";
	public static final String WHERE_USID = "where usid=?";
	public static final String WHERE_NICK = "where nick=?";
	public static final String WHERE_EMAIL = "where email=?";
	public static final String WHERE_HP = "where hp=?";
	
	public static final String INSERT_USER = "insert into TB_USER (usid, pass, us_name, nick, email, hp, zip, addr1, addr2, reg_ip,reg_date) " + 
											 "values (?,STANDARD_HASH(?,'SHA256'),?,?,?,?,?,?,?,?,sysdate)";
}
