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
	
	public static final String SELECT_USER_BY_PASS = "SELECT * FROM TB_USER WHERE USID=? AND PASS=STANDARD_HASH(?, 'SHA256')";
	public static final String INSERT_USER = "insert into TB_USER (usid, pass, us_name, nick, email, hp, zip, addr1, addr2, reg_ip,reg_date) " + 
											 "values (?,STANDARD_HASH(?,'SHA256'),?,?,?,?,?,?,?,?,sysdate)";

	// article
		public static final String SELECT_COUNT_TOTAL = "SELECT COUNT(*) FROM TB_ARTICLE";
		public static final String SELECT_ARTICLE_ALL = "SELECT A.*, U.nick FROM TB_ARTICLE A "
														+ "JOIN TB_USER U  ON A.WRITER = U.USID "
														+ "ORDER BY ANO DESC "
														+ "OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY";
		
		public static final String SELECT_MAX_ANO = "SELECT MAX(ANO) FROM TB_ARTICLE";
		public static final String INSERT_ARTICLE = "INSERT INTO TB_ARTICLE (TITLE, CONTENT, FILE_CNT, WRITER, REG_IP, WDATE) VALUES (?, ?, ?, ?, ?, SYSDATE)";
		
		
		// file
		public static final String INSERT_FILE = "INSERT INTO TB_FILE (ANO, ONAME, SNAME, RDATE) VALUES (?, ?, ?, SYSDATE)";
}
